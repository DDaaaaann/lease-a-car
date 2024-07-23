package nl.carcompany.car.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import nl.carcompany.car.converter.CarDtoToEntityConverter;
import nl.carcompany.car.converter.CarEntityToResponseDtoConverter;
import nl.carcompany.car.entity.CarEntity;
import nl.carcompany.car.exceptions.CarNotFoundException;
import nl.carcompany.car.exceptions.NoUniqueResultException;
import nl.carcompany.car.repository.CarRepository;
import nl.carcompany.car.service.CarService;
import nl.carcompany.rest.lease.model.CarDto;
import nl.carcompany.rest.lease.model.CarResponseDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

  private final CarRepository carRepository;
  private final CarDtoToEntityConverter dtoToEntityConverter;
  private final CarEntityToResponseDtoConverter entityToResponseDtoConverter;


  @Override
  public CarResponseDto createCar(final CarDto carDto) {
    final CarEntity carEntity = dtoToEntityConverter.convert(carDto);
    final CarEntity savedCar = carRepository.save(carEntity);
    return entityToResponseDtoConverter.convert(savedCar);
  }

  @Override
  public void deleteCar(final Long id) {
    carRepository.deleteById(id);
  }

  @Override
  public CarResponseDto findById(final Long id) {
    final CarEntity customerEntity = carRepository.findById(id)
        .orElseThrow(() -> new NoUniqueResultException(id));
    return entityToResponseDtoConverter.convert(customerEntity);
  }

  @Override
  public List<CarResponseDto> findAll() {
    final List<CarEntity> customerEntities = carRepository.findAll();
    return customerEntities.stream()
        .map(entityToResponseDtoConverter::convert)
        .collect(Collectors.toList());
  }

  @Override
  public void updateCar(final Long id, final CarDto carDto) {
    final CarEntity carEntityToUpdate = carRepository.findById(id).orElseThrow(
        () -> new CarNotFoundException(id));

    carEntityToUpdate.setMake(carDto.getMake());
    carEntityToUpdate.setModel(carDto.getModel());
    carEntityToUpdate.setVersion(carDto.getVersion());
    carEntityToUpdate.setNumberOfDoors(carDto.getNumberOfDoors());
    carEntityToUpdate.setCo2Emission(carDto.getCo2Emission());
    carEntityToUpdate.setGrossPrice(carDto.getGrossPrice());
    carEntityToUpdate.setNettPrice(carDto.getNettPrice());

    carRepository.save(carEntityToUpdate);
  }
}
