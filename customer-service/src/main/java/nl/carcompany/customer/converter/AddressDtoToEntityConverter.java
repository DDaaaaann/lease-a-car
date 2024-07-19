package nl.carcompany.customer.converter;

import nl.carcompany.customer.entity.AddressEntity;
import nl.carcompany.rest.lease.model.AddressDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AddressDtoToEntityConverter implements Converter<AddressDto, AddressEntity> {

  @Override
  public AddressEntity convert(final AddressDto addressDto) {
    final String houseNumber = addressDto.getHouseNumber();
    final String place = addressDto.getPlace();
    final String street = addressDto.getStreet();
    final String zipCode = addressDto.getZipCode();
    return new AddressEntity(street, houseNumber, zipCode, place);
  }
}
