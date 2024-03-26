package com.telusko.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.exception.QuestionNotFoundException;
import com.telusko.model.Question;
import com.telusko.repo.QuestionRepo;

@Service 
public class QuestionService 
{
	@Autowired
	private QuestionRepo questionRepo;
	
	public List<Question> getAllQuestions()
	{
		return questionRepo.findAll();
	}
	
	public String addQuestion(Question question)
	{
		Integer id=questionRepo.save(question).getId();
		
		return "Question added with id : "+id;
	}
	
	public List<Question> getQuestionsByCategory(String category)
	{
		return questionRepo.findByCategory(category);
	}
	
	public String updateQuestionById(Integer id,Question question) 
	{
		 if(questionRepo.findById(id).isPresent())
		 {
			 questionRepo.save(question);
			 
			 return "Question with id "+id+" has updated successfully!!";
		 }
		 else
		 {
			 throw new QuestionNotFoundException("Question with id "+id+" doesn't exist!!");
		 }
	}
	
	public String deleteQuestionById(Integer id) 
	{
		 if(questionRepo.findById(id).isPresent())
		 {
			 questionRepo.deleteById(id);
			 
			 return "Question with id "+id+" has deleted successfully!!";
		 }
		 else
		 {
			 throw new QuestionNotFoundException("Question with id "+id+" doesn't exist!!");
		 }
	}
	
}
