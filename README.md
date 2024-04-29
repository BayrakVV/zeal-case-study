# Zeal Case Study

This repository contains the solution for the Zeal case study, demonstrating API test automation for the Wikimedia search API. Test cases include:
- Searching for a page using a specific query.
- Retrieving the page history and verifying the timestamp of the latest edit.

## Getting Started

### Dependencies
Ensure you have the following installed:
- Latest MacOS
- Java 17, which can be installed via [SDKMAN](https://sdkman.io/)
- The latest version of [Maven](https://maven.apache.org/install.html)

Alternatively, you can run tests in a Docker container. For this, you need only [Docker Desktop](https://www.docker.com/products/docker-desktop/) installed, available for MacOS, Windows, and Linux.



### Setup
Clone this repository:
```bash
git clone https://github.com/BayrakVV/zeal-case-study.git
```
Navigate to the repository root to execute terminal commands:
```bash
cd path/to/repository
```

## How to run tests

### In the terminal
Execute the tests using Maven (this command runs all configured tests and outputs the results):


```bash
mvn test
```

### Inside Docker container
Build the Docker image (this command builds a Docker image named "wiki-test" based on the Dockerfile in your project directory):
```bash
docker build -t wiki-test .
```
Run the tests in a Docker container (this command runs the tests inside a Docker container based on the wiki-test image and removes the container after the tests finish):
```bash
docker run -it --rm wiki-test
```