FROM redxice/government:basic
USER payara
#RUN npm run build
COPY target/government.war $DEPLOY_DIR
ARG tracking_url_env=http://178.62.217.247:9050/tracking
ENV tracking_url=$tracking_url_env
ARG SMTP_PASSWORD_ENV=NOT_THE_REAL_PASSWORD
ENV SMTP_PASSWORD=$SMTP_PASSWORD_ENV
EXPOSE 8080 4848
