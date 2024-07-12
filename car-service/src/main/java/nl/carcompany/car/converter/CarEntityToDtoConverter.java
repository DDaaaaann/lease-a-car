package nl.carcompany.car.converter;

import nl.carcompany.car.entity.CarEntity;
import nl.carcompany.lease.model.CarDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CarEntityToDtoConverter implements Converter<CarEntity, CarDto> {

  @Override
  public CarDto convert(final CarEntity carEntity) {
    final CarDto carDto = new CarDto();
    carDto.setId(carEntity.getId());
    carDto.setMake(carEntity.getMake());
    carDto.setModel(carEntity.getModel());
    carDto.setVersion(carEntity.getVersion());
    carDto.setNumberOfDoors(carEntity.getNumberOfDoors());
    carDto.setCo2Emission(carEntity.getCo2Emission());
    carDto.setGrossPrice(carEntity.getGrossPrice());
    carDto.setNettPrice(carEntity.getNettPrice());
    return carDto;
  }
}
