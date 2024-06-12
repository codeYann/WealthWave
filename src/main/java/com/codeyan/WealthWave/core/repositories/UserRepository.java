package com.codeyan.WealthWave.Core.repositories;

import com.codeyan.WealthWave.Core.entities.user.User;
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
