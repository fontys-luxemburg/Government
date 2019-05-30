FROM redxice/government:basic
USER payara
COPY target/government.war $DEPLOY_DIR
ARG tracking_url=redxice/payara:jenkins://tracking:8080
ENV tracking_url=$tracking_url
EXPOSE 8080 4848
