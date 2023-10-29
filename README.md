# Recipe Management System

The Recipe Management System is an API that allows users to store, manage, and interact with recipes. This application supports CRUD operations for recipes, enabling users to create, read, update, and delete recipes. Users can also comment on recipes and search for recipes.

## Table of Contents

- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Features](#features)
- [Database Configuration](#database-configuration)
- [Static IP Address](#static-ip-address)
- [Validation](#validation)
- [API Endpoints](#api-endpoints)
- [MVC Architecture](#mvc-architecture)
- [Setup and Deployment](#setup-and-deployment)
- [Contributing](#contributing)
- [License](#license)

## Project Overview

The Recipe Management System provides an API for users to create, read, update, and delete recipes. Each recipe can include information such as a name, ingredients, and instructions. Additionally, users can comment on recipes and search for recipes.

## Technologies Used

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- MySQL
- Lombok
- Swagger
- Maven

## Project Structure

The project follows a structured layout:

- src/main/java: Contains Java source code.
  - com.example.recipeapp.controller: Controllers for handling API requests.
  - com.example.recipeapp.model: Entity classes representing recipe data.
  - com.example.recipeapp.repository: JPA repositories for database interaction.
  - com.example.recipeapp.service: Services for business logic.
  - com.example.recipeapp.validation: Annotation-based validation for request payloads.
- src/main/resources: Contains configuration files and static resources.
- pom.xml: Maven configuration file specifying project dependencies.

## Features

The Recipe Management System offers several key features:

- *Recipe Management*:
  - Create, read, update, and delete recipes, including details like name, ingredients, and instructions.
- *Commenting*:
  - Users can post comments on recipes.
- *Recipe Search*:
  - Users can search for specific recipes.
- *Validation*:
  - Utilizes annotation-based validation for data integrity.
- *Swagger Documentation*:
  - Access Swagger API documentation for testing and exploring endpoints.

## Database Configuration

To set up your MySQL database connection, configure the following in application.properties:

spring.datasource.url= jdbc:mysql://localhost:3306/recipeDb
spring.datasource.username={user}
spring.datasource.password={userpassword}

## Static IP Address

For deployment, it is essential to ensure that your server has a static IP address to maintain consistent accessibility.

## Validation

The application incorporates annotation-based validation to ensure data integrity and security.

## API Endpoints

- *Comment on Recipe*:
  - POST /comment/recipeId: Post a comment on a specific recipe.

- *Delete Comment*:
  - DELETE /comment: Delete a comment.

- *Update Comment*:
  - PUT /comment: Update a comment.

- *Get Comments for Recipe*:
  - GET /comment/{recipeId}: Retrieve comments for a specific recipe.

- *Create Recipe*:
  - POST /Recipe: Create a new recipe.

- *Update Recipe*:
  - PUT /Recipe: Update a recipe.

- *Delete Recipe*:
  - DELETE /Recipe: Delete a recipe.

- *Get All Recipes*:
  - GET /recipe/all: Retrieve all recipes.

- *Get Recipe by ID*:
  - GET /recipe/id: Retrieve a recipe by its ID.

- *User Sign-Up*:
  - POST /user/signUp: Register a new user.

- *User Sign-In*:
  - POST /user/signIn/{email}/{password}: Log in as a user.

- *User Sign-Out*:
  - DELETE /user/signOut: Log out the user.

## MVC Architecture

The Recipe Management System follows the Model-View-Controller (MVC) architectural pattern, promoting code organization and maintainability.
<!-- Acknowledgments -->
## Acknowledgments
- Thank you to the Spring Boot and Java communities for providing excellent tools and resources.

<!-- Contact -->
## Contact
For questions or feedback, please contact : ankit aggarwal 
- Maild Id : kuldeepaggarwal305@gmail.com

<h1 align="center">Thank You...<h1>
<h3 align = "center"> ***********************************************************<h3>
