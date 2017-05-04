package com.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.test.bean.User;

public interface UserRepository extends CrudRepository<User, String> {

}
