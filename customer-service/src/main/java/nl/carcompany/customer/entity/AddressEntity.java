package nl.carcompany.customer.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {

  @NotNull
  private String street;

  @NotNull
  private String housenumber;

  @NotNull
  private String zipcode;

  @NotNull
  private String place;

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final AddressEntity that = (AddressEntity) o;

    if (!street.equals(that.street)) {
      return false;
    }
    if (!housenumber.equals(that.housenumber)) {
      return false;
    }
    if (!zipcode.equals(that.zipcode)) {
      return false;
    }
    return place.equals(that.place);
  }

  @Override
  public int hashCode() {
    int result = street.hashCode();
    result = 31 * result + housenumber.hashCode();
    result = 31 * result + zipcode.hashCode();
    result = 31 * result + place.hashCode();
    return result;
  }
}

