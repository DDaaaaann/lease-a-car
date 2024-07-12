package nl.carcompany.lease.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import nl.carcompany.lease.converter.LeaseDtoToEntityConverter;
import nl.carcompany.lease.converter.LeaseEntityToDtoConverter;
import nl.carcompany.lease.entity.LeaseEntity;
import nl.carcompany.lease.repository.LeaseRepository;
import nl.carcompany.lease.service.LeaseService;
import nl.carcompany.rest.lease.model.LeaseDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeaseServiceImpl implements LeaseService {

  private final LeaseRepository leaseRepository;
  private final LeaseEntityToDtoConverter entityToDtoConverter;
  private final LeaseDtoToEntityConverter dtoToEntityConverter;

  @Override
  public LeaseDto leaseCar(final LeaseDto leaseDto) {
    final LeaseEntity leaseEntity = dtoToEntityConverter.convert(leaseDto);
    final LeaseEntity savedLeaseEntity = leaseRepository.save(leaseEntity);
    return entityToDtoConverter.convert(savedLeaseEntity);
  }

  @Override
  public List<LeaseDto> getLeases() {
    return leaseRepository.findAll()
        .stream()
        .map(entityToDtoConverter::convert)
        .collect(Collectors.toList());
  }
}
