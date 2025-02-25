# Use a Maven image to build the WAR file
FROM maven:3.8.6-openjdk-11 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and source code
COPY pom.xml .
COPY src ./src

# Package the application to generate the WAR file
RUN mvn clean package

# Use a Tomcat image to deploy the WAR file
FROM tomcat:9.0.65-jdk11-openjdk

# Copy the generated WAR file to the Tomcat webapps directory
COPY --from=build /app/target/ILP_Fancystore.war /usr/local/tomcat/webapps/

#RUN sed -i 's/port="8080"/port="8247"/' ${CATALINA_HOME}/conf/server.xml

RUN sed -i 's/8080/8247/g' /usr/local/tomcat/conf/server.xml

#ADD ./tomcat-cas/war/ ${CATALINA_HOME}/webapps/

# Expose the default Tomcat port

EXPOSE 8247

 

# Start Tomcat

CMD ["catalina.sh", "run"]
