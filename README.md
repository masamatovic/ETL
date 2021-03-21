# ETL
## GENERATOR 
  
  Application that generates random shifts data for the previous week, it is accessed with REST endpoint. 
## ETL
  
  ETL (Extract Transform Load) application: 
  * Fetches the data from Generator endpoint.
  * Converts all timestamps to EST timezone.
  * Saves the data to postgres database.
<br />  
RUN APPLICATIONS
```
$ docker-compose up --build
```
START ETL PROCESS
```
$ ./start.sh
```
