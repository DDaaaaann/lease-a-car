package nl.carcompany.lease.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import nl.carcompany.lease.service.impl.LeaseRateServiceImpl;
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
    final Double leaseRate = leaseRateService.calculateLeaseRate(45000, 60, 4.5f, 63000.00);
    assertThat(leaseRate).isCloseTo(239.82, within(0.002));
  }
}