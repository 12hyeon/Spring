package jpabook.orignal_jpashop.domain.item;

import jpabook.orignal_jpashop.domain.Address;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
@Getter @Setter
public class Product extends Item {
    private String company;

    @Embedded
    private Address address;
}