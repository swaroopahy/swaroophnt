package com.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderservice.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

}
