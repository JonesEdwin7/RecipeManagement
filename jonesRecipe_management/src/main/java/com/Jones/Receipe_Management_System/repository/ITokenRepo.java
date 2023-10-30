package com.Jones.Receipe_Management_System.repository;

import com.Jones.Receipe_Management_System.model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITokenRepo extends JpaRepository<AuthenticationToken , Long> {

    AuthenticationToken findFirstByToken(String token);
}
