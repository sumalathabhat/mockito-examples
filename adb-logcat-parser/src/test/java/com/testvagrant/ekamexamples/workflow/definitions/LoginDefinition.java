package com.testvagrant.ekamexamples.workflow.definitions;

import com.testvagrant.ekamexamples.data.models.Credentials;
import com.testvagrant.ekamexamples.mobile.screens.android.LoginScreen;
import com.testvagrant.ekamexamples.workflow.FulfillCondition;
import com.testvagrant.ekamexamples.workflow.WorkflowDefinition;
import com.testvagrant.ekamexamples.workflow.models.UseCase;

import static com.testvagrant.ekam.commons.LayoutInitiator.Screen;

public class LoginDefinition extends WorkflowDefinition {

  protected FulfillCondition<LoginDefinition> loginCondition =
      () -> {
        create().login(useCase.getData(Credentials.class), LoginScreen.class);
        return this;
      };

  public LoginDefinition(UseCase useCase) {
    super(useCase);
  }

  @Override
  public ProductsDefinition next() {
    return proceedToNext(loginCondition, new ProductsDefinition(useCase));
  }

  @Override
  public LoginScreen create() {
    return Screen(LoginScreen.class);
  }
}
