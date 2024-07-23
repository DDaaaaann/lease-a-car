package nl.carcompany.lease.service;

import java.util.List;
import nl.carcompany.rest.lease.model.LeaseDto;
import nl.carcompany.rest.lease.model.LeaseResponseDto;

public interface LeaseService {

  LeaseResponseDto leaseCar(LeaseDto leaseDto);

  List<LeaseResponseDto> getLeases();
}
