package nl.carcompany.customer.converter;

import nl.carcompany.customer.entity.CustomerEntity;
import nl.carcompany.customer.model.CustomerDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoToEntityConverter implements Converter<CustomerDto, CustomerEntity> {

  @Override
  public CustomerEntity convert(final CustomerDto customerDto) {
    final CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setId(customerDto.getId());
    customerEntity.setName(customerDto.getName());
//    customerEntity.setEmail(customerDto.getEmail());
    return customerEntity;
  }
}
