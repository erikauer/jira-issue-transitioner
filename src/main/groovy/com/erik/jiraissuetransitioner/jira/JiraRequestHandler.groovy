package com.erik.jiraissuetransitioner.jira

import com.erik.jiraissuetransitioner.rest.JsonRestHandler

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
}
