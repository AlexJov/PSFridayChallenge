
FROM openjdk:8-jdk-alpine

# Setting environemnt variables
ENV BUCKET_NAME <bucket_name_here>
ENV REGION_NAME <region_here>
ENV APPD_AGENT_VERSION <agent_version_here>

ENV APPSERVER_AGENT_HOME /opt/appdynamics/AppServerAgent/

RUN echo ${APPD_AGENT_VERSION}

# get the agent
ADD https://${BUCKET_NAME}.s3.${REGION_NAME}.amazonaws.com/AppServerAgent-$APPD_AGENT_VERSION.zip /tmp/

# unzip to agent home directory
RUN mkdir -p ${APPSERVER_AGENT_HOME} && \
    unzip -oq /tmp/AppServerAgent-$APPD_AGENT_VERSION.zip -d ${APPSERVER_AGENT_HOME} && \
    rm /tmp/AppServerAgent-$APPD_AGENT_VERSION.zip


# docker build -t MY_USERNAME/java-agent:latest ./appdAgent --no-cache