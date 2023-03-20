package com.hah.model.dto;

import com.hah.model.ProductDirection;
import com.hah.model.ProductType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ProductDirectionDTO {

    private int id;

    public ProductDirection toProductDirection() {
        return new ProductDirection()
                .setId(id);
    }

}
