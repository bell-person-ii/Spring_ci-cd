package me.dev.cicd_test.repository;

import me.dev.cicd_test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
