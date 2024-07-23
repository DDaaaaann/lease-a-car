package nl.carcompany.lease.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;
import lombok.RequiredArgsConstructor;
import nl.carcompany.lease.service.LeaseService;
import nl.carcompany.rest.lease.api.LeasesApi;
import nl.carcompany.rest.lease.model.LeaseDto;
import nl.carcompany.rest.lease.model.LeaseResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LeaseController implements LeasesApi {

  private final LeaseService leaseService;

  @Override
  public ResponseEntity<LeaseResponseDto> addLease(final LeaseDto leaseDto) {
    return ok(leaseService.leaseCar(leaseDto));
  }

  @Override
  public ResponseEntity<List<LeaseResponseDto>> getLeases() {
    return ok(leaseService.getLeases());
  }
}
