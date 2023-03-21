package com.hah.service.userService;

import com.hah.model.User;
import com.hah.model.dto.UserDTO;
import com.hah.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    User getByUsername(String username);

    Optional<User> findByUsername(String username);


    Optional<UserDTO> findUserDTOByUsername(String username);

    Boolean existsByUsername(String email);
}
