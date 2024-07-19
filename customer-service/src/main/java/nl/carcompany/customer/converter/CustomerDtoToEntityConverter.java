package nl.carcompany.customer.converter;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import nl.carcompany.customer.entity.CustomerEntity;
import nl.carcompany.rest.lease.model.CustomerDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerDtoToEntityConverter implements Converter<CustomerDto, CustomerEntity> {

  private final AddressDtoToEntityConverter addressDtoToEntityConverter;

  @Override
  public CustomerEntity convert(final CustomerDto customerDto) {
    final CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setId(customerDto.getId());
    customerEntity.setName(customerDto.getName());
    customerEntity.setEmail(customerDto.getEmail());

    Optional.ofNullable(customerDto.getAddress())
        .ifPresent(addressDto -> customerEntity.setAddressEntity(
            addressDtoToEntityConverter.convert(addressDto)));

    return customerEntity;
  }
}
