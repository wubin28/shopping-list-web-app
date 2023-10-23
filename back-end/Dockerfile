FROM bellsoft/liberica-runtime-container:jre-17-slim-glibc

VOLUME /tmp

ARG JAR_FILE

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
