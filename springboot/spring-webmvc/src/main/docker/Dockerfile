FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY maven/@project.build.finalName@.jar ./
ENTRYPOINT [ "java", "-jar", "./@project.build.finalName@.jar" ]
