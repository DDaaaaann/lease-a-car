package nl.carcompany.lease.service;

import java.util.List;
import nl.carcompany.lease.model.LeaseDto;

public interface LeaseService {

  LeaseDto leaseCar(LeaseDto leaseDto);

  List<LeaseDto> getLeases();
}
