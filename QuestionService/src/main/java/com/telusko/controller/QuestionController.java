package com.telusko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.model.Question;
import com.telusko.model.QuestionWrapper;
import com.telusko.model.Response;
import com.telusko.service.QuestionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/question")
@Tag(name="QuestionService",description="This API URL will help to perform question related operations")
public class QuestionController 
{
	@Autowired
	private QuestionService questionService;
	
	@Autowired 
	Environment environment;
	
	@Operation(summary="POST operation",description="API will accept json Question obj and add Question")
	@PostMapping("/addquestion")
	public ResponseEntity<String> addQuestion(@RequestBody Question question)
	{	
		return new ResponseEntity(questionService.addQuestion(question),HttpStatus.CREATED);
	}
	
	@Operation(summary="GET operation",description="API will return all questions")
	@GetMapping("/allquestions")
	public ResponseEntity<List<Question>> getAllQuestions()
	{
		return new ResponseEntity(questionService.getAllQuestions(),HttpStatus.OK);
	}
	
	@Operation(summary="GET operation",description="API will accept json question category and return List of question that matches with category")
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category)
	{
		return new ResponseEntity(questionService.getQuestionsByCategory(category),HttpStatus.OK);
	}
	
	@Operation(summary="PUT operation",description="API will accept json question id and json question object and update the question accordinngly")
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateQuestionById(@PathVariable Integer id,@RequestBody Question question)
	{
		return new ResponseEntity(questionService.updateQuestionById(id,question),HttpStatus.OK);
	}
	
	@Operation(summary="DELETE operation",description="API will accept json question id and delete that question")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteQuestionById(@PathVariable Integer id)
	{
		return new ResponseEntity(questionService.deleteQuestionById(id),HttpStatus.OK);
	}
	
	@Operation(summary="GET operation",description="API will accept json question category and num of question and return the list of question ids")
	@GetMapping("/randomquestion")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category,@RequestParam Integer numQ)
	{
		System.out.println(environment.getProperty("local.server.port"));
		return new ResponseEntity(questionService.generateRandomQuestionsForQuiz(category,numQ),HttpStatus.OK);
	}
	
	@Operation(summary="POST operation",description="API will accept json List of question and return List of question wrapper")
	@PostMapping("/getquestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds)
	{
		return new ResponseEntity(questionService.getQuestionsFromId(questionIds),HttpStatus.OK);
	}
	
	@Operation(summary="GET operation",description="API will accept json List of response and return score")
	@PostMapping("/getscore")
	public ResponseEntity<Integer> getQuizScore(@RequestBody List<Response> responses)
	{
		return new ResponseEntity(questionService.getScore(responses),HttpStatus.OK);
	}
	
}
