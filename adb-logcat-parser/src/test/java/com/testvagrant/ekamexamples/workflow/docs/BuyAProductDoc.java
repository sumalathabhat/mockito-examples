package com.testvagrant.ekamexamples.workflow.docs;

import com.testvagrant.ekamexamples.workflow.WorkflowDoc;
import com.testvagrant.ekamexamples.workflow.definitions.*;
import com.testvagrant.ekamexamples.workflow.models.UseCase;

public class BuyAProductDoc extends WorkflowDoc {

  public BuyAProductDoc(UseCase useCase) {
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

  public CartDefinition cart() {
    return products().cart();
  }

  public MenuDefinition menu() {
    return products().menu();
  }

  public CheckoutDefinition checkout() {
    return cart().next();
  }

  public ConfirmationDefinition confirmation() {
    return checkout().next();
  }
}
