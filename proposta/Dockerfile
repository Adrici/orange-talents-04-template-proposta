FROM openjdk:11-jdk

LABEL mantainer = "Adriana"

COPY target/proposta-*.jar /proposta.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/proposta.jar"]
