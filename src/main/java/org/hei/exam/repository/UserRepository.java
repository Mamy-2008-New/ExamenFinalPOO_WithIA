package org.hei.exam.repository;

import org.hei.exam.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(String id);

    List<User> findAll();
}
