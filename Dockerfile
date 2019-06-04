FROM redxice/government:basic
USER payara
#RUN npm run build
COPY target/government.war $DEPLOY_DIR
ENV tracking_url=redxice/payara:jenkins://tracking:8080
EXPOSE 8080 4848
