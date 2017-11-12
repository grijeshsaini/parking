## Parking Software

#### All the rest endpoints are secured and need Access token to retrieve the data

##### To get the token please hit below endpoint
``
    http://localhost:9090/oauth/token
``
with client id and secret and with registered username and password (Grant-type password)

##### Curl Example:-
``
curl -X POST --user 'parking:secret' -d 'grant_type=password&username=peter@example.com&password=password' http://localhost:9090/oauth/token
``


