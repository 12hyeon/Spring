package jpabook.orignal_jpashop.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {
    private String street;
    private String detail;
    private String zipcode;

    protected Address() {
    }

    public Address(String street, String detail, String zipcode) {
        this.street = street;
        this.detail = detail;
        this.zipcode = zipcode;
    }
}