package com.testvagrant.ekamexamples.workflow.docs;

import com.testvagrant.ekamexamples.workflow.WorkflowDoc;
import com.testvagrant.ekamexamples.workflow.definitions.LoginDefinition;
import com.testvagrant.ekamexamples.workflow.definitions.MenuDefinition;
import com.testvagrant.ekamexamples.workflow.definitions.ProductsDefinition;
import com.testvagrant.ekamexamples.workflow.models.UseCase;

public class MenuDoc extends WorkflowDoc {

  public MenuDoc(UseCase useCase) {
    super(useCase);
  }

  // Entry workflow
  public LoginDefinition login() {
    return new LoginDefinition(useCase);
  }

  // Keep building on top of that
  public ProductsDefinition products() {
    return login().next();
  }

  public MenuDefinition menu() {
    return products().menu();
  }
}
