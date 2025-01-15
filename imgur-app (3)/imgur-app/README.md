
# Imgur Integration Spring Boot App

## Overview

This application provides REST APIs to:
1. Register users with basic information (username and password).
2. Authenticate users to upload, view, and delete images.
3. Integrate with the Imgur API for image management.
4. Retrieve user profiles and associated image details.

The application is built using Spring Boot 3.x.x, Java 17, and H2 in-memory database.

## Design Approach

### Architecture
- **Controller Layer**: Handles incoming HTTP requests and delegates processing to the Service Layer.
- **Service Layer**: Contains the business logic of the application.
- **Repository Layer**: Interacts with the H2 database using Spring Data JPA.

### Features
- **User Registration**: Users are stored in the H2 database with encrypted passwords using BCrypt.
- **Authentication**: Username and password are validated before allowing image operations.
- **Imgur Integration**: Interacts with Imgur API for uploading, viewing, and deleting images.
- **Logging**: Comprehensive logging is implemented for debugging and monitoring.
- **Testing**: JUnit test cases are implemented for service methods.

### Dependencies
- **Spring Boot Starter Data JPA**: For database interaction.
- **Spring Boot Starter Web**: For REST APIs.
- **Spring Boot Starter Security**: For password encryption and authentication.
- **H2 Database**: For in-memory storage.
- **JUnit & Mockito**: For unit testing.

## API Endpoints

### User APIs
- **POST /api/register**: Register a new user.

### Image APIs
- **POST /api/images/upload**: Upload an image.
- **GET /api/images/view**: View uploaded images.
- **DELETE /api/images/delete/{id}**: Delete an image.

## Imgur Integration
The application uses Imgur's API for image management. Follow the steps below to set up an Imgur account and get API credentials:
1. Sign in to Imgur using Twitter/Facebook/Gmail.
2. Obtain the Client ID and Client Secret from Imgur Developer Settings.

## Setup Instructions
1. Clone the repository from GitHub/Bitbucket.
2. Build the project using Maven: `mvn clean install`.
3. Run the application: `mvn spring-boot:run`.
4. Access the application at `http://localhost:8080`.

## Additional Notes
- Ensure you have Java 17 installed on your system.
- The H2 database console is accessible at `http://localhost:8080/h2-console`.

## Future Enhancements
1. Secure APIs with OAuth2.
2. Optimize APIs for high throughput (100K RPM).
3. Implement CI/CD pipeline.
4. Add a messaging platform (e.g., Kafka) for image-related notifications.

## Testing
Run the test cases using: `mvn test`.

