FROM redxice/government:basic
USER payara
#RUN npm run build
COPY target/government.war $DEPLOY_DIR
ARG tracking_url_env=http://178.62.217.247:9050/tracking
ENV tracking_url=$tracking_url_env
EXPOSE 8080 4848
