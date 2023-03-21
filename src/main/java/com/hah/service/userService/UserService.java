package com.hah.service.userService;

import com.hah.model.User;
import com.hah.model.UserPrinciple;
import com.hah.model.dto.UserDTO;
import com.hah.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private  final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }



    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public User getByUsername(String username) {
        return null;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }


    @Override
    public Optional<UserDTO> findUserDTOByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Boolean existsByUsername(String email) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByPhone(username);

        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException(username);
        }

        return UserPrinciple.build(userOptional.get());
    }
}
