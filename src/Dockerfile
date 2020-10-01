FROM tomcat:9.0.37

LABEL maintainer="mamvai@amazon.com"

COPY HelloWorld-1.0.war /usr/local/tomcat/webapps/  

RUN ls -lrt
RUN pwd
RUN jar -tvf webapps/HelloWorld-1.0.war

EXPOSE 8080

COPY index.html /usr/local/tomcat/webapps/ROOT/

CMD ["catalina.sh", "run"]
