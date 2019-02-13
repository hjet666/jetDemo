1. Start application:
      mvn spring-boot:run
2. Use Postman to test apis:

      Create a transformer
      POST:
      http://localhost:8080/api/transformer


      GET:
      Get a transformer by id
      http://localhost:8080/api/transformer/1

      Update a transformer
      PUT:
      http://localhost:8080/api/transformer/1

      Delete a transformer
      DELETE:
      http://localhost:8080/api/transformer/1

      List All Transformers:
      GET:
      http://localhost:8080/api/transformer/all

      Get Winner Info:
      GET:
      http://localhost:8080/api/transformer/winner/1,2,3

3. Unit tests
     mvn clean package

4. Swgager
     http://localhost:8080/swagger-ui.html


