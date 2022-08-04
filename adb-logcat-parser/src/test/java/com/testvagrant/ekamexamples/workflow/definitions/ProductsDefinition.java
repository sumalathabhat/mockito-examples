package com.testvagrant.ekamexamples.workflow.definitions;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekamexamples.data.models.Product;
import com.testvagrant.ekamexamples.mobile.screens.android.ProductsScreen;
import com.testvagrant.ekamexamples.workflow.FulfillCondition;
import com.testvagrant.ekamexamples.workflow.WorkflowDefinition;
import com.testvagrant.ekamexamples.workflow.models.UseCase;

public class ProductsDefinition extends WorkflowDefinition {

  private final Product product;
  FulfillCondition<ProductsDefinition> navToCartFulfillCondition =
      () -> {
        Product product =
            LayoutInitiator.Screen(ProductsScreen.class)
                .selectProduct(useCase.getData(Product.class));
        useCase.addToUseCase(product);
        LayoutInitiator.Screen(ProductsScreen.class).navToCart();
        return this;
      };
  FulfillCondition<ProductsDefinition> navToMenuFulfillCondition =
      () -> {
        LayoutInitiator.Screen(ProductsScreen.class).navToMenu();
        return this;
      };

  public ProductsDefinition(UseCase useCase) {
    super(useCase);
    this.product = useCase.getData(Product.class);
  }

  @Override
  public ProductsDefinition next() {
    return this;
  }

  @Override
  public ProductsScreen create() {
    return LayoutInitiator.Screen(ProductsScreen.class);
  }

  public CartDefinition cart() {
    return proceedToNext(navToCartFulfillCondition, new CartDefinition(useCase));
  }

  public MenuDefinition menu() {
    return proceedToNext(navToMenuFulfillCondition, new MenuDefinition(useCase));
  }
}
