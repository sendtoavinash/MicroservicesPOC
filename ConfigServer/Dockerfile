FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} configserver.jar

ENTRYPOINT ["java", "-jar", "/configserver.jar"]
CMD ["git", "config", "--global", "http.sslVerify", "true"]

EXPOSE 9296