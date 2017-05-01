# Echo example

This project is the example referenced in the post entitled:

[HTTP done three ways with Spring Cloud Kubernetes on OpenShift](https://blog.switchbit.io/http-done-three-ways-with-spring-cloud-kubernetes-on-openshift)

## Overview

The example consists of two applications:

* [echo](echo) - A Spring Boot application that accepts `POST /echo` requests and 
call the downstream service below
* [chamber](chamber) - which simple echoes the received request back to the upstream caller

## Branches

There are three branches, each handling one of the above three ways 
of handling HTTP based communication.

* [`master`](https://github.com/donovanmuller/echo-example) - the basic vanilla `RestTemplate` implementation
* [`hystrix`](https://github.com/donovanmuller/echo-example/tree/hystrix) - `RestTemplate` with Hystrix added for circuit breaker and fallback functionality
* [`feign`](https://github.com/donovanmuller/echo-example/tree/feign) - same functionality as above but using a declarative Feign interface

## Usage

Assuming a running instance of OpenShift started with `minishift`, run

```console
$ mvn fabric8:deploy
```

to deploy both applications to OpenShift.
