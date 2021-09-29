## Environment:

- Java version: 1.8
- Maven version: 3.*
- Spring Boot version: 2.2.1.RELEASE

## Data:
User JSON object:

```json
{
  "username": "jdoe",
  "firstName": "John",
  "firstName": "Doe",
  "birthDate": "1986-03-12"
}
```

Post JSON object:
```json
{
    "title": "My first post",
    "userId": 1
}
```

## Requirements:

Create the next Endpoints

### Users: 

- POST /users
- GET /users/{id}
- DELETE /users/{id}

### Posts:

- POST /users/{id}/posts
- GET /users/{id}/posts/{id}
- DELETE /users/{id}/posts/{id}

## Requirements by Http Method

* POST:
  - If successful, return status code 201, and in the response body the created resource
  - If a value is invalid in the JSON object, return status code 400. For example, if the User attribute birthDate is not a valid
    date.
  - All the attributes of the JSON objects are required. return 400 if one value is missing.
  
* GET:
  - If there is no resource, return an empty collection.
  
* GET with id:
  - if there is no resource in the collection with a given id, the response code is 404.
  - 
* DELETE
  - if there is no resource with a given id, the response code is 404.
  - If the user has posts, delete the user resource and the associated posts.

## Considerations

- You must persist the data in h2 database using JPA.
- Use bean validation to ensure that all properties have a value in the object to persist.

## Command

$ ./mvnw clean spring-boot:run



