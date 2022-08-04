package com.testvagrant.ekamexamples.workflow.definitions;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekamexamples.mobile.screens.android.ConfirmationScreen;
import com.testvagrant.ekamexamples.workflow.WorkflowDefinition;
import com.testvagrant.ekamexamples.workflow.models.UseCase;

public class ConfirmationDefinition extends WorkflowDefinition {

  public ConfirmationDefinition(UseCase useCase) {
    super(useCase);
  }

  @Override
  public ConfirmationDefinition next() {
    return this;
  }

  @Override
  public ConfirmationScreen create() {
    return LayoutInitiator.Screen(ConfirmationScreen.class);
  }
}
