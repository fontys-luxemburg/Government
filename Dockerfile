FROM redxice/government:basic
USER payara
#RUN npm run build
COPY target/government.war $DEPLOY_DIR
ENV tracking_url=http://178.62.217.247:9050/tracking
EXPOSE 8080 4848
