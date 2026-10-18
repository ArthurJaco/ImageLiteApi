# Etapa de build: Maven compila o projeto usando o JDK 17.
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /workspace

# Baixa dependências antes do código para aproveitar o cache do Docker.
COPY pom.xml ./
RUN mvn -B dependency:go-offline

COPY src ./src
RUN mvn -B -DskipTests package

# Etapa de execução: leva apenas o JAR e um runtime Java menor.
FROM eclipse-temurin:17-jre-jammy AS runtime
WORKDIR /app

RUN groupadd --system app && useradd --system --gid app app
COPY --from=build --chown=app:app /workspace/target/*.jar /app/app.jar

USER app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
