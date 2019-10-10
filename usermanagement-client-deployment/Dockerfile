FROM adoptopenjdk/openjdk11-openj9:jre-11.0.3_7_openj9-0.14.0-alpine
ADD target/usermanagement-client-deployment-0.1.0-thorntail.jar /opt/runnable.jar
EXPOSE 8080
# Default Environment variables
ENV keycloak.auth-server-url http://10.3.4.20:31000/auth
ENV keycloak.realm SIB
ENV keycloak.resource mic-utilisateur-gestion-client
ENV keycloak.secret 90233e1b-ca0a-412b-9831-406f5fee9ec2
ENTRYPOINT ["java", "-jar","-Djava.net.preferIPv4Stack=true","-Djava.net.preferIPv4Addresses=true", "-XX:MaxRAM=2G","/opt/runnable.jar"]