Coverage: 89%

# QA_Project_HWA
This repo is for a OOP based full-stack web application with CRUD functionality, relating to building a database of Premier League football clubs and some of their details.
The fields users are capable of editing include; the club name, club value, stadium capacity and points. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them:

You will need the the Java SE Development kit which can be found here
https://www.oracle.com/java/technologies/downloads/

You will also need a version of MySQL Community including MySQL Workbench
https://dev.mysql.com/downloads/windows/installer/8.0.html

You wil need a version of gitbash for terminal access
https://git-scm.com/downloads

You will need spring boot IDE for API alterations
https://spring.io/tools

You will need VS code for any CSS, HTML or Javascript changes
https://code.visualstudio.com/download

You will need to have Apache Maven for testing
https://maven.apache.org/download.cgi

- With Maven you will need two dependencies:

JUnit = https://mvnrepository.com/artifact/junit/junit

Mockito = https://mvnrepository.com/artifact/org.mockito/mockito-core


### Installing

Here are the steps you need in order to get the program running:

STEP 01:
Clone this Repo onto your local machine

STEP 02:
In the Root Folder
 - Open CMD 
 - Type "java -jar JuneEnableSpring-0.0.1-SNAPSHOT.jar"
 - Now the application will be running in the background

STEP 03:
 - Open your Internet Browser
 - Type "localhost8080" in URL
 - You should now have access to the Front end of this web app

### Example Build

After executing the jar file:

![Install](https://user-images.githubusercontent.com/107991329/185508523-7837186a-c7c5-4589-849b-869b3970fe2a.png)

After opening localhost8080:

![Webpage_localhost](https://user-images.githubusercontent.com/107991329/185508577-52d5e06e-91ca-460d-9e49-3281fde4190b.png)


## Running the tests

To run your own tests, you would need to open the project inside an IDE, such as eclipse or spring tool suite, and run the src/test/java package as a JUNIT Test, or select individual unit tests.
The overall coverage should be seen as 89.1%:

![Coverage](https://user-images.githubusercontent.com/107991329/185509134-1689e1d9-a1ce-4eb0-a01c-c3c7a739f4c7.png)


### Unit Tests 

Unit testing is a testing approach that uses conditions to test smaller isolated portions of code that may be utilised logically.
Unit testing was used in this project on the controllers and services classes, an example of which will be displayed here:

![UnitTest](https://user-images.githubusercontent.com/107991329/185509726-2b1b72bf-0f52-40d8-bbb3-69cb60f240ab.png)


### Integration Tests 

Integration testing is the process of evaluating various coupled components of an application to check if they logically operate together and achieve the desired result. Integration testing was used for the controller class as shown below:

![IntegrationTest](https://user-images.githubusercontent.com/107991329/185510082-24484539-4685-4d02-a099-e6df1d000fe5.png)


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use GitHub for versioning.

## Authors

* **Jariful Hoque** - *Initial work* - [jarifulhoque](https://github.com/jarifulhoque)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

Trainer - Anoush Lowton
Trainer - Jordan BenBelaid
Trainer - Edward Reynolds
Trainer - Piers Barber
