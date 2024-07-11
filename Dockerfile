FROM openjdk:17
ADD target/EmployeeService-0.0.1-SNAPSHOT.jar EmployeeService.jar
ENTRYPOINT ["java", "-jar", "EmployeeService.jar.jar"]