# <h1 align = "center"> RECIPE MANAGEMENT </h1>
___ 
<p align="center">
<a href="Java url">
    <img alt="Java" src="https://icon-icons.com/icon/java-original-logo/146458" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.5-brightgreen.svg" />
</a>
<a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.0.6-brightgreen.svg" />
</a>
    <img alt = "License: MIT" src="https://img.shields.io/badge/License-MIT-yellow.svg" />
    </a>
</p>


---

<p align="left">


## Overview

This project, named "RECIPE MANAGEMENT" is a robust Spring Boot application designed for managing user data efficiently. It provides a set of RESTful API endpoints that allow you to perform various operations on user records, such as adding, retrieving, updating, and deleting user information. 

## Technologies Used

- **Framework:** Spring Boot
- **Language:** Java
- **Build Tool:** Maven

## Data Flow

### Controller

The Controller layer is responsible for handling incoming HTTP requests and delegating them to the appropriate services. It defines API endpoints for the following operations:

# Recipe Management System - Controller

This README provides an overview of the Controller component in the Recipe Management System, explaining how it handles HTTP requests and interactions between the client and the application's backend.

## Overview

The Controller component in the Recipe Management System is responsible for processing incoming HTTP requests from clients (e.g., a web browser or mobile app) and routing these requests to the appropriate parts of the application. It acts as an intermediary between the client and the application's business logic.

## Endpoints

The Recipe Controller defines various endpoints that allow users to perform operations related to recipes. These endpoints are typically mapped to specific URLs and HTTP methods. Here are some common recipe-related endpoints:

- **Create Recipe:** `POST /recipes`
  - Allows users to create a new recipe by providing recipe details in the request body.

- **Get Recipe by ID:** `GET /recipes/{recipeId}`
  - Retrieves a specific recipe by its unique identifier (recipeId).

- **Get All Recipes:** `GET /recipes`
  - Retrieves a list of all recipes in the system.

- **Update Recipe:** `PUT /recipes/{recipeId}`
  - Allows users to update an existing recipe by providing the updated recipe details in the request body.

- **Delete Recipe:** `DELETE /recipes/{recipeId}`
  - Deletes a recipe with a specified recipeId.

## Example Code

Here's an example of a Recipe Controller in Java using Spring Boot:

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

    @GetMapping("/{recipeId}")
    public Recipe getRecipeById(@PathVariable Long recipeId) {
        return recipeService.getRecipeById(recipeId);
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @PutMapping("/{recipeId}")
    public Recipe updateRecipe(@PathVariable Long recipeId, @RequestBody Recipe updatedRecipe) {
        return recipeService.updateRecipe(recipeId, updatedRecipe);
    }

    @DeleteMapping("/{recipeId}")
    public void deleteRecipe(@PathVariable Long recipeId) {
        recipeService.deleteRecipe(recipeId);
    }
}

## Services

The Services layer implements the core business logic, data processing, and interaction with the data repository. Key responsibilities include:

- Validating input data.
- Performing CRUD operations on user data.
- Handling data transformations and interactions with external systems (if applicable).

## Recipe Management System - Services

This README provides an overview of the Services component in the Recipe Management System, explaining its role in implementing business logic and managing recipe-related operations.

## Overview

The Services component in the Recipe Management System is responsible for implementing the core business logic and data processing. It acts as an intermediary between the Controller and the Repository, handling requests, processing data, and ensuring the integrity of recipe-related operations.

## Key Responsibilities

1. Validating input data to ensure data integrity and consistency.
2. Implementing CRUD (Create, Read, Update, Delete) operations for recipe data.
3. Handling data transformations and interactions with external systems (if applicable).
4. Implementing business rules and logic specific to recipe management.

## Example Code

Here's an example of a Recipe Service in Java using Spring Boot:

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Recipe createRecipe(Recipe recipe) {
        // Implement validation and business logic here
        return recipeRepository.save(recipe);
    }

    public Recipe getRecipeById(Long recipeId) {
        return recipeRepository.findById(recipeId).orElse(null);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe updateRecipe(Long recipeId, Recipe updatedRecipe) {
        // Implement update logic here
        return recipeRepository.save(updatedRecipe);
    }

    public void deleteRecipe(Long recipeId) {
        recipeRepository.deleteById(recipeId);
    }
}

## Repository

The Repository layer manages data access to the underlying database. It handles database operations such as Create, Read, Update, and Delete (CRUD) for user data. Additionally, it may include data mapping and conversion between Java objects and database entities.

```java
@Repository
public class UserRepo {
    @Autowired
    private List<User> userList;

    public List<User> getUsers() {
        return userList;
    }

    // ...
}
```




# Recipe Management System - Database Design

This README provides an overview of the Database Design in the Recipe Management System, explaining how the database schema is structured and the purpose of each table and field.

## Overview

The Database Design in the Recipe Management System plays a crucial role in storing and managing recipe-related data efficiently. It defines the structure of the database, including tables, fields, relationships, and constraints.

