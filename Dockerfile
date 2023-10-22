FROM quay.io/keycloak/keycloak:18.0.2

ENV KEYCLOAK_ADMIN=a
ENV KEYCLOAK_ADMIN_PASSWORD=a

EXPOSE 8080:8080

ENTRYPOINT ["/opt/keycloak/bin/kc.sh", "start-dev"]
