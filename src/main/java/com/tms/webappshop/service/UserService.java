package com.tms.webappshop.service;

import com.tms.webappshop.dto.UserDTO;
import com.tms.webappshop.entity.Customer;
import com.tms.webappshop.entity.User;
import com.tms.webappshop.exceptions.UserException;
import com.tms.webappshop.mapper.UserDTOCustomerMapper;
import com.tms.webappshop.mapper.UserMapper;
import com.tms.webappshop.repository.CustomerRepository;
import com.tms.webappshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;

    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::mapToDTO)
                .sorted((o1, o2) -> o2.getId().compareTo(o1.getId()))
                .collect(Collectors.toList());
    }

    public UserDTO createUser(UserDTO userDTO) throws UserException {
        if (userRepository.findUserByEmail(userDTO.getEmail()).isPresent()) {
            throw new UserException(("User with email: " + userDTO.getEmail() + " is already exist"));
        }
        User user = UserMapper.mapToEntity(userDTO);
        userRepository.save(user);
        Customer customer = UserDTOCustomerMapper.mapToCustomer(userDTO);
        customerRepository.save(customer);
        return UserMapper.mapToDTO(user);
    }

    public UserDTO updateUser(UserDTO userDTO) throws UserException {
        if (userRepository.findById(userDTO.getId()).isPresent()) {
            if (userRepository.findUserByEmail(userDTO.getEmail()).isPresent()) {
                throw new UserException(("User with email: " + userDTO.getEmail() + " is already exist"));
            }
            User user = UserMapper.mapToEntity(userDTO);
            user.setId(userDTO.getId());
            userRepository.save(user);
            return UserMapper.mapToDTO(user);
        } else {
            throw new UserException(("User with id: " + userDTO.getId() + " was not found"));
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

    public UserDTO getUserDTOByEmail(String email) throws UserException {
        if (userRepository.findUserByEmail(email).isPresent()) {
            return UserMapper.mapToDTO(userRepository.findUserByEmail(email).get());
        } else {
            throw new UserException(("User with email: " + email + " was not found"));
        }
    }

}
