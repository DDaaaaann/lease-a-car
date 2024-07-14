package nl.carcompany.lease.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import nl.carcompany.lease.service.impl.LeaseRateServiceImpl;
import nl.carcompany.rest.lease.model.CarDto;
import nl.carcompany.rest.lease.model.LeaseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class LeaseRateServiceTest {

  @InjectMocks
  private LeaseRateServiceImpl leaseRateService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void shouldReturnCorrectLeaseRate() {
    final LeaseDto lease = new LeaseDto();
    lease.setMileage(45000);
    lease.setDuration(60);
    lease.setInterest(4.5f);

    final CarDto car = new CarDto();
    car.setNettPrice(63000.00);
    lease.setCar(car);

    final Double leaseRate = leaseRateService.calculateLeaseRate(lease);
    assertThat(leaseRate).isCloseTo(239.82, within(0.002));
  }
}