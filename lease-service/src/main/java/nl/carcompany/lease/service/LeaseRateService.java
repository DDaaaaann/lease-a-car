package nl.carcompany.lease.service;

public interface LeaseRateService {

  Double calculateLeaseRate(final Integer mileage, final Integer duration,
      final Float interest, final Double nettPrice);

}
