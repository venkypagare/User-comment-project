# User-comment-project
Task of User-comment-project by Vijayi WFH Technologies Private Limited

# Spring Boot Comment System

This project implements a simple comment system with Spring Boot and PostgreSQL.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Build and Run](#build-and-run)
- [API Endpoints](#api-endpoints)
  - [1. Add Comment](#1-add-comment)
  - [2. Get Comments](#2-get-comments)
- [Testing with Postman](#testing-with-postman)
- [Additional Notes](#additional-notes)

## Prerequisites

Before you begin, make sure you have the following installed on your machine:

- Java Development Kit (JDK) 11 or later
- PostgreSQL Database

## Setup

1. Clone the repository:

   ```bash
   git clone <repository-url>

Note: Create a PostgreSQL database with the name comment_system. Update the application.properties file in the src/main/resources directory with your database configuration.

2. Build the project:
cd comment-system
./mvnw clean install

3. Build the JAR file:
./mvnw clean install

4.Run the application:
Note: The Spring Boot application should now be running on http://localhost:8080.

## API Endpoints
1. Add Comment
Endpoint: http://localhost:8080/add-comment

Method: POST

Request JSON:
{
    "fromUserName": "UserA",
    "toUserName": "UserB",
    "message": "This is a test comment."
}

Response:
{
    "message": "Comment added successfully."
}

2. Get Comments
Endpoint: http://localhost:8080/get-comments

Method: GET

Request Params:

toUserName: User name for which you want to retrieve comments, e.g., UserB
Response:
[
    {
        "id": 1,
        "message": "This is a test comment.",
        "dateTime": "2023-01-01T12:00:00",
        "postedByUserId": 1
    },
    // Additional comments...
]

## Additional Notes
This project uses Spring Boot and PostgreSQL for the backend.
The project includes validations for user names and provides error messages for invalid requests.
Transaction management using @Transactional is implemented where necessary.

Replace `<repository-url>` in the clone command with the actual URL of your Git repository. Also, you can replace `link-to-postman-collection` with the link to your Postman Collection if you create one.
