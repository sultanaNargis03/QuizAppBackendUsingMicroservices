package com.telusko.model;

public class Response 
{
	private Integer id;
	private  String response;
	
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Response(Integer id, String response) {
		super();
		this.id = id;
		this.response = response;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "Response [id=" + id + ", response=" + response + "]";
	}
	
	
}
