# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY out/artifacts/socialledger_jar/socialledger.jar /app/socialledger.jar

# Specify the command to run on container startup
CMD ["java", "-jar", "socialledger.jar"]
