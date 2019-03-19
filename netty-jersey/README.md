# Jersey-Jetty-REST

A simple RESTful web service realized with Maven, Jersey and Jetty.

Resources in this context are actual files stored in your project root and organized within a HashMap.

| Endpoint      | HTTP Method   | Response  |
| ------------- |:-------------:| -----:|
| /resources    | GET           | A list of available resources |
| /resources    | POST          | HTTP Status code |
| /resources/{id} | GET         | Content of the resource with the given id |
| /resources/{id} | DELETE      | HTTP Status code |

## Usage

**Start the server**

```compile exec:java```

**Check if it works**

```curl "http://localhost:8080/resources/1"```

