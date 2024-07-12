package nl.carcompany.car.converter;

import nl.carcompany.car.entity.CarEntity;
import nl.carcompany.lease.model.CarDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CarDtoToEntityConverter implements Converter<CarDto, CarEntity> {

  @Override
  public CarEntity convert(final CarDto carDto) {
    final CarEntity carEntity = new CarEntity();
    carEntity.setId(carDto.getId());
    carEntity.setMake(carDto.getMake());
    carEntity.setModel(carDto.getModel());
    carEntity.setVersion(carDto.getVersion());
    carEntity.setNumberOfDoors(carDto.getNumberOfDoors());
    carEntity.setCo2Emission(carDto.getCo2Emission());
    carEntity.setGrossPrice(carDto.getGrossPrice());
    carEntity.setNettPrice(carDto.getNettPrice());
    return carEntity;

  }
}
