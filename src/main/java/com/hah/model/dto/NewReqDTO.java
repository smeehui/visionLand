package com.hah.model.dto;

import com.hah.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NewReqDTO extends BaseEntity implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return NewReqDTO.class.isAssignableFrom(clazz);
    }

    private String title;

    private String subtitle;

    private UserDTO user;

    private String content;

    @Override
    public void validate(Object target, Errors errors) {

    }
}
