FROM openjdk:17-jdk-alpine

EXPOSE 80
RUN mkdir /app
COPY build/libs/*.jar /app/loyalty-bank.jar

RUN echo $SPRING_PROFILES_ACTIVE

ENTRYPOINT ["java", \
"-XX:+UnlockExperimentalVMOptions", \
"-XX:+UseContainerSupport", \
"-Dcom.sun.management.jmxremote", \
"-Dcom.sun.management.jmxremote.port=9875", \
"-Dcom.sun.management.jmxremote.local.only=false", \
"-Dcom.sun.management.jmxremote.authenticate=false", \
"-Dcom.sun.management.jmxremote.ssl=false", \
"-Djava.security.egd=file:/dev/./urandom", \
"-jar","/app/loyalty-bank.jar"  \
]
