package org.wecode23.springboot.domain.users.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wecode23.springboot.domain.users.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
