package com.fomationSpring.demo.Repository;

import com.fomationSpring.demo.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
