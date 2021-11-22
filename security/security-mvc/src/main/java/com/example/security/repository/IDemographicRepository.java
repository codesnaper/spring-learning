package com.example.security.repository;

import com.example.security.entity.Demographic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDemographicRepository extends JpaRepository<Demographic, Long> {

    List<Demographic> findAllByFirstNameOrLastName(String fname, String lname);
}
