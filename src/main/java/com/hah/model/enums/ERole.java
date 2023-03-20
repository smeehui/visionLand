package com.hah.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ERole {
    ADMIN("ADMIN"),
    USER("USER");
    private String value;
}
