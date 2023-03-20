package com.hah.model.dto;

import com.hah.model.LocationRegion;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class LocationRegionDTO implements Validator {

    private int id;
    private String provinceId;
    private String provinceName;
    private String districtId;
    private String districtName;
    private String wardId;
    private String wardName;

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

    @Override
    public boolean supports(Class<?> clazz) {
        return LocationRegionDTO.class.isAssignableFrom(clazz);
    }


    @Override
    public void validate(Object target, Errors errors) {
        LocationRegionDTO locationRegionDTO = (LocationRegionDTO) target;

    }

}
