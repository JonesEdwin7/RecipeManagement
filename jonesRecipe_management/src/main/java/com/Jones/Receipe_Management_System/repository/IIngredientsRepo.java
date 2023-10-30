package com.Jones.Receipe_Management_System.repository;

import com.Jones.Receipe_Management_System.model.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIngredientsRepo extends JpaRepository<Ingredients,Long> {
}