## Database Schema

The Recipe Management System typically includes the following tables and their respective fields:

### `Recipe`

- `recipeId` (Primary Key): An integer serving as a unique identifier for each recipe.
- `title`: A string representing the title or name of the recipe.
- `description`: A text field for a brief description of the recipe.
- `ingredients`: A text or JSON field listing the ingredients required for the recipe.
- `instructions`: A text or JSON field describing the preparation steps.
- `imageUrl`: A string containing the URL or path to an image associated with the recipe.
- `createdDate`: A timestamp indicating when the recipe was created.
- `modifiedDate`: A timestamp indicating the last modification date of the recipe.

### `User`

- `userId` (Primary Key): An integer serving as a unique identifier for each user.
- `username`: A string representing the user's unique username or identifier.
- `email`: A string containing the user's email address for communication.
- `password`: A secure hash of the user's password.
- `createdDate`: A timestamp indicating when the user account was created.

### Additional Tables (Optional)

Depending on the system's requirements, you may have additional tables to handle categories, tags, user roles, and other related data. You can expand the database design as needed.

## Relationships

The Recipe Management System may establish the following relationships between tables:

- Each `Recipe` is associated with a specific `User` who created it. This is typically achieved through a foreign key relationship between the `Recipe` table and the `User` table.

- Relationships with additional tables may be established, such as a many-to-many relationship between recipes and categories or tags.

## Data Integrity and Constraints

To ensure data integrity, consider implementing the following constraints:

- Foreign key constraints to enforce relationships between tables.
- Unique constraints on fields like `username` and `email` in the `User` table to prevent duplicate entries.
- Check constraints to validate data, such as ensuring that dates are within a reasonable range.

## Usage

Understanding the database design is essential for managing and maintaining the Recipe Management System. It allows for efficient storage, retrieval, and manipulation of recipe-related data.

Please review the database schema carefully to ensure it aligns with the system's requirements, and make any necessary adjustments as your project evolves.




## Data Structures Used

The project utilizes the following data structures:

### User Class

The `User` class defines the structure for user data and includes the following fields:

- `userId` (User ID): An integer that serves as a unique identifier for each user.
- `userName` (User Name): A string representing the user's full name.
- `type` (User Type): An enumeration specifying the user type, including ADMIN, INTERNAL, and EXTERNAL.
- `userEmail` (Email Address): A string containing the user's email address.
- `userContactNo` (Phone Number): A string representing the user's phone number (e.g., 911234567890).
- `dob` (Date of Birth): A date field indicating the user's date of birth.
- Timestamps for record creation and modification.

### Type Enum

The `Type` enum enumerates the possible user types:

- `ADMIN`: Represents an administrator user.
- `INTERNAL`: Represents an internal user.
- `EXTERNAL`: Represents an external user.

### ArrayList

The project utilizes the `ArrayList` data structure to store and manage lists of `User` objects in various parts of the application. `ArrayList` provides dynamic sizing and efficient element retrieval, making it suitable for storing user records and performing operations on them.

These data structures enable the application to organize and manipulate user data efficiently while maintaining data integrity.


## Project Summary

The User Management project is a robust Spring Boot application designed for efficient user data management. It offers a set of RESTful API endpoints for various user-related operations, including adding, retrieving, updating, and deleting user information.

### Key Technologies Used

- **Framework:** Spring Boot
- **Language:** Java
- **Build Tool:** Maven

### Data Flow

#### Controller

The Controller layer handles incoming HTTP requests and routes them to the appropriate services. It defines API endpoints for operations such as adding, retrieving, updating, and deleting user records.

#### Services

The Services layer implements core business logic and data processing, including input validation, CRUD operations on user data, and data transformations.

#### Repository

The Repository layer manages data access to the underlying database, performing Create, Read, Update, and Delete (CRUD) operations for user data.

#### Database Design

The database design includes tables for user management, featuring fields like `userId`, `userName`, `type`, `userEmail`, `userContactNo`, `dob`, and timestamps for record creation and modification.

### Data Structures Used

- **User Class:** Defines the structure for user data, including user attributes and timestamps.
- **Type Enum:** Enumerates user types, such as ADMIN, INTERNAL, and EXTERNAL.
- **ArrayList:** Utilized for managing lists of `User` objects efficiently.


### Key Features

- RESTful API endpoints for user management.
- Data validation to ensure data integrity.
- Clean code separation with a layered architecture (Controller, Services, Repository).
- Robust error handling for improved reliability.
- Java-based backend and Maven for build management.

The User Management project serves as a practical example of Spring Boot application development, demonstrating best practices in API design and user data management. It offers a solid foundation for building and extending user management systems in various applications.


<!-- Acknowledgments -->
## Acknowledgments
- Thank you to the Spring Boot and Java communities for providing excellent tools and resources.

<!-- Contact -->
## Contact
For questions or feedback, please contact [Jones Edwin](mailto:jonesedwint@gmail.com).






