How to run the service

Clone the repository:

> git clone https://github.com/tarek-ottey/elmenus.git
Get to the q5 folder:

> cd q5
Run the service:

> sbt run
The service runs on port 4000 by default.

Usage

Restaurant entity:

case class Restaurant(var uuid: String, data: Data)

Data Entity:

case class Data (enName: String, arName: String, state: String, routingMethod: String, logo: String,coverPhoto: String,
                 enDescription: String, arDescription: String, shortNumber: String, facebookLink:String,
                 twitterLink: String, youtubeLink: String, website: String, onlinePayment: Boolean, client: Boolean,
                 pendingInfo: Boolean, pendingMenu: Boolean, closed: Boolean)
				 
				 
Create a restaurant

Request:

curl -v -H "Content-Type: application/json" \
	 -X POST http://localhost:4000/api/restaurant \
	 -d '{"uuid": "", "data": {"enName": "English name value", "arName": "Arabic name value", ..., "closed": false}}'
Response if the restaurant has been created:

*   Trying ::1...
* Connected to localhost (::1) port 4000 (#0)
> POST /questions HTTP/1.1
> Host: localhost:4000
> User-Agent: curl/7.43.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 68
>
* upload completely sent off: 68 out of 68 bytes
< HTTP/1.1 201 Created
< Server: Quiz Management Service REST API
< Date: Sat, 21 Nov 2015 11:37:11 GMT
< Location: http://localhost:4000/api/restaurant/test
< Content-Length: 0
<
* Connection #0 to host localhost left intact

Response if the restaurant with the specified id already exists:

*   Trying ::1...
* Connected to localhost (::1) port 4000 (#0)
> POST /questions HTTP/1.1
> Host: localhost:4000
> User-Agent: curl/7.43.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 68
>
* upload completely sent off: 68 out of 68 bytes
< HTTP/1.1 409 Conflict
< Server: Quiz Management Service REST API
< Date: Sat, 21 Nov 2015 11:53:34 GMT
< Content-Length: 0
<


Get a restaurant

Request:

curl -v http://localhost:4000/api/restaurant/
Response if the question exists:

*   Trying ::1...
* Connected to localhost (::1) port 4000 (#0)
> GET /questions/test HTTP/1.1
> Host: localhost:4000
> User-Agent: curl/7.43.0
> Accept: */*
>
< HTTP/1.1 200 OK
< Server: Quiz Management Service REST API
< Date: Sat, 21 Nov 2015 12:23:34 GMT
< Content-Type: application/json; charset=UTF-8
< Content-Length: 64
<
* Connection #0 to host localhost left intact
[{"uuid": "", "data": {"enName": "English name value", "arName": "Arabic name value", ..., "closed": false}}]
Response if the question does not exist:

*   Trying ::1...
* Connected to localhost (::1) port 4000 (#0)
> GET /questions/non-existing-question HTTP/1.1
> Host: localhost:4000
> User-Agent: curl/7.43.0
> Accept: */*
>
< HTTP/1.1 404 Not Found
< Server: Quiz Management Service REST API
< Date: Sat, 21 Nov 2015 12:25:43 GMT
< Content-Length: 0
<
* Connection #0 to host localhost left intact

Update a question

Request:

curl -v -H "Content-Type: application/json" \
	 -X PUT http://localhost:4000/api/restaurant/{uuid} \
	 -d '{"uuid": "", "data": {"enName": "English name value", "arName": "Arabic name value", ..., "closed": false}}'
Response if the question has been updated:

*   Trying ::1...
* Connected to localhost (::1) port 4000 (#0)
> PUT /questions/uuid HTTP/1.1
> Host: localhost:4000
> User-Agent: curl/7.43.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 23
>
* upload completely sent off: 23 out of 23 bytes
< HTTP/1.1 200 OK
< Server: Quiz Management Service REST API
< Date: Sat, 21 Nov 2015 12:44:03 GMT
< Content-Type: application/json; charset=UTF-8
< Content-Length: 53
<
* Connection #0 to host localhost left intact
{"uuid": "", "data": {"enName": "English name value", "arName": "Arabic name value", ..., "closed": false}}
Response if the restaurant could not be updated:

*   Trying ::1...
* Connected to localhost (::1) port 4000 (#0)
> PUT /restaurant/non-existing-restaurant HTTP/1.1
> Host: localhost:4000
> User-Agent: curl/7.43.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 23
>
* upload completely sent off: 23 out of 23 bytes
< HTTP/1.1 404 Not Found
< Server: Quiz Management Service REST API
< Date: Sat, 21 Nov 2015 12:46:15 GMT
< Content-Length: 0
<
* Connection #0 to host localhost left intact
Delete a restaurant

Request:

curl -v -X DELETE http://localhost:4000/api/restaurant/{uuid}
Response:

*   Trying ::1...
* Connected to localhost (::1) port 4000 (#0)
> DELETE /restaurant/test HTTP/1.1
> Host: localhost:4000
> User-Agent: curl/7.43.0
> Accept: */*
>
< HTTP/1.1 200 OK
< Server: Quiz Management Service REST API
< Date: Sat, 21 Nov 2015 12:58:30 GMT
< Content-Type: application/json; charset=UTF-8
< Content-Length: 2
<
* Connection #0 to host localhost left intact