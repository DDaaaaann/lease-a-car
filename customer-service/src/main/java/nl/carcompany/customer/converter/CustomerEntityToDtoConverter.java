package nl.carcompany.customer.converter;

import nl.carcompany.customer.entity.CustomerEntity;
import nl.carcompany.customer.model.CustomerDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerEntityToDtoConverter implements Converter<CustomerEntity, CustomerDto> {

  @Override
  public CustomerDto convert(final CustomerEntity customerEntity) {
    final CustomerDto customerDto = new CustomerDto();
    customerDto.setId(customerEntity.getId());
    customerDto.setName(customerEntity.getName());
//    customerDto.setEmail(customerEntity.getEmail());
    return customerDto;
  }
}
