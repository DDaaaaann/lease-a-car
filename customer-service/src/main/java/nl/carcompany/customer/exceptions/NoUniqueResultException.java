package nl.carcompany.customer.exceptions;

public class NoUniqueResultException extends RuntimeException {

  public NoUniqueResultException(final Long id) {
    super(String.format("No unique result for id: %s", id));
  }

}
