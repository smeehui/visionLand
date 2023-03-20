package com.hah.model.dto;

import com.hah.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductReqDTO {

    private int id;
    private String name;

    private UserDTO user;
    private String provinceId;
    private String provinceName;
    private String districtId;
    private String districtName;
    private String wardId;
    private String wardName;

    private BigDecimal price;

    private BigDecimal area;

    private String description;

    private ProductDirectionDTO productDirection;

    private ProductTypeDTO productType;

    private List<ProductImageDTO> productImage;

    private MultipartFile file;

    public Product toProduct(User user, LocationRegion locationRegion,List<ProductImage> productImage ){
        return new Product()
                .setId(id)
                .setUser(user)
                .setLocationRegion(locationRegion)
                .setName(name)
                .setPrice(price)
                .setArea(area)
                .setDescription(description)
                .setProductDirection(productDirection.toProductDirection())
                .setProductType(productType.toProductType())
                .setProductImage(productImage);
    }

    public LocationRegion toLocationRegion() {
        return new LocationRegion()
                .setId(id)
                .setProvinceId(provinceId)
                .setProvinceName(provinceName)
                .setDistrictId(districtId)
                .setDistrictName(districtName)
                .setWardId(wardId)
                .setWardName(wardName);
    }


}
