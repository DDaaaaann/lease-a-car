package nl.carcompany.customer.service;

import java.util.List;
import nl.carcompany.rest.lease.model.CustomerDto;

public interface CustomerService {

  CustomerDto createCustomer(CustomerDto customerDto);

  void deleteCustomer(Long id);

  CustomerDto findById(Long id);

  List<CustomerDto> findAll();

  void updateCustomer(Long id, CustomerDto customerDto);
}
