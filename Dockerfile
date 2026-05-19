# Використовуємо образ OpenJDK для Spring Boot
FROM eclipse-temurin:17-jdk
# Вказуємо робочий каталог
WORKDIR /app
# Копіюємо jar-файл у контейнер
COPY target/*.jar app.jar
# Вказуємо команду для запуску Spring Boot застосунку
ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8081