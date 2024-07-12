package nl.carcompany.lease.converter;

import lombok.RequiredArgsConstructor;
import nl.carcompany.lease.entity.LeaseEntity;
import nl.carcompany.lease.model.LeaseDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LeaseEntityToDtoConverter implements Converter<LeaseEntity, LeaseDto> {

  @Override
  public LeaseDto convert(final LeaseEntity leaseEntity) {
    final LeaseDto leaseDto = new LeaseDto();

//    TODO: create restclient
//    leaseDto.setCar(leaseEntity.getCarId());
//    leaseDto.setCustomer(leaseEntity.getCustomerId());

    leaseDto.setId(leaseEntity.getId());
    leaseDto.setDuration(leaseEntity.getDuration());
    leaseDto.setInterest(leaseEntity.getInterest());
    leaseDto.setMileage(leaseEntity.getMileage());
    leaseDto.setStartDate(leaseEntity.getStartDate());

    return leaseDto;
  }
}
