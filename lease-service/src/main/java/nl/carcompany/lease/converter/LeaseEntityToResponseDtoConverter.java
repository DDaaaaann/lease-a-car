package nl.carcompany.lease.converter;

import lombok.RequiredArgsConstructor;
import nl.carcompany.lease.entity.LeaseEntity;
import nl.carcompany.rest.lease.api.CarClient;
import nl.carcompany.rest.lease.api.CustomerClient;
import nl.carcompany.rest.lease.model.CarResponseDto;
import nl.carcompany.rest.lease.model.CustomerResponseDto;
import nl.carcompany.rest.lease.model.LeaseResponseDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LeaseEntityToResponseDtoConverter implements Converter<LeaseEntity, LeaseResponseDto> {

  private final CustomerClient customersClient;
  private final CarClient carClient;

  @Override
  public LeaseResponseDto convert(final LeaseEntity leaseEntity) {
    final LeaseResponseDto leaseResponseDto = new LeaseResponseDto();

    final CustomerResponseDto customerDto = customersClient.getCustomerById(
        leaseEntity.getCustomerId());
    leaseResponseDto.setCustomer(customerDto);

    final CarResponseDto carDto = carClient.getCarById(leaseEntity.getCarId());
    leaseResponseDto.setCar(carDto);

    leaseResponseDto.setId(leaseEntity.getId());
    leaseResponseDto.setDuration(leaseEntity.getDuration());
    leaseResponseDto.setInterest(leaseEntity.getInterest());
    leaseResponseDto.setMileage(leaseEntity.getMileage());
    leaseResponseDto.setStartDate(leaseEntity.getStartDate());

    leaseResponseDto.setLeaseRate(leaseEntity.getLeaseRate());

    return leaseResponseDto;
  }
}
