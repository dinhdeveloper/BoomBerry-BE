# =========================
# Build stage
# =========================
FROM eclipse-temurin:17 AS build
WORKDIR /app

# Copy Gradle wrapper & project
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

# Chmod gradlew
RUN chmod +x ./gradlew

# Build jar (skip tests)
RUN ./gradlew build -x test

# =========================
# Run stage
# =========================
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy jar từ build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose port Spring Boot
EXPOSE 3000

# Run Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
