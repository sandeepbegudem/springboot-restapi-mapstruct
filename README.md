# national-parks-spring-boot-mapstruct-completable-future

# Entities:
####    - Traveller
####    - NationalPark

# Endpoints:
### 1. Traveller:  
####     Post:
####       - localhost:5473/api/v1/travellers/travel

####     Get:
####     - localhost:5473/api/v1/travellers/all-travellers

### POST Call using Postman:
![post_call.png](screenshots%2Fpost_call.png)

### Console Messages:
![console.png](screenshots%2Fconsole.png)

### Record Count in MySql DB:
![record_count_mysql.png](screenshots%2Frecord_count_mysql.png)

### Traveller:  GET Call using Postman
![GET_Call.png](screenshots%2FGET_Call.png)

### Console Messages:
![Console_Messages.png](screenshots%2FConsole_Messages.png)


### NationalPark:
###     Post:
####       - localhost:5473/api/v1/national-parks/insert-park

###     Get:
####     - localhost:5473/api/v1/travellers/all-travellers

###     Get (specific id):
####     - localhost:5473/api/v1/national-parks/get-park/{id}

###     Update:
####     - localhost:5473/api/v1/national-parks/update-park

###     Delete:
####     - localhost:5473/api/v1/national-parks/delete-park/{id}

### POST Call using Postman:
![national_park_post.png](screenshots%2Fnational_park_post.png)

### GET Call using Postman:
![national_park_get.png](screenshots%2Fnational_park_get.png)

### GET Call for specific id using Postman:
![national_park_get_id.png](screenshots%2Fnational_park_get_id.png)

### PUT Call using Postman:
![national_park_update.png](screenshots%2Fnational_park_update.png)

### DELETE Call using Postman:
![national_park_delete_mapping.png](screenshots%2Fnational_park_delete_mapping.png)

# Libraries:

#### 1. spring boot starter data jpa
#### 2. spring boot starter web
#### 3. spring boot devtools
#### 4. mapstruct
#### 5. mysql
#### 6. lombok

# Auto-Generate the classes into target folder using map struct and maven

###   Steps:
####        1. select  compile from the Maven life cycle
####        2. go to the target folder > generated-sources

