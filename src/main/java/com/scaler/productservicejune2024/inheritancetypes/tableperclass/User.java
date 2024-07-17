package com.scaler.productservicejune2024.inheritancetypes.tableperclass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tbc_users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(
//        name="user_type",
//        discriminatorType = DiscriminatorType.INTEGER
//      )
//@DiscriminatorValue(value="0")
public class User {
    @Id
    private Long id;
    private String name;
    private String Email;
}
