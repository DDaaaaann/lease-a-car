package nl.carcompany.lease.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import nl.carcompany.lease.converter.LeaseDtoToEntityConverter;
import nl.carcompany.lease.converter.LeaseEntityToResponseDtoConverter;
import nl.carcompany.lease.entity.LeaseEntity;
import nl.carcompany.lease.repository.LeaseRepository;
import nl.carcompany.lease.service.LeaseRateService;
import nl.carcompany.lease.service.LeaseService;
import nl.carcompany.rest.lease.api.CarClient;
import nl.carcompany.rest.lease.api.CustomerClient;
import nl.carcompany.rest.lease.model.CarResponseDto;
import nl.carcompany.rest.lease.model.CustomerResponseDto;
import nl.carcompany.rest.lease.model.LeaseDto;
import nl.carcompany.rest.lease.model.LeaseResponseDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeaseServiceImpl implements LeaseService {

  private final LeaseRepository leaseRepository;
  private final LeaseRateService leaseRateService;
  private final LeaseEntityToResponseDtoConverter entityToDtoConverter;
  private final LeaseDtoToEntityConverter dtoToEntityConverter;

  private final CarClient carClient;
  private final CustomerClient customerClient;

  @Override
  public LeaseResponseDto leaseCar(final LeaseDto leaseDto) {

    final CarResponseDto car = carClient.getCarById(leaseDto.getCarId());
    final CustomerResponseDto customer = customerClient.getCustomerById(leaseDto.getCustomerId());

    final LeaseEntity leaseEntity = dtoToEntityConverter.convert(leaseDto);

    final Double leaseRate = leaseRateService.calculateLeaseRate(leaseDto.getMileage(),
        leaseDto.getDuration(), leaseDto.getInterest(), car.getNettPrice());
    leaseEntity.setLeaseRate(leaseRate);

    final LeaseEntity savedLeaseEntity = leaseRepository.save(leaseEntity);
    return entityToDtoConverter.convert(savedLeaseEntity);
  }

  @Override
  public List<LeaseResponseDto> getLeases() {
    return leaseRepository.findAll()
        .stream()
        .map(entityToDtoConverter::convert)
        .collect(Collectors.toList());
  }
}
