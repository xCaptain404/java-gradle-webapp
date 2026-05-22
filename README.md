# Java Gradle Webapp

A fully functional Java web application built with **Gradle** for build automation, designed to run on Apache Tomcat without a database.

## 🎯 Project Overview

This project demonstrates:
- Java Servlet development
- REST API endpoints
- Gradle build automation
- Web application structure and deployment
- In-memory data management (no database)

## 🏗️ Project Structure

```
java-gradle-webapp/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/
│   │   │       ├── controller/
│   │   │       │   ├── HelloServlet.java
│   │   │       │   └── UserServlet.java
│   │   │       ├── model/
│   │   │       │   └── User.java
│   │   │       └── service/
│   │   │           └── UserService.java
│   │   └── webapp/
│   │       ├── WEB-INF/
│   │       │   └── web.xml
│   │       ├── index.html
│   │       └── error.html
│   └── test/
│       └── java/
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── build.gradle
├── settings.gradle
├── gradlew
├── gradlew.bat
├── .gitignore
└── README.md
```

## 🔧 Technologies Used

- **Java 11** - Programming language
- **Gradle 7.5.1** - Build automation and dependency management
- **Apache Tomcat 9** - Servlet container (target deployment)
- **Servlet 4.0 API** - Web application framework
- **GSON** - JSON serialization/deserialization
- **SLF4J** - Logging framework
- **JUnit 4** - Testing framework

## 📋 Prerequisites

- Java 11 or higher installed
- Gradle 7.5.1 (or use the included Gradle Wrapper)
- Apache Tomcat 9 (for deployment)
- Linux VM with Tomcat installed (for deployment)

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/xCaptain404/java-gradle-webapp.git
cd java-gradle-webapp
```

### 2. Build the Project

Using Gradle Wrapper:

```bash
# Linux/Mac
./gradlew build

# Windows
.\gradlew.bat build
```

Or with Gradle installed:

```bash
gradle build
```

### 3. Run Locally with Gretty Plugin

```bash
./gradlew appRun
```

The application will be accessible at: `http://localhost:8080`

### 4. Build WAR File

```bash
./gradlew war
```

The WAR file will be created at: `build/libs/java-gradle-webapp-1.0.0.war`

## 💡 API Endpoints

### 1. Hello Servlet

**GET** `/hello`

Simple servlet that returns HTML response.

**Example:**
```bash
curl http://localhost:8080/hello
```

### 2. User API - Get All Users

**GET** `/api/user?action=list`

Returns all users in JSON format.

**Response:**
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "email": "john@example.com",
    "city": "New York",
    "createdAt": "2024-05-22T10:30:00"
  },
  ...
]
```

### 3. User API - Get User by ID

**GET** `/api/user?action=get&id=1`

Returns a specific user by ID.

**Response:**
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com",
  "city": "New York",
  "createdAt": "2024-05-22T10:30:00"
}
```

### 4. User API - Create User

**POST** `/api/user`

Creates a new user.

**Parameters:**
- `name` (required) - User's full name
- `email` (required) - User's email address
- `city` (required) - User's city

**Example:**
```bash
curl -X POST http://localhost:8080/api/user \
  -d "name=Alice Johnson" \
  -d "email=alice@example.com" \
  -d "city=Boston"
```

**Response:**
```json
{
  "id": 4,
  "name": "Alice Johnson",
  "email": "alice@example.com",
  "city": "Boston",
  "createdAt": "2024-05-22T10:35:00"
}
```

## 📦 Deployment to Linux Tomcat VM

### 1. Build the WAR file

```bash
./gradlew war
```

### 2. Copy WAR to Tomcat

```bash
# On your development machine
scp build/libs/java-gradle-webapp-1.0.0.war user@your-vm-ip:/path/to/tomcat/webapps/

# Or rename for root deployment
scp build/libs/java-gradle-webapp-1.0.0.war user@your-vm-ip:/path/to/tomcat/webapps/ROOT.war
```

### 3. Restart Tomcat

```bash
# SSH into the VM
ssh user@your-vm-ip

# Navigate to Tomcat
cd /path/to/tomcat

# Stop Tomcat
bin/shutdown.sh

# Start Tomcat
bin/startup.sh

# Check logs
tail -f logs/catalina.out
```

### 4. Access the Application

```
http://your-vm-ip:8080/
or
http://your-vm-ip:8080/java-gradle-webapp (if not deployed as ROOT)
```

## 🔨 Gradle Commands

```bash
# Build the project
./gradlew build

# Clean build
./gradlew clean

# Run tests
./gradlew test

# Build WAR
./gradlew war

# Display Gradle tasks
./gradlew tasks

# Show dependencies
./gradlew dependencies

# Run locally with Gretty
./gradlew appRun

# Debug run
./gradlew appRunDebug
```

## 📚 Understanding Gradle

This project uses Gradle for build automation. Key files:

### build.gradle
Defines:
- Plugins (java, war, gretty)
- Dependencies (servlets, logging, JSON processing)
- Build properties
- Custom tasks

### settings.gradle
Defines the root project name

### gradle wrapper
Allows building without Gradle installation

## 🧪 Testing

Run tests using:

```bash
./gradlew test
```

## 📄 File Descriptions

### Controllers
- **HelloServlet.java** - Basic servlet demonstrating simple request/response
- **UserServlet.java** - REST API servlet for user management

### Models
- **User.java** - User entity/POJO

### Services
- **UserService.java** - Business logic for user operations (in-memory storage)

### Web Files
- **index.html** - Interactive frontend for testing the API
- **error.html** - Error page
- **web.xml** - Web application deployment descriptor

## 🔐 Security Notes

This is a demonstration project. For production:
- Add input validation and sanitization
- Implement authentication and authorization
- Use HTTPS
- Add CSRF protection
- Implement proper error handling
- Use a proper database instead of in-memory storage
- Add rate limiting

## 📖 Learning Resources

- [Gradle Official Documentation](https://docs.gradle.org/)
- [Apache Tomcat Documentation](https://tomcat.apache.org/)
- [Java Servlets Tutorial](https://docs.oracle.com/javaee/7/tutorial/servlets.htm)
- [REST API Best Practices](https://restfulapi.net/)

## 🤝 Contributing

Feel free to fork and submit pull requests for improvements.

## 📄 License

This project is open source and available under the MIT License.

## 👤 Author

**xCaptain404**

## 🆘 Troubleshooting

### Port 8080 already in use

```bash
./gradlew appRun -Dhttp.port=8081
```

### Gradle wrapper permission denied

```bash
chmod +x gradlew
```

### Build fails with Java version error

Ensure Java 11+ is installed:
```bash
java -version
```

### WAR deployment not working

- Check Tomcat logs: `logs/catalina.out`
- Verify WAR file syntax: `unzip -l java-gradle-webapp-1.0.0.war`
- Ensure correct permissions on webapps folder

---

**Happy coding! 🚀**
