# StatTracker

./mvnw flyway:migrate -Dflyway.url=jdbc:postgresql://localhost:5432/stattrackerdb -Dflyway.user=postgres -Dflyway.password=1abcdefg
./mvnw spring-boot:run

# Generating a token
https://oidcdebugger.com/
url: https://dev-921890.okta.com/oauth2/default/v1/authorize
redirectURI: https://oidcdebugger.com/debug
scope: openid

curl -v -H "Authorization: Bearer ${TOKEN}" http://localhost:8080/teachers