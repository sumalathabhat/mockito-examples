package com.testvagrant.ekamexamples.workflow.definitions;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekamexamples.mobile.screens.android.CartScreen;
import com.testvagrant.ekamexamples.workflow.FulfillCondition;
import com.testvagrant.ekamexamples.workflow.WorkflowDefinition;
import com.testvagrant.ekamexamples.workflow.models.UseCase;

public class CartDefinition extends WorkflowDefinition {

  public CartDefinition(UseCase useCase) {
    super(useCase);
  }

  @Override
  public CheckoutDefinition next() {
    return proceedToNext(fulfillCondition(), new CheckoutDefinition(useCase));
  }

  @Override
  public CartScreen create() {
    return LayoutInitiator.Screen(CartScreen.class);
  }

  protected FulfillCondition<CartDefinition> fulfillCondition() {
    return () -> {
      create().navToCheckout();
      return this;
    };
  }
}
