[![License](https://img.shields.io/apm/l/vim-mode.svg)](https://github.com/erikauer/jira-issue-transitioner/blob/master/LICENSE.md)
[![Build Status](https://travis-ci.org/erikauer/jira-issue-transitioner.svg?branch=master)](https://travis-ci.org/erikauer/jira-issue-transitioner)
[![Coverage Status](https://coveralls.io/repos/github/erikauer/jira-issue-transitioner/badge.svg?branch=master)](https://coveralls.io/github/erikauer/jira-issue-transitioner?branch=master)

# JIRA Issue Transitioner 

A JIRA issue transitioner written in groovy that closes all issues found by a specified JQL.

## Getting Started

Steps

* clone the repository
* build the project with ./gradlew build
* Configure JIRAISSUETRANSITIONER_URL
* Run the project with ./gradle run

## Running the tests

Run

    ./gradlew test
    
from the root directory.

## Deployment

To deploy the JIRA Issue Transitioner successful you need to set the JIRA URL through the environment variable

     JIRAISSUETRANSITIONER_URL

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
