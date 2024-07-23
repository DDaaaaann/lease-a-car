package nl.carcompany.customer.service;

import java.util.List;
import nl.carcompany.rest.lease.model.CustomerDto;
import nl.carcompany.rest.lease.model.CustomerResponseDto;

public interface CustomerService {

  CustomerResponseDto createCustomer(CustomerDto customerDto);

  void deleteCustomer(Long id);

  CustomerResponseDto findById(Long id);

  List<CustomerResponseDto> findAll();

  void updateCustomer(Long id, CustomerDto customerDto);
}
