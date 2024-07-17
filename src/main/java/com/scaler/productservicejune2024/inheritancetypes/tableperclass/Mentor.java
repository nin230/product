package com.scaler.productservicejune2024.inheritancetypes.tableperclass;

import com.scaler.productservicejune2024.inheritancetypes.joinedtables.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tbc_mentors")
public class Mentor extends User {
    private String Company;
}
