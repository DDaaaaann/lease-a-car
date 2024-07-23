package nl.carcompany.lease.service.impl;

import nl.carcompany.lease.service.LeaseRateService;
import org.springframework.stereotype.Service;

@Service
public class LeaseRateServiceImpl implements LeaseRateService {

  /**
   * Calculates the current leaserate based on the values of the provided lease object.
   *
   * @param mileage Annual mileage e.g. 15,000
   * @param duration Contract duration in months e.g. 60
   * @param interest Interest rat on car loan e.g. 7%
   * @param nettPrice Netto price of the car e.g. $26.050
   * @return the calculated leaserate
   */
  @Override
  public Double calculateLeaseRate(final Integer mileage,
      final Integer duration, final Float interest, final Double nettPrice) {
    return (((mileage / 12) * duration) / nettPrice) + (((interest / 100) * nettPrice) / 12);
  }
}
