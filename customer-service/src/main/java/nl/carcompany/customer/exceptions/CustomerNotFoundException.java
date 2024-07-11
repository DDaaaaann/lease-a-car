package nl.carcompany.customer.exceptions;

public class CustomerNotFoundException extends RuntimeException {

  public CustomerNotFoundException(final Long id) {
    super(String.format("Customer with id '%s' not found", id));
  }

}
