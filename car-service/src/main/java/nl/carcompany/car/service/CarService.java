package nl.carcompany.car.service;

import java.util.List;
import nl.carcompany.rest.lease.model.CarDto;
import nl.carcompany.rest.lease.model.CarResponseDto;

public interface CarService {

  CarResponseDto createCar(CarDto carDto);

  void deleteCar(Long id);

  CarResponseDto findById(Long id);

  List<CarResponseDto> findAll();

  void updateCar(Long id, CarDto carDto);
}
