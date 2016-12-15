package com.example.dao;

import com.example.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Long>{

    User findByUsername(String username);
}
