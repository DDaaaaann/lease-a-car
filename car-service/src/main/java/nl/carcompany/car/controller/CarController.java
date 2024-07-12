package nl.carcompany.car.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;
import lombok.RequiredArgsConstructor;
import nl.carcompany.car.service.impl.CarServiceImpl;
import nl.carcompany.lease.api.CarsApi;
import nl.carcompany.lease.model.CarDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CarController implements CarsApi {

  private final CarServiceImpl carService;

  @Override
  public ResponseEntity<CarDto> addCar(final CarDto carDto) {
    return ok(carService.createCar(carDto));
  }

  @Override
  public ResponseEntity<Void> deleteCar(final Long id) {
    carService.deleteCar(id);
    return ok().build();
  }

  @Override
  public ResponseEntity<CarDto> getCarById(final Long id) {
    return ok(carService.findById(id));
  }

  @Override
  public ResponseEntity<List<CarDto>> getCars() {
    return ok(carService.findAll());
  }

  @Override
  public ResponseEntity<Void> updateCar(final Long id, final CarDto carDto) {
    carService.updateCar(id, carDto);
    return ok().build();
  }
}
