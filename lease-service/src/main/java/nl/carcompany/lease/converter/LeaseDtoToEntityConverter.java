package nl.carcompany.lease.converter;

import nl.carcompany.lease.entity.LeaseEntity;
import nl.carcompany.rest.lease.model.LeaseDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LeaseDtoToEntityConverter implements Converter<LeaseDto, LeaseEntity> {

  @Override
  public LeaseEntity convert(final LeaseDto leaseDto) {
    final LeaseEntity leaseEntity = new LeaseEntity();
    leaseEntity.setCarId(leaseDto.getCarId());
    leaseEntity.setCustomerId(leaseDto.getCustomerId());

    leaseEntity.setDuration(leaseDto.getDuration());
    leaseEntity.setMileage(leaseEntity.getMileage());
    leaseEntity.setInterest(leaseEntity.getInterest());
    leaseEntity.setStartDate(leaseDto.getStartDate());
    return leaseEntity;
  }
}
