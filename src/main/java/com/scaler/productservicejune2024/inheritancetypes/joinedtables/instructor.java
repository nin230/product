package com.scaler.productservicejune2024.inheritancetypes.joinedtables;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_instructors")
@PrimaryKeyJoinColumn(name="user_id")
public class instructor extends User{
    private String subject;
}
