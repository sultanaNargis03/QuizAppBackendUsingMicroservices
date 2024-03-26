package com.telusko.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;

import com.telusko.exception.QuizNotfoundException;
import com.telusko.model.Question;
import com.telusko.model.QuestionWrapper;
import com.telusko.model.Quiz;
import com.telusko.model.Response;
import com.telusko.repo.QuestionRepo;
import com.telusko.repo.QuizRepo;

@Service
public class QuizService 
{
	@Autowired
	private QuizRepo quizRepo;
	
	@Autowired
	private QuestionRepo qusetionRepo;

	public List<QuestionWrapper> getQuizQuestions(Integer id)
	{
		if(quizRepo.findById(id).isPresent())
		{
			List<QuestionWrapper> listqw=new ArrayList<>();
			
			Quiz quiz = quizRepo.findById(id).get();
			List<Question> list = quiz.getQuestions();
			
			for(Question q:list)
			{
				QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
				listqw.add(qw);
			}
			
			return listqw;
		}	
		else
		{
			throw new QuizNotfoundException("Quiz with id "+id+" not exist!!");
		}
	}
	
	public String createQuiz(String category,Integer numQ,String title)
	{
		List<Question> questions = qusetionRepo.findRandomQuestionsByCategory(category,numQ);
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizRepo.save(quiz);
		
		return "Quiz created successfully with id "+quiz.getId();
	}

	public Integer calculateScore(Integer id, List<Response> responses) 
	{
		if(quizRepo.findById(id).isPresent())
		{
			Quiz quiz = quizRepo.findById(id).get();
			List<Question> questions = quiz.getQuestions();
			
			int right=0;
			int i=0;
			
			for(Response r:responses)
			{
				if(r.getResponse().equals(questions.get(i).getRightAnswer()))
				{
					right++;
				}
				i++;
			}
			
			return right;
		}
		else
		{
			throw new QuizNotfoundException("Quiz with id "+id+" not exist!!");
		}
	}
}
