package com.tms.webappshop.repository;

import com.tms.webappshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//    Set<User> getUsersByRoleRoleTitle(String roleTitle);

    User getUserByEmail(String email);

    Optional<User> findUserByEmail(String email);

}
