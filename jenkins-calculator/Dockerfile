FROM jenkins

# Adding default Jenkins Jobs
COPY jobs/RSApplicationBuild.xml /usr/share/jenkins/ref/jobs/RSApplicationBuild/config.xml
COPY jobs/startApplication.xml /usr/share/jenkins/ref/jobs/startApplication/config.xml

COPY config/plugins.txt /usr/share/jenkins/plugins.txt
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt

USER root
RUN apt-get update 
RUN apt-get install -y maven
RUN apt-get clean
USER jenkins

