package com.testvagrant.ekamexamples.workflow.definitions;

import com.testvagrant.ekamexamples.data.models.Address;
import com.testvagrant.ekamexamples.mobile.screens.android.CheckoutScreen;
import com.testvagrant.ekamexamples.workflow.FulfillCondition;
import com.testvagrant.ekamexamples.workflow.WorkflowDefinition;
import com.testvagrant.ekamexamples.workflow.models.UseCase;

import static com.testvagrant.ekam.commons.LayoutInitiator.Screen;

public class CheckoutDefinition extends WorkflowDefinition {

  public CheckoutDefinition(UseCase useCase) {
    super(useCase);
  }

  @Override
  public ConfirmationDefinition next() {
    return proceedToNext(fulfillCondition(), new ConfirmationDefinition(useCase));
  }

  @Override
  public CheckoutScreen create() {
    return Screen(CheckoutScreen.class);
  }

  protected FulfillCondition<CheckoutDefinition> fulfillCondition() {
    return () -> {
      try {
        Screen(CheckoutScreen.class).checkout(useCase.getData(Address.class));
      } catch (Exception e) {
        // e.printStackTrace();
      }
      return this;
    };
  }
}
