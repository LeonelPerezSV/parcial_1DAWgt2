# Utilizar la imagen de maven para compilar el proyecto
FROM maven:3.9.6-eclipse-temurin-17-focal AS build

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo pom.xml y descargar las dependencias del proyecto
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar todo el código fuente al contenedor
COPY src ./src

# Compilar el proyecto con Maven
RUN mvn package

# Segunda etapa del Dockerfile, utilizar la imagen de OpenJDK para ejecutar la aplicación
FROM openjdk:17

# Copiar el archivo JAR compilado desde la etapa anterior
COPY --from=build /app/target/crud-0.0.1-SNAPSHOT.jar /app/java-app.jar

# Establecer el comando de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/java-app.jar"]
