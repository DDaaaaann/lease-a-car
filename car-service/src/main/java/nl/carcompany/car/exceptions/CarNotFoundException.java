package nl.carcompany.car.exceptions;

public class CarNotFoundException extends RuntimeException {

  public CarNotFoundException(final Long id) {
    super(String.format("Car with id '%s' not found", id));
  }

}
