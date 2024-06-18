The application is fully developed in Spring Boot.

In the 'application.properties', the database connection is configured not to create a schema in the database, as it is set to update so that you can run the application multiple times.

'curls' : 

curl -X 'POST' \
  'http://localhost:8080/api/user/register' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
    "username":"pavleeeaee",
    "password":"pavle123",
    "email":"pavale1.pavle@gmail.com"
}'


curl -X 'GET' \
  'http://localhost:8080/api/user/fetch?username=bogdandwan' \
  -H 'accept: application/json'
