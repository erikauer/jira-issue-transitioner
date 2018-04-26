package com.erik.jiraissuetransitioner.jira

import com.erik.jiraissuetransitioner.rest.JsonRestHandler
import groovy.json.JsonBuilder
import groovy.json.JsonOutput

class JiraRequestHandler {

    static def getIssuesByJQL(jqlQuery) {

        def configScript = '''
        environments {
            development {
                jira.URL = 'http://private-58204-jiraissuetransitionertestmock.apiary-mock.com/'
            }
            production {
                jira.URL = 'https://prod-url/'
            }
        }
        '''

        def urlConfig = new ConfigSlurper('development').parse(configScript)
        return JsonRestHandler.get(urlConfig.jira.URL + "/rest/api/2/search")
    }

    static def makeTransitionByIssueId(issueId) {

        def configScript = '''
        environments {
            development {
                jira.URL = 'http://private-58204-jiraissuetransitionertestmock.apiary-mock.com/'
            }
            production {
                jira.URL = 'https://prod-url/'
            }
        }
        '''

        JsonBuilder comments = new JsonBuilder()
        JsonBuilder json = new JsonBuilder()

        comments {
            add {
                body 'Issue was automatically moved by the issue transitioner.'
            }
        }
        json {
            update {
                comment ([comments.content])
            }
            transition {
                id '61'
            }
        }

        String postJson = JsonOutput.prettyPrint(json.toString())

        def urlConfig = new ConfigSlurper('development').parse(configScript)
        return JsonRestHandler.post(urlConfig.jira.URL + "rest/api/2/issue/" + issueId + "/transitions", postJson)
    }
}
