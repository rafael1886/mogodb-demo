# mogodb-demo

Create mongo in docker:
````
docker run -d --name mongodb -p 27019:27017 mongo:4.4
````

Run test (MongodbAddress) when create 100 000 templates.

Run application and go to endpoint (or postman):
````
curl -XGET "http://localhost:8080/address" > test.txt
````