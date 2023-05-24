FROM java:8
EXPOSE 8080
ARG JAR_FILE=target/Notification-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} Notification-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Notification-0.0.1-SNAPSHOT.jar"]