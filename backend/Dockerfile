FROM gradle:8.7-jdk17
ENV APP_HOME=/usr/app/backend
WORKDIR $APP_HOME
COPY settings.gradle.kts $APP_HOME
COPY build.gradle.kts $APP_HOME
COPY --chown=gradle:gradle src/ $APP_HOME/src
RUN gradle clean build -x test
RUN rm $APP_HOME/build/libs/arkanoid-1.0-plain.war
RUN mv $APP_HOME/build/libs/arkanoid-1.0.war $APP_HOME/build/libs/arkanoid.war