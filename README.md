# User Management System [Validated]

## Built With
* `Java 17`
* `Maven 4.0.0`
* `Spring Boot 3.0.5`
*  `IntelliJ IDEA 2023.1 (Community Edition)`


## Data Flow

### 1. Model:
* Created User class along with data userID, userName, dob, number, emailID, date and time and added validations on them
* Used Lombok to reduce boilerplate code for pojo class.By using Lombok annotations like @Data, @NoArgsConstructor, @AllArgsConstructor getters and setters for those object generate automatically.
* Used various validation like @NotNull, @NotEmpty, @NotBlank, @Min, @Max, @Size, @Email and @Pattern on the fields.

### 2. Controller:
* Created UserController class in which used the annotations like **@RestController** to annotate the class as Controller.
* Used annotation @GetMapping , @PostMapping , @PutMapping , @DeleteMapping to map the HTTP web requests to the specific handler methods.
* Used @Valid annotations to trigger validations while inserting data.

#### API Reference:

* Add User
```*.sh-session
  http://localhost:8080/addUsers
```

* Get all Users
```*.sh-session
  http://localhost:8080/getAllUser
```

* Get User By ID
```*.sh-session
  http://localhost:8080/getUserById/{userID}
```

* Update User's Email and Phone No. By ID
```*.sh-session
  http://localhost:8080/updateUserInfo/{userID}/{emailID}/{phoneNum}
```

* Delete User by ID
```*.sh-session
  http://localhost:8080/deleteUser/{userID}
```



### 3. Service:
* Created UserService class in which provide some business functionalities of every handler methods.
* Used **@Service** annotation to indicate that a class belongs to the service layer.

### 4. Repository:
* Created UserDao class usually represent the database access layer in an application.
* Used ArrayList to manage the data of Users by performing CRUD operations.
* Used **@Repository** annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.

## Data Structure Used
Used ArrayList to store the User type object.


## Project Summary
In this project we performed CRUD operation like add user,get user,delete user and update user.<br>
I had also performed validation by using various validations annotations like @NotNull, @NotEmpty, @NotBlank, @Min, @Max, @Size, @Email and @Pattern on the fields.

