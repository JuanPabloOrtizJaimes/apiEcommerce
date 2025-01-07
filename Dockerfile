# Etapa 1: Construcción
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

# Copia los archivos del proyecto
COPY . .

# Compila el proyecto con Maven
RUN ./mvnw clean package -DskipTests

# Etapa 2: Ejecución
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copia el JAR generado en la etapa de construcción
COPY --from=builder /app/target/apiEcommerce-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto que usa la aplicación
EXPOSE 8081

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
