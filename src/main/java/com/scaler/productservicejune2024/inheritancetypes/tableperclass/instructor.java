package com.scaler.productservicejune2024.inheritancetypes.tableperclass;

import com.scaler.productservicejune2024.inheritancetypes.joinedtables.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tbc_instructor")
public class instructor extends User {
    private String subject;
}
