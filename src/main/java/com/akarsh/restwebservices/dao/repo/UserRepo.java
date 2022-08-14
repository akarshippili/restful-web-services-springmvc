package com.akarsh.restwebservices.dao.repo;

import com.akarsh.restwebservices.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    public Optional<User> getUserById(long id);

    @Override
    public User save(User user);

    public List<User> findAll();

    public void deleteById(long id);
}
