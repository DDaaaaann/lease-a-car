package nl.carcompany.customer.converter;

import nl.carcompany.customer.entity.AddressEntity;
import nl.carcompany.rest.lease.model.AddressDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AddressEntityToDtoConverter implements Converter<AddressEntity, AddressDto> {

  @Override
  public AddressDto convert(final AddressEntity addressEntity) {
    final AddressDto addressDto = new AddressDto();
    addressDto.setStreet(addressEntity.getStreet());
    addressDto.setHouseNumber(addressEntity.getHousenumber());
    addressDto.setZipCode(addressEntity.getZipcode());
    addressDto.setPlace(addressEntity.getPlace());
    return addressDto;
  }
}
