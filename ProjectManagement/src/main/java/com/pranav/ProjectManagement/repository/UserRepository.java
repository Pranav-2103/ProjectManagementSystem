package com.pranav.ProjectManagement.repository;

import com.pranav.ProjectManagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // Spring Data JPA will automatically create the query for the following function since prefix findBy is used
    User findByEmail(String email);
}
