package com.hah.model.dto;

import com.hah.model.ProductType;
import com.hah.model.enums.EProductType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductTypeDTO {

    private int id;

    private EProductType productType;

}
