# Spring Boot Student CRUD Application

This repository contains a simple Spring Boot application for managing student information with CRUD operations. The application exposes RESTful APIs and runs on port 9000.

## Getting Started

Follow these steps to set up and run the Spring Boot application locally.

### Prerequisites

- Java 11 or later
- Maven

### Clone the Repository

```bash
git clone https://github.com/your-username/springboot-student-crud.git


GET /Students/getAll => returns all the students
GET /Students/course/{courseName} => returns the students according to the course name parameter
POST /Students/AddStudent => This API is used add the new student
PUT /Students/UpdateStudent => This API is used update the student
DELETE /Students/DeleteStudent => This API is used to delete the student

Technologies Used :
Spring Boot
Spring Data JPA
Maven

Contributor :
Padmanabh Malwade
