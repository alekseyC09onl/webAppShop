package com.tms.webappshop.service;

import com.tms.webappshop.dto.UserDTO;
import com.tms.webappshop.entity.User;
import com.tms.webappshop.exceptions.UserException;
import com.tms.webappshop.mapper.UserMapper;
import com.tms.webappshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO createUser(UserDTO userDTO) {
        if (userRepository.findUserByEmail(userDTO.getEmail()).isPresent()) {
            return null;
        }
        User user = UserMapper.mapToEntity(userDTO);
        userRepository.save(user);
        return UserMapper.mapToDTO(user);
    }

    public UserDTO updateUser(Integer id, UserDTO userDTO) throws UserException {
        if (userRepository.findById(id).isPresent()) {
            User user = UserMapper.mapToEntity(userDTO);
            user.setId(id);
            userRepository.save(user);
            return UserMapper.mapToDTO(user);
        } else {
            throw new UserException(("User with id: " + id + " was not found"));
        }
    }

    public boolean deleteUser(Integer id) throws UserException {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return true;
        } else {
            throw new UserException(("User with id: " + id + " was not found"));
        }
    }

    public UserDTO getUserById(Integer id) throws UserException {
        if (userRepository.findById(id).isPresent()) {
            return UserMapper.mapToDTO(userRepository.getById(id));
        } else {
            throw new UserException(("User with id: " + id + " was not found"));
        }
    }
    
}
