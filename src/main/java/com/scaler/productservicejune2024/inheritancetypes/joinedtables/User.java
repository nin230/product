package com.scaler.productservicejune2024.inheritancetypes.joinedtables;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id

    private Long id;
    private String name;
    private String Email;
}
