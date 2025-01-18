#Install Java 21 and Maven 3.8.7
FROM openjdk:21-jdk-slim AS builder

#Installiere Maven 3.8.7
RUN apt-get update
RUN apt-get install -y wget
RUN wget -q https://dlcdn.apache.org/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.tar.gz
RUN tar -xzf apache-maven-3.9.9-bin.tar.gz -C /opt/
RUN ln -s /opt/apache-maven-3.9.9/bin/mvn /usr/local/bin/mvn
RUN rm apache-maven-3.9.9-bin.tar.gz

WORKDIR /usr/motivateme_login
COPY . .
RUN mvn clean install -DskipTests

FROM openjdk:21-jdk-slim
WORKDIR /usr/motivateme_login
COPY --from=builder /usr/motivateme_login/target/motivateme-login-0.0.1-SNAPSHOT.jar /usr/motivateme_login/motivateme-login-0.0.1.jar
EXPOSE 8085
LABEL authors="norman"
CMD ["java", "-jar", "motivateme-login-0.0.1.jar"]