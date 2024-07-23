package nl.carcompany.customer.converter;

import lombok.RequiredArgsConstructor;
import nl.carcompany.customer.entity.CustomerEntity;
import nl.carcompany.rest.lease.model.CustomerResponseDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerEntityToResponseDtoConverter implements
    Converter<CustomerEntity, CustomerResponseDto> {

  private final AddressEntityToDtoConverter addressEntityToDtoConverter;
  @Override
  public CustomerResponseDto convert(final CustomerEntity customerEntity) {
    final CustomerResponseDto customerDto = new CustomerResponseDto();
    customerDto.setId(customerEntity.getId());
    customerDto.setName(customerEntity.getName());
    customerDto.setEmail(customerEntity.getEmail());

    customerDto.setAddress(addressEntityToDtoConverter.convert(customerEntity.getAddressEntity()));

    return customerDto;
  }
}
