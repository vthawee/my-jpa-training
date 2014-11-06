package myjpa.features.embedded;

import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

//  For Reuse in Many Class
@Embeddable
public class Address implements Serializable {

    @NotNull
    private String street;
    @NotNull
    private String province;
    @NotNull
    private String zipcode;

    public Address() {
    }

    public Address(String street, String province, String zipcode) {
        this.street = street;
        this.province = province;
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.street);
        hash = 97 * hash + Objects.hashCode(this.province);
        hash = 97 * hash + Objects.hashCode(this.zipcode);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if (!Objects.equals(this.street, other.street)) {
            return false;
        }
        if (!Objects.equals(this.province, other.province)) {
            return false;
        }
        if (!Objects.equals(this.zipcode, other.zipcode)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Address{" + "street=" + street + ", province=" + province
                + ", zipcode=" + zipcode + '}';
    }
}
