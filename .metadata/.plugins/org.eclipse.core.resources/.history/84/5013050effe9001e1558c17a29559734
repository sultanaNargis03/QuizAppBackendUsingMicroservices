package com.telusko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.model.Question;
import com.telusko.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController 
{
	@Autowired
	private QuestionService qservice;
	
	@PostMapping("/addquestion")
	public ResponseEntity<String> addQuestion(@RequestBody Question question)
	{	
		return new ResponseEntity(qservice.addQuestion(question),HttpStatus.CREATED);
	}
	
	@GetMapping("/allquestions")
	public ResponseEntity<List<Question>> getAllQuestions()
	{
		return new ResponseEntity(qservice.getAllQuestions(),HttpStatus.OK);
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category)
	{
		return new ResponseEntity(qservice.getQuestionsByCategory(category),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateQuestionById(@PathVariable Integer id,@RequestBody Question question)
	{
		return new ResponseEntity(qservice.updateQuestionById(id,question),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteQuestionById(@PathVariable Integer id)
	{
		return new ResponseEntity(qservice.deleteQuestionById(id),HttpStatus.OK);
	}
}
