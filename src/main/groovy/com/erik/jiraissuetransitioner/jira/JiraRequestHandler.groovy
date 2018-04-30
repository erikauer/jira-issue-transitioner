package com.erik.jiraissuetransitioner.jira

import com.erik.jiraissuetransitioner.rest.JsonRestHandler
import groovy.json.JsonBuilder
import groovy.json.JsonOutput

class JiraRequestHandler {

    static def getIssuesByJQL(jqlQuery) {
        String jiraUrl = System.getenv()['JIRAISSUETRANSITIONER_URL']
        Object json = JsonRestHandler.get(jiraUrl + "/rest/api/2/search")
        def issues = null;
        json.issues.each {
            issues = it.key
        }
        return issues
    }

    static def makeTransitionByIssueId(issueId, transitionId) {

        String jiraUrl = System.getenv()['JIRAISSUETRANSITIONER_URL']
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
                id "${transitionId}"
            }
        }

        String postJson = JsonOutput.prettyPrint(json.toString())
        return JsonRestHandler.post(jiraUrl + "/rest/api/2/issue/" + issueId + "/transitions", postJson)
    }
}
