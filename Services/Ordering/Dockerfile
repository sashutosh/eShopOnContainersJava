FROM maven:3.5-jdk-8 as BUILD_IMAGE
COPY src /usr/src/ordering/src
COPY pom.xml /usr/src/ordering/src
RUN mvn -f /usr/src/ordering/src/pom.xml clean package -DskipTests

FROM openjdk:8-jre
WORKDIR /root/
COPY --from=BUILD_IMAGE /usr/src/ordering/ordering.jar .
EXPOSE 80
CMD ["java","-jar","ordering.jar"]



