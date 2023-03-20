package com.hah.model.dto;

import com.hah.model.ProductType;
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

    public ProductType toProductType() {
        return new ProductType()
                .setId(id);
    }
}
