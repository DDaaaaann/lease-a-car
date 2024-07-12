package nl.carcompany.lease.service;

import nl.carcompany.rest.lease.model.LeaseDto;

public interface LeaseRateService {

  Double calculateLeaseRate(LeaseDto leaseDto);

}
