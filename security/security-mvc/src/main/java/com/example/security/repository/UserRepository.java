package com.example.security.repository;

import com.example.security.entity.Demographic;
import com.example.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByusername(String userName);

}
