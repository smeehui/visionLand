package com.hah.model.dto;

import com.hah.model.User;
import com.hah.model.UserRole;
import com.hah.model.enums.ERole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserRoleDTO {
    private Long id;

    private ERole name;

    private List<User> roles;


}
