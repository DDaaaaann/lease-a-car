package nl.carcompany.lease.service.impl;

import nl.carcompany.lease.service.LeaseRateService;
import nl.carcompany.rest.lease.model.LeaseDto;
import org.springframework.stereotype.Service;

@Service
public class LeaseRateServiceImpl implements LeaseRateService {

  /**
   * Calculates the current leaserate based on the values of the provided lease object.
   *
   * @param leaseDto Details of the lease
   * @return the calculated leaserate
   */
  @Override
  public Double calculateLeaseRate(final LeaseDto leaseDto) {
    final Integer mileage = leaseDto.getMileage();
    final Integer duration = leaseDto.getDuration();
    final Double nettPrice = leaseDto.getCar().getNettPrice();
    final Float interest = leaseDto.getInterest();
    return (((mileage / 12) * duration) / nettPrice) + (((interest / 100) * nettPrice) / 12);
  }
}
