package com.testvagrant.ekamexamples.workflow.definitions;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekamexamples.mobile.screens.android.MenuScreen;
import com.testvagrant.ekamexamples.workflow.WorkflowDefinition;
import com.testvagrant.ekamexamples.workflow.models.UseCase;

public class MenuDefinition extends WorkflowDefinition {

  public MenuDefinition(UseCase useCase) {
    super(useCase);
  }

  @Override
  public MenuDefinition next() {
    return this;
  }

  @Override
  public MenuScreen create() {
    return LayoutInitiator.Screen(MenuScreen.class);
  }
}
