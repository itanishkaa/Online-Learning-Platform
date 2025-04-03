package com.example.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pojo.UserDetails;


@Repository
public interface UserDao extends JpaRepository<UserDetails, Integer> {
    Optional<UserDetails> findByUserid(String userid);
}
