package com.hcl.loginRegister.repository;

import com.hcl.loginRegister.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT user FROM User user WHERE user.email = ?1 AND user.password = ?2")
    User findByEmailAndPassword(String email, String password);

}
