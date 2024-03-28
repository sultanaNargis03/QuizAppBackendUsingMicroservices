package com.telusko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.model.QuestionWrapper;
import com.telusko.model.QuizDto;
import com.telusko.model.Response;
import com.telusko.service.QuizService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/quiz")
@Tag(name="QuizService",description="This API URL will help to play Quiz")
public class QuizController 
{
	@Autowired
	private QuizService service;
	
	@Operation(summary="POST operation",description="API will accept json QuizDto object to create quiz")
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto)
	{
		return new ResponseEntity(service.createQuiz(quizDto.getCategoryName(),quizDto.getNumQuestions(),quizDto.getTitle()),HttpStatus.CREATED);
	}

	@Operation(summary="GET operation",description="API will accept json quiz id and return List of question wrapper")
	@GetMapping("/fetchquiz/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id)
	{
		return new ResponseEntity(service.getQuizQuestions(id),HttpStatus.OK);
	}
	
	@Operation(summary="POST operation",description="API will accept json List of responses and id and return score")
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses)
	{
		return new ResponseEntity(service.calculateScore(id,responses),HttpStatus.OK);
	}
	
	
}
