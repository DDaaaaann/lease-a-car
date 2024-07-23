package nl.carcompany.car.converter;

import nl.carcompany.car.entity.CarEntity;
import nl.carcompany.rest.lease.model.CarResponseDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CarEntityToResponseDtoConverter implements Converter<CarEntity, CarResponseDto> {

  @Override
  public CarResponseDto convert(final CarEntity carEntity) {
    final CarResponseDto carResponseDto = new CarResponseDto();
    carResponseDto.setId(carEntity.getId());
    carResponseDto.setMake(carEntity.getMake());
    carResponseDto.setModel(carEntity.getModel());
    carResponseDto.setVersion(carEntity.getVersion());
    carResponseDto.setNumberOfDoors(carEntity.getNumberOfDoors());
    carResponseDto.setCo2Emission(carEntity.getCo2Emission());
    carResponseDto.setGrossPrice(carEntity.getGrossPrice());
    carResponseDto.setNettPrice(carEntity.getNettPrice());
    return carResponseDto;
  }
}
