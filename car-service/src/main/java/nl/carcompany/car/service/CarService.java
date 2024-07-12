package nl.carcompany.car.service;

import java.util.List;
import nl.carcompany.rest.lease.model.CarDto;

public interface CarService {

  CarDto createCar(CarDto carDto);

  void deleteCar(Long id);

  CarDto findById(Long id);

  List<CarDto> findAll();

  void updateCar(Long id, CarDto carDto);
}
