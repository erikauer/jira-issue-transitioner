package com.erik.jiraissuetransitioner

import com.erik.jiraissuetransitioner.jira.JiraRequestHandler

class JiraIssueTransitioner {
    void hello() {
        def configScript = '''
        environments {
            development {
                jira.issue.jql = ''
            }
            production {
                jira.issue.jql = 'jql-prod'
            }
        }
        '''

        def jqlConfig = new ConfigSlurper('development').parse(configScript)
        println JiraRequestHandler.getIssuesByJQL(jqlConfig.jira.issue.jql)
    }
}
