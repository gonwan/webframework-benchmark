FROM eclipse-temurin:21-jre-jammy
RUN mkdir -p /usr/local/@project.artifactId@
ADD maven/@project.build.finalName@.jar /usr/local/@project.artifactId@/
ENTRYPOINT [ "java", "-jar", "/usr/local/@project.artifactId@/@project.build.finalName@.jar" ]
