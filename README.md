# module3-rest-api

This project is a REST API built using Java, Spring Boot, and Maven. It allows users to view and submit ideas for improving their college campus.


API Endpoints

GET /api/ideas

Retrieves a list of all campus ideas.

URL: http://localhost:8080/api/ideas

Method: GET

The API returns a JSON array containing each idea's ID, title, and category.

POST /api/ideas

Allows users to submit a new campus idea.

URL: http://localhost:8080/api/ideas

Method: POST

Content-Type: application/json

Example request:

{
  "title": "Create a student tech lab",
  "category": "technology"
}

The API creates the idea, assigns it a unique ID, and returns the created idea with HTTP status 201 Created.

Automated Testing

The project includes JUnit unit tests and a Spring Boot API test.

To run all tests, execute:

mvn test
