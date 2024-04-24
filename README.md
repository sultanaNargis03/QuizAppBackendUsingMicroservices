
# QuizAppBackendUsingMicroservices

This repository contains the backend code for a quiz app, designed to facilitate play quiz. Built with Spring Boot and integrated with PostgreSQL, it supports full CRUD operations.


## Features

- Create, Read, Update, and Delete Question records as well as Quiz Records
- Play quiz and calculate the score based on correct responses
- Integration with PostgreSQL for data persistence
- RESTful API endpoints



## Prerequisite

- Java JDK 17 or later
- Maven 3.6 or later
- PostgreSQL


## Setup
1. Clone the repository:

git clone 
    https://github.com/sultanaNargis03/QuizAppBackendUsingMicroservices.git

2. Navigate to the project directory:

    cd QuizAppBackendUsingMicroservices

3. Configure PostgreSQL connection in src/main/resources/application.properties:
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=postgres
spring.datasource.password=yourpassword

4. Build and run the application:
    mvn spring-boot:run
## Usage

    The application exposes RESTful endpoints:

1. QuizService

- POST/api/create - create a new quiz
- GET /api/allquiz - Retrieve all quizes
- POST /api/submit/{id} - Submit the quiz
- GET /api/fetchquiz/{id} - Retrieve a quiz by ID
- DELETE /api/delete/{id} - Delete a quiz by ID


2. QuestionService

- POST/api/addquestion - add a new question
- GET /api/allquestions - Retrieve all questions
- GET /api/category/{category} - Retrieve question by CATEGORY
- POST /api/submit/{id} - Submit the quiz
- GET /api/getQuestion/{id} - Retrieve a question by ID
- PUT /api/update/{id} - Update a question by ID
- DELETE /api/delete/{id} - Delete a question by ID
- GET /api/randomquestion - Generate Questions for QuizService
- POST /api/getquestions - Get Question from ID
- POST /api/getscore - Calculate Quiz Score

3. ServiceRegistry

    To holds the information about QuizService and QuestionService

4.  ApiGateway

    Make a single point of entry for Quiz and Question Microservices
## Contributing

Contributions are welcome! Please feel free to submit a pull request.