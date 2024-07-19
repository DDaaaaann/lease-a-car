# Lease a car

## Contents

### Car service

The car service let's users Get, Create, Update, Delete and List cars.
These services are available via the REST API.

### Customer service

The customer service let's users Get, Create, Update, Delete and List customers.
These services are available via the REST API.

### Lease service

The lease service let's users create a lease for a Customer and a Car.
With these inputs it calulates a lease rate and stores the lease.
A user can also list all leases.
These services are available via the REST API.

### Gateway service

The gateway service serves as an entrypoint for all api request. Making all above API's available.

## Installation

Run `mvn clean install`
_This will compile all modules and generated source code_

Now start our seperate services:\
Run `Gateway-service` \
Run `Car-service` \
Run `Customer-service` \
Run `Lease-service`

### Run with docker

- `Package, Build, Compose`\
  _This will package all modules, build the image and compose up_


- `Build, Compose`\
  _If no changes to the code where made, but rebuilding the images is necessary_


- `Compose`\
  _If only (re)staring existing containers_

## Usage

Use the api as described in [lease-api.yml](ws/src/main/resources/lease-api.yml)
All api's are available via the gateway on http://localhost:8080

### Example create car

```
curl --location 'http://localhost:8080/cars' \
     --header 'Content-Type: application/json' \
     --header 'Accept: application/json' \
     --data '{
        "make": "Toyota",
        "model": "Yaris",
        "version": "hybrid",
        "numberOfDoors": "5",
        "co2Emission": "124",
        "grossPrice": "28877",
        "nettPrice": "26050"
     }'
```

## Future developments
- [x] Generate Rest clients
- [x] Gateway service
- [ ] Fix vulnerabilities
- [ ] Validation
- [ ] Api tests
- [ ] Auth service
- [ ] DDD
- [ ] Load balancing
- [ ] Circuit breakers
- [ ] Containerization
