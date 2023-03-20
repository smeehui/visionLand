package com.hah.model.enums;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter

public enum EDirection {
    NORTH("HƯỚNG BẮC"),
    SOUTH("HƯỚNG NAM"),
    EAST("HƯỚNG ĐÔNG"),
    WEST("HƯỚNG TÂY"),
    NORTHEAST("HƯỚNG ĐÔNG BẮC"),
    NORTHWEST("HƯỚNG TÂY BẮC"),
    SOUTHEAST("HƯỚNG ĐÔNG NAM"),
    SOUTHWEST("HƯỚNG TÂY NAM"),
    ;
    private String value;


}


