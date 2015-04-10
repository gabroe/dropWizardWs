# Introduction

This Dropwizard example application was developed to provide an example of the use of DropWizard (Jetty+Jersey+Jackson+Swagger) web services

# Overview

The project contains a small set of resources that can be used as an example of how to create new web services with this infrastructure. Some of the tools used for this application are:

-Dropwizard (http://gunshowcomic.com/comics/20100528.gif) (http://www.dropwizard.io) Dropwizard pulls together stable, mature libraries from the Java ecosystem into a simple, light-weight package that lets you focus on getting things done.

-Jersey (https://jersey.java.net/) framework that implements the JAX-RS reference, it provides its own API (https://jersey.java.net/apidocs/latest/jersey/index.html) that allows easy implementation of RESTful services, included with DropWizard.

-Jetty, part of DropWizard it provides a web server and javax.servlet container that is packed with the application so no need of running apache or any other web container for this example.

-Jackson, In terms of data formats, JSON has become the web’s lingua franca, and Jackson is the king of JSON on the JVM. In addition to being lightning fast, it has a sophisticated object mapper, allowing you to export your domain models directly.

-Swagger (http://swagger.io/), Swagger is a simple yet powerful representation of the RESTful API. With the largest ecosystem of API tooling on the planet, thousands of developers are supporting Swagger in almost every modern programming language and deployment environment. With a Swagger-enabled API, you get interactive documentation, client SDK generation and discoverability.

# Running The Application

The application is built using Maven (http://maven.apache.org/) so it has to be installed and configured, some of the jar files might not be in the cvent nexus repository, if so update your ~/.m2/settings.xml configuration and remove the cvent mirror, To test the example application run the following commands.

* To package the example run.

	mvn package

* To run the server run.

	java -jar target/dropwizard-example-0.0.1.jar server config.yml

* To hit the Hello World example (hit refresh a few times).

	http://localhost:8080/hello-world
	
* To see the web services docs (Created using Swagger)

	http://localhost:8080/docs/

* To create an eclipse proyect using this as the source, run:

	mvn eclipse:eclipse
	
* Other maven useful commands are:
 
	mvn clean
	mvn compile
	mvn eclipse:clean
	
	

# Add new web service

Edit the YAML file (http://symfony.com/doc/current/components/yaml/yaml_format.html) /config.yml and add a new resource FQCN, remember that it is very important to use the JERSEY annotations and the Swagger ones to be able to use the service and to browse it on the swagger documentation (see TestResource.java as an example) 

