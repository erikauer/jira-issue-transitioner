# Contributing to the JIRA Issue Transitioner
Welcome! 
We'd love to have you as a contributor in this project, but please stick to the following few rules:

* [Code of Conduct](#coc)
* [Setup your Development Environment](#setup)
* [Contribution Guidelines](#guide)
* [Questions and Contact](#qa)

## <a name="coc"></a> Code of Conduct
Just be fair and respect everyone. We are all here to improve the IT world.

## <a name="setup"></a> Setup your Development Environment
The repository already provides a gradle wrapper used to build, test, and run the code. You need to provide some
environment parameters to run the code successful. Just run

     . ./scripts/initialise-development-environment.sh 
     
to set all required parameters. This also configures the environment with the mocked JIRA API we provide
for development.


## <a name="guide"></a> Contribution Guidelines

Before you submit your pull request consider the following guidelines:

* Follow the git workflow described at this page: https://github.com/asmeurer/git-workflow
* Please ensure that your commit message looks like following: changetype(files): Commit Message 
(e.g. feature(JiraIssueTransitioner.groovy): changed method to do something amazing)

## <a name="qa"></a> Questions and Contact
If you have any questions just contact us on community@whizus.com.