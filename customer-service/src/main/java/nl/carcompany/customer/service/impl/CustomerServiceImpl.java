package nl.carcompany.customer.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import nl.carcompany.customer.converter.CustomerDtoToEntityConverter;
import nl.carcompany.customer.converter.CustomerEntityToDtoConverter;
import nl.carcompany.customer.entity.CustomerEntity;
import nl.carcompany.customer.exceptions.CustomerNotFoundException;
import nl.carcompany.customer.exceptions.NoUniqueResultException;
import nl.carcompany.customer.repository.CustomerRepository;
import nl.carcompany.customer.service.CustomerService;
import nl.carcompany.lease.model.CustomerDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;
  private final CustomerDtoToEntityConverter dtoToEntityConverter;
  private final CustomerEntityToDtoConverter entityToDtoConverter;

  @Override
  public CustomerDto createCustomer(final CustomerDto customerDto) {
    final CustomerEntity customerEntity = dtoToEntityConverter.convert(customerDto);
    final CustomerEntity savedCustomer = customerRepository.save(customerEntity);
    return entityToDtoConverter.convert(savedCustomer);
  }

  @Override
  public void deleteCustomer(final Long id) {
    customerRepository.deleteById(id);
  }

  @Override
  public CustomerDto findById(final Long id) {
    final CustomerEntity customerEntity = customerRepository.findById(id)
        .orElseThrow(() -> new NoUniqueResultException(id));
    return entityToDtoConverter.convert(customerEntity);
  }

  @Override
  public List<CustomerDto> findAll() {
    final List<CustomerEntity> customerEntities = customerRepository.findAll();
    return customerEntities.stream()
        .map(entityToDtoConverter::convert)
        .collect(Collectors.toList());
  }

  @Override
  public void updateCustomer(final Long id, final CustomerDto customerDto) {
    final CustomerEntity customerEntityToUpdate = customerRepository.findById(id).orElseThrow(
        () -> new CustomerNotFoundException(id));

    customerEntityToUpdate.setName(customerDto.getName());

    customerRepository.save(customerEntityToUpdate);
  }
}
