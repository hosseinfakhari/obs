FROM gradle:jdk21-graal as base

WORKDIR /opt/obs

COPY . .

RUN gradle build -x test --refresh-dependencies

FROM openjdk:19-jdk-alpine

WORKDIR /opt/obs

COPY --from=base /opt/obs/build/libs/obs-0.0.1-SNAPSHOT.jar /opt/obs

CMD java -jar obs-0.0.1-SNAPSHOT.jar