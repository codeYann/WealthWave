package com.codeyan.WealthWave.core.repositories;

import com.codeyan.WealthWave.core.entities.user.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);

    List<User> saveAll(List<User> users);

    void delete(User user);

    void deleteAllById(List<Long> ids);
}
