package com.telusko.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.model.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Integer> 
{
	
}
