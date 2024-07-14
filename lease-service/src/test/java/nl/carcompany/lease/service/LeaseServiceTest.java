package nl.carcompany.lease.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import nl.carcompany.lease.converter.LeaseDtoToEntityConverter;
import nl.carcompany.lease.converter.LeaseEntityToDtoConverter;
import nl.carcompany.lease.entity.LeaseEntity;
import nl.carcompany.lease.repository.LeaseRepository;
import nl.carcompany.lease.service.impl.LeaseServiceImpl;
import nl.carcompany.rest.lease.model.LeaseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class LeaseServiceTest {

  @Mock
  private LeaseRepository leaseRepository;

  @Mock
  private LeaseRateService leaseRateService;

  @Mock
  private LeaseEntityToDtoConverter entityToDtoConverter;

  @Mock
  private LeaseDtoToEntityConverter dtoToEntityConverter;

  @InjectMocks
  private LeaseServiceImpl leaseService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    final LeaseEntity leaseEntity = new LeaseEntity();

    when(dtoToEntityConverter.convert(any(LeaseDto.class))).thenReturn(leaseEntity);
    when(leaseRateService.calculateLeaseRate(any(LeaseDto.class))).thenReturn(123.0);
    when(leaseRepository.save(any(LeaseEntity.class))).thenReturn(leaseEntity);
    when(entityToDtoConverter.convert(any(LeaseEntity.class))).thenReturn(new LeaseDto());
  }

  @Test
  void verifyServiceCalls() {
    final LeaseDto newLease = new LeaseDto();
    leaseService.leaseCar(newLease);

    verify(dtoToEntityConverter).convert(any(LeaseDto.class));
    verify(leaseRateService).calculateLeaseRate(any(LeaseDto.class));
    verify(leaseRepository).save(any(LeaseEntity.class));
    verify(entityToDtoConverter).convert(any(LeaseEntity.class));
  }
}