FROM openjdk:8
EXPOSE 8080
ADD  target/easy-chops.jar easy-chops.jar
ENTRYPOINT ["java", "-jar", "/easy-chops.jar"]