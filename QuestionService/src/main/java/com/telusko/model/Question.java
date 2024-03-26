package com.telusko.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Question 
{
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id; 
	private String category;
	private String difficltyLevel;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String questionTitle;
	private String rightAnswer;

	public Question() 
	{
		
	}

	public Question(Integer id, String category, String difficltyLevel, String option1, String option2, String option3,
			String option4, String questionTitle, String rightAnswer) {
		super();
		this.id = id;
		this.category = category;
		this.difficltyLevel = difficltyLevel;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.questionTitle = questionTitle;
		this.rightAnswer = rightAnswer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDifficltyLevel() {
		return difficltyLevel;
	}

	public void setDifficltyLevel(String difficltyLevel) {
		this.difficltyLevel = difficltyLevel;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", category=" + category + ", difficltyLevel=" + difficltyLevel + ", option1="
				+ option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4
				+ ", questionTitle=" + questionTitle + ", rightAnswer=" + rightAnswer + "]";
	}
	

}
