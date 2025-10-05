# Tic-Tac-Toe (Java)

## Overview
This is a Tic-Tac-Toe game implemented in Java using Gradle as the build system. The application is a console-based interactive game that runs in the terminal.

## Project Architecture

### Technology Stack
- **Language**: Java 21
- **Build System**: Gradle 8.10.2
- **Testing Framework**: JUnit Jupiter 5.10.3
- **Dependencies**: Google Guava 33.2.1-jre

### Project Structure
```
tic-tac-toe-java-template/
├── app/
│   ├── src/
│   │   ├── main/java/org/example/    # Main application code
│   │   └── test/java/org/example/    # Unit tests
│   └── build.gradle                  # Build configuration
├── gradle/                           # Gradle wrapper files
├── gradlew                           # Gradle wrapper script (Unix)
├── gradlew.bat                       # Gradle wrapper script (Windows)
└── settings.gradle                   # Project settings
```

### Main Class
- `org.example.App` - Entry point for the application

## Development

### Running the Application
The application is configured to run automatically via the workflow. You can also run it manually using:
```bash
./gradlew run --quiet --console=plain
```

### Building the Application
```bash
./gradlew build
```

### Running Tests
```bash
./gradlew test
```

## Replit Configuration

### Workflow
- **Name**: Tic-Tac-Toe
- **Command**: `./gradlew run --quiet --console=plain --no-daemon`
- **Output Type**: Console (interactive terminal application)

The `--no-daemon` flag ensures Gradle doesn't leave background processes running, which is important for the Replit environment.

## Recent Changes
- **2025-10-05**: Initial Replit setup
  - Installed Java toolchain (GraalVM 22.3)
  - Configured console workflow for interactive gameplay
  - Verified build and test execution
  - Created project documentation

## Notes
- This is a console-based application that requires user input via the terminal
- The workflow is configured to show console output for interactive gameplay
- Gradle daemon is disabled for better resource management in the Replit environment
