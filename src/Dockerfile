FROM tomcat:9.0.38-jdk8-corretto
#FROM tomcat:9.0.37

LABEL maintainer="mamvai@amazon.com"

COPY HelloWorld-1.0.war /usr/local/tomcat/webapps/  

RUN ls -lrt
RUN pwd

RUN jar -tvf webapps/HelloWorld-1.0.war

EXPOSE 8080

COPY index.html /usr/local/tomcat/webapps/ROOT/

RUN ls -lrt webapps
COPY catalina.properties /usr/local/tomcat/conf
RUN cat /usr/local/tomcat/conf/catalina.properties

CMD ["catalina.sh", "run"]
