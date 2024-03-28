package com.telusko.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.telusko.model.QuestionWrapper;
import com.telusko.model.Response;

@FeignClient("QUESTIONSERVICE")
public interface QuizInterface 
{
	@GetMapping("QuestionService/question/randomquestion")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category,@RequestParam Integer numQ);
	
	@PostMapping("QuestionService/question/getquestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);
	
	@PostMapping("QuestionService/question/getscore")
	public ResponseEntity<Integer> getQuizScore(@RequestBody List<Response> responses);
}
