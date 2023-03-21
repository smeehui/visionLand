package com.hah.controller.api;


import com.hah.model.User;
import com.hah.model.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")

public class ProductAPI {
    @Autowired
    ModelMapper modelMapper;

    public void setModelMapper(ModelMapper modelMapper) {
        UserDTO  userDTO = new UserDTO();

        User user = modelMapper.map(userDTO, User.class);
    }
}
