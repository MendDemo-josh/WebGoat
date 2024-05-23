FROM docker.io/eclipse-temurin:19-jre-focal
LABEL NAME = "WebGoat: A deliberately insecure Web Application"
MAINTAINER "WebGoat team"

RUN \
  useradd -ms /bin/bash webgoat && \
  chgrp -R 0 /home/webgoat && \
  chmod -R g=u /home/webgoat

USER webgoat
RUN curl -LJO https://raw.githubusercontent.com/OWASP/wrongsecrets/master/src/test/resources/RSAprivatekey.pem  && \
    curl -LJO https://raw.githubusercontent.com/OWASP/wrongsecrets/master/src/test/resources/secondkey.txt && \
    curl -LJO https://raw.githubusercontent.com/OWASP/wrongsecrets/master/src/test/resources/thirdkey.txt && \
    curl -LJO https://raw.githubusercontent.com/OWASP/wrongsecrets/master/src/test/resources/yourkey.txt

COPY --chown=webgoat target/webgoat-*.jar /home/webgoat/webgoat.jar

EXPOSE 8080
EXPOSE 9090

# Mend traceability labels
LABEL io.mend.image.dockerfile.path=Dockerfile
LABEL org.opencontainers.image.source=https://github.com/MendDemo-josh/WebGoat

WORKDIR /home/webgoat
ENTRYPOINT [ "java", \
   "-Duser.home=/home/webgoat", \
   "-Dfile.encoding=UTF-8", \
   "--add-opens", "java.base/java.lang=ALL-UNNAMED", \
   "--add-opens", "java.base/java.util=ALL-UNNAMED", \
   "--add-opens", "java.base/java.lang.reflect=ALL-UNNAMED", \
   "--add-opens", "java.base/java.text=ALL-UNNAMED", \
   "--add-opens", "java.desktop/java.beans=ALL-UNNAMED", \
   "--add-opens", "java.desktop/java.awt.font=ALL-UNNAMED", \
   "--add-opens", "java.base/sun.nio.ch=ALL-UNNAMED", \
   "--add-opens", "java.base/java.io=ALL-UNNAMED", \
   "--add-opens", "java.base/java.util=ALL-UNNAMED", \
   "--add-opens", "java.base/sun.nio.ch=ALL-UNNAMED", \
   "--add-opens", "java.base/java.io=ALL-UNNAMED", \
   "-Drunning.in.docker=true", \
   "-Dwebgoat.host=0.0.0.0", \
   "-Dwebwolf.host=0.0.0.0", \
   "-Dwebgoat.port=8080", \
   "-Dwebwolf.port=9090", \
   "-jar", "webgoat.jar" ]
