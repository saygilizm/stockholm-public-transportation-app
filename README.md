## Task Description ##  

The task is to implement an API for potential clients. The API will have minimum 2 endpoints. 
One end-point should return the top 10 bus lines in Stockholm area with most bus stops on their route. 
The other endpoint should return a list of every bus stop of the bus line provided. 
There is no requirement on how the bus stops are sorted.  
 
To accomplish the task please use the Trafiklab’s open API (https://www.trafiklab.se). 
You can find more information about the specific API at the documentation page: http://www.trafiklab.se/api/sl-hallplatser-och-linjer-2.  
 
You can register your own account at Trafiklab and obtain an API key. 
 
The data should be automatically gathered from API for each run of the application. 
 
 
## How to install and how to run the API ##

1. Install Java SE Development Kit 8 (or above). Use following link for detailed guidance. https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html

2. Install Maven 3.2.0 (or above). Use following link for detailed guidance. https://maven.apache.org/install.html

3. Copy this project(stockholm-public-transportation-app) into your local device.

4. In the terminal, navigate to project path.

5. Execute following command `mvn clean install` 

6. Execute following command to run the Application `java -jar target/stockholm-public-transportation-app-0.0.1-SNAPSHOT.jar`

7. Execute following command in another terminal `curl http://localhost:8080/top10BusLines/`

8. Execute following command in another terminal `curl http://localhost:8080/getAllStops/176/`

 
