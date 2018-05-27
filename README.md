[![License](https://img.shields.io/apm/l/vim-mode.svg)](https://github.com/erikauer/jira-issue-transitioner/blob/master/LICENSE.md)
[![Build Status](https://travis-ci.org/erikauer/jira-issue-transitioner.svg?branch=master)](https://travis-ci.org/erikauer/jira-issue-transitioner)
[![Coverage Status](https://coveralls.io/repos/github/erikauer/jira-issue-transitioner/badge.svg?branch=master)](https://coveralls.io/github/erikauer/jira-issue-transitioner?branch=master)

# JIRA Issue Transitioner 

A JIRA issue transitioner written in groovy that closes all issues found by a specified JQL.

## Getting Started

Steps

* clone the repository
* build the project with ./gradlew build
* Setup the environment (Shown in detail below in deployment section)
* Run the project with ./gradle run

## Running the tests

Run

    ./gradlew test
    
from the root directory.

## Deployment

To deploy the JIRA Issue Transitioner successful you need to set the JIRA URL through the environment variable

     JIRAISSUETRANSITIONER_URL
     
 You also need to set values for the jql (JIRAISSUETRANSITIONER_JQL) and the transitionId 
 (JIRAISSUETRANSITIONER_TRANSITION) for a successful run of this program. An configuration example:
 
     export JIRAISSUETRANSITIONER_URL=http://private-58204-jiraissuetransitionertestmock.apiary-mock.com
     export JIRAISSUETRANSITIONER_JQL="?jql=project%3Ddevops%20and%20status%3Dabnahmebereit%20and%20updated<%3D-14d"
     export JIRAISSUETRANSITIONER_TRANSITION=22
     
You can set JIRAISSUETRANSITIONER_DRYRUN to true, if you want to test a transition. This configuration is
convenient if you want to initial configure the issuetransitioner in your environment.

## Built With

We use gradle to build the project. As in this project the gradle wrapper is used you just need to download
the repository and run 

     ./gradlew build

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md)

## Authors

* **erikauer**

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
