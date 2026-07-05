# Multi-stage Dockerfile for building a Spring Boot app
FROM maven:3.9.4-eclipse-temurin-17 AS builder
WORKDIR /workspace
# cache dependencies
COPY pom.xml .
COPY src ./src

# Build the project (skip tests for faster image builds)
RUN mvn -B -DskipTests package

# Runtime image
FROM eclipse-temurin:17-jre-jammy
# Install curl so healthchecks work
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

WORKDIR /app
COPY --from=builder /workspace/target/*.jar /app/app.jar

EXPOSE 8085
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -jar /app/app.jar"]
