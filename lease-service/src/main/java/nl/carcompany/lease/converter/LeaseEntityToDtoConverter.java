package nl.carcompany.lease.converter;

import lombok.RequiredArgsConstructor;
import nl.carcompany.lease.entity.LeaseEntity;
import nl.carcompany.rest.lease.api.CarClient;
import nl.carcompany.rest.lease.api.CustomerClient;
import nl.carcompany.rest.lease.model.CarDto;
import nl.carcompany.rest.lease.model.CustomerDto;
import nl.carcompany.rest.lease.model.LeaseDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LeaseEntityToDtoConverter implements Converter<LeaseEntity, LeaseDto> {

  private final CustomerClient customersClient;
  private final CarClient carClient;

  @Override
  public LeaseDto convert(final LeaseEntity leaseEntity) {
    final LeaseDto leaseDto = new LeaseDto();

    final CustomerDto customerDto = customersClient.getCustomerById(leaseEntity.getCustomerId());
    leaseDto.setCustomer(customerDto);

    final CarDto carDto = carClient.getCarById(leaseEntity.getCarId());
    leaseDto.setCar(carDto);

    leaseDto.setId(leaseEntity.getId());
    leaseDto.setDuration(leaseEntity.getDuration());
    leaseDto.setInterest(leaseEntity.getInterest());
    leaseDto.setMileage(leaseEntity.getMileage());
    leaseDto.setStartDate(leaseEntity.getStartDate());

    leaseDto.setLeaseRate(leaseEntity.getLeaseRate());

    return leaseDto;
  }
}
