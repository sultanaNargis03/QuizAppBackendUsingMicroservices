package com.telusko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.model.Question;
import com.telusko.model.QuestionWrapper;
import com.telusko.model.Response;
import com.telusko.service.QuizService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/quiz")
public class QuizController 
{
	@Autowired
	private QuizService service;
	
	@PostMapping("/create")
	//	using requestparam
	public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam Integer numQ,@RequestParam String title)
	{
		return new ResponseEntity(service.createQuiz(category, numQ, title),HttpStatus.CREATED);
	}
/*	
 * @PostMapping("/addquiz/{title}/{numQ}/{category}")
 * //  using pathparam
 * public ResponseEntity<String> createQuiz(@PathVariable String title,@PathVariable Integer numQ,@PathVariable String category)
 * {
 * 		return new ResponseEntity("hello there!!",HttpStatus.CREATED);
 * }
 */
	@GetMapping("/fetchQuiz/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id)
	{
		return new ResponseEntity(service.getQuizQuestions(id),HttpStatus.OK);
	}
	
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses)
	{
		return new ResponseEntity(service.calculateScore(id,responses),HttpStatus.OK);
	}
	
}
