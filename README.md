# ETL
### GENERATOR 
  
  Application with REST endpoint. <br />
  The endpoint generate random shift data for the previous week.

### ETL
  
  ETL (Extract Transform Load) application: 
  * Fetches the data from Generator endpoint.
  * Convert all timestamps  to EST timezone.
  * Save data in postgres database.
  
# RUN APPLICATIONS
```
$ docker-compose up --build
```
# START ETL PROCESS
```
$ ./start.sh
```
