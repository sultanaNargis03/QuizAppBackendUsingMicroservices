package com.telusko.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.telusko.exception.QuizNotfoundException;
import com.telusko.feign.QuizInterface;
import com.telusko.model.QuestionWrapper;
import com.telusko.model.Quiz;
import com.telusko.model.Response;
import com.telusko.repo.QuizRepo;

@Service
public class QuizService 
{
	@Autowired
	private QuizRepo quizRepo;
	
	@Autowired
	private QuizInterface quizInterface;
	
	public String createQuiz(String category,Integer numQ,String title)
	{
		List<Integer> questions= quizInterface.getQuestionsForQuiz(category, numQ).getBody();
		
		Quiz quiz= new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionIds(questions);
		
		quizRepo.save(quiz);
		
		return "Quiz created successfully with id "+quiz.getId();
	}

	public List<QuestionWrapper> getQuizQuestions(Integer id)
	{
		Optional<Quiz> q = quizRepo.findById(id);
		
		if(q.isPresent())
		{
			Quiz quiz = q.get();
			List<Integer> questionIds=quiz.getQuestionIds();
			List<QuestionWrapper> questions = quizInterface.getQuestionsFromId(questionIds).getBody();
			
			
			return questions;
		}	
		else
		{
			throw new QuizNotfoundException("Quiz with id "+id+" not exist!!");
		}
		
	}
	
	public Integer calculateScore(Integer id, List<Response> responses) 
	{
		if(quizRepo.findById(id).isPresent())
		{
			Quiz quiz = quizRepo.findById(id).get();
			
			return quizInterface.getQuizScore(responses).getBody();
		}
		else
		{
			throw new QuizNotfoundException("Quiz with id "+id+" not exist!!");
		}
		
	}
}
