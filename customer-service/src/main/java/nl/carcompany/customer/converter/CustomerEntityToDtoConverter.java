package nl.carcompany.customer.converter;

import lombok.RequiredArgsConstructor;
import nl.carcompany.customer.entity.CustomerEntity;
import nl.carcompany.rest.lease.model.CustomerDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerEntityToDtoConverter implements Converter<CustomerEntity, CustomerDto> {

  private final AddressEntityToDtoConverter addressEntityToDtoConverter;
  @Override
  public CustomerDto convert(final CustomerEntity customerEntity) {
    final CustomerDto customerDto = new CustomerDto();
    customerDto.setId(customerEntity.getId());
    customerDto.setName(customerEntity.getName());
    customerDto.setEmail(customerEntity.getEmail());

    customerDto.setAddress(addressEntityToDtoConverter.convert(customerEntity.getAddressEntity()));

    return customerDto;
  }
}
