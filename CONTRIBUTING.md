# Contributing to JIRA Issue Transitioner
Welcome contributor. As you read this, you are close to start contribute to this project. We'd love for you
to contribute to the sources.

* [Code of Conduct](#coc)
* [Setup your Development Environment](#setup)
* [Questions and Contact](#qa)
* [Contribution Guidelines](#guide)

## <a name="coc"></a> Code of Conduct
Just be fair and respect everyone. We are all here to improve the IT world.

## <a name="setup"></a> Setup your Development Environment
The repository already provides a gradle wrapper used to build, test, and run the code. You need to provide some
environment parameters to run the code successful. Just run

     . ./scripts/initialise-development-environment.sh 
     
to set all required parameters. This also configures the environment with the mocked JIRA API, we provide
for development.


## <a name="guide"></a> Contribution Guidelines

Before you submit your pull request consider the following guidelines:

* Follow the git workflow described at this page: https://github.com/asmeurer/git-workflow
* Please ensure that your commit message looks like following: changetype(files): Commit Message 
(e.g. feature(JiraIssueTransitioner.groovy): changed method to do something amazing)

## <a name="qa"></a> Questions and Contact
If you have any questions just contact us on community@whizus.com.