FROM redxice/government:basic
USER payara
COPY target/government.war $DEPLOY_DIR
RUN npm run build
ENV tracking_url=redxice/payara:jenkins://tracking:8080
EXPOSE 8080 4848
