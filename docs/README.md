# Technical details

Our application is built over the Jakarta EE standard (Java EE). We are using the following tools/technology to build this project :

| Component                     | Name                                                      | Version      |
| ----------------------------- | --------------------------------------------------------- | ------------ |
| Jakarta EE Application Server | [Open Liberty](openliberty.io/)                           | __>=3.2__    |
| IDE                           | [IntelliJ Idea Ultimate](https://www.jetbrains.com/idea/) | __>=2020.2__ |
| Build/dependency Manager      | [Maven](https://maven.apache.org/)                        | __>= 3.6__   |
| E2E testing tools             | [CodeceptJS](codecept.io/) (with **Puppeteer**)           | __>=2.6__    |
| Unit Testing Framework        | [Junit](https://junit.org/junit5/)                        | __>= 5.6__   |
| Integration Testing tool      | [Arquilian](http://arquillian.org/)                       | __>= 1.1__   |
| Containerization tools        | [Docker](https://www.docker.com/)                         | __>= 19.03__ |

## Run this code (for developpement)

```bash
# clone this repository
$ git clone git@github.com:Sinyks/AMT2020-StackOverflowSimpleVersion.git

# start developpement database 
$ docker-compose -f docker/topologies/stackoverflow/docker-compose.yml up -d db

$ cd AMT2020-StackOverflowSimpleVersion

$ mvn liberty:run
```

## Run this code (for production)

```bash
# clone this repository
$ git clone git@github.com:Sinyks/AMT2020-StackOverflowSimpleVersion.git

$ docker-compose -f docker/topologies/stackoverflow_prod/docker-compose.yml up
```

You can then visit the http://localhost:9081 page on your browser.

## Docker Image

A workflow launches the tests and commands to validate your push or your merge request. If it pasess the test and build steps then a docker image of openliberty will be created on ['our registry'](https://github.com/orgs/Gusamaal/packages).

__IMPORTANT: this image is unexploitable without a correct database__ 

You can pull it with this command : 


```bash
$ docker pull ghcr.io/gusamaal/amt2020-stackoverflowsimplegamified/stackoverflowsimpleversiongamified:latest
```

Or directly run this container with the following command :

```bash
$ docker run -it -p 9080:9080 ghcr.io/gusamaal/amt2020-stackoverflowsimplegamified/stackoverflowsimpleversiongamified:latest
```

## Resources

All other resources (Mockup, diagram, ...) can be found on Google Drive :

https://drive.google.com/drive/folders/1nZA1BNT6IPRA33JpV597dQgbJ2IBXqPw?usp=sharing

## Integration with the Gamification Engine API

Three things need to be done in order to link both of our previous projects :

- Create a script-enabled launch of the API, the databases and finally the StackOverflow application that links the API and the app.
- The StackOverflow application sends HTTP POST requests to the API informing the API of user events that impact the gamification engine. 
- The StackOverflow application sends HTTP GET requests to the API when it wants to display gamification information concerning one or all of the app's user(s).

## Quick Deploy the whole project

In preamble we need to setup an external docker network to allow our topologie to communicate easly

```bash
$ docker network create reunion
```

### Launch the gamification engine 

```bash

$ docker-compose -f docker/topologies/gamification-engine/docker-compose.yml up -d

```

### setup and run the python api config script

NB: we assume that you have already a python3 installation

```bash
$ cp .envexample src/main/resources/.env
$ cp .envexample ./docker/topologies/stackoverflow_prod/.env.gamification

$ cd python

# create virtual environement
$ python3 -m venv venv

# start venv
$ source /venv/bin/activate

# install requirement
$ pip install -r requirements.txt

# start the script
$ python setup_api_env.py

# leave the venv
$ deactivate

```

The script will send you an API-KEY copy it in your clipboard and paste it in the dot env configuration

```conf
API_HOST=localhost
API_PORT=8086

API_KEY=<Place your API key HERE>
```

### launch stackoverflow

```
$ docker-compose -f ./docker/topologies/stackoverflow_prod/docker-compose.yml up --build
```
