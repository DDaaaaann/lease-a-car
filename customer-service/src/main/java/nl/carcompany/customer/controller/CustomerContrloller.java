package nl.carcompany.customer.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.carcompany.customer.api.CustomersApi;
import nl.carcompany.customer.model.CustomerDto;
import nl.carcompany.customer.service.impl.CustomerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CustomerContrloller implements CustomersApi {

  private final CustomerServiceImpl customerService;

  @Override
  public ResponseEntity<CustomerDto> addCustomer(final CustomerDto customerDto) {
    log.info("Creating customer {}", customerDto.getName());
    return ok(customerService.createCustomer(customerDto));
  }

  @Override
  public ResponseEntity<Void> deleteCustomer(final Long id) {
    customerService.deleteCustomer(id);
    return ok(null);
  }

  @Override
  public ResponseEntity<CustomerDto> getCustomerById(final Long id) {
    return ok(customerService.findById(id));
  }


  @Override
  public ResponseEntity<List<CustomerDto>> getCustomers() {
    return ok(customerService.findAll());
  }

  @Override
  public ResponseEntity<Void> updateCustomer(final Long id, final CustomerDto customerDto) {
    customerService.updateCustomer(id, customerDto);
    return null;
  }


}
