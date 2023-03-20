package com.hah.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum EProductType {
    PROMOTING("NỔI BẬT"),
    REGULAR("BÌNH THƯỜNG");
    private String value;
}
