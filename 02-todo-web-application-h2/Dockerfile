FROM tomcat:8.0.51-jre8-alpine
EXPOSE 8090
RUN rm -rf /usr/local/tomcat/webapps/*
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh","run"]

#FROM openjdk:8-jdk-alpine
#EXPOSE 8080
#ADD target/*.jar app.jar
#ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]

# COPY vs ADD
# COPY (recommended) - allows to copy local directories and files
# ADD - allows to copy from local and can read from URL as well

# ENTRYPOINT vs CMD
# CMD commands are replaced/overriden by the commands which can be passed as arguments
# while running docker image which can cause security issue. 
# for e.g. docker run <repo>:<tag> ping google.com -- above catalina.sh is not instead ping google.com runs
# Thus, always use ENTRYPOINT