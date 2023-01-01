FROM openjdk:11

EXPOSE 8090

WORKDIR /applications

COPY target/stock-exchange-0.0.1.jar /applications/sample-application.jar

ENTRYPOINT ["java","-jar", "sample-application.jar"]