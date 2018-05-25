package com.erik.jiraissuetransitioner.jira

import com.erik.jiraissuetransitioner.rest.JsonRestHandler
import groovy.json.JsonBuilder
import groovy.json.JsonOutput

class JiraRequestHandler {

    JsonRestHandler jsonRestHandler;

    JiraRequestHandler(JsonRestHandler jsonRestHandler) {
        this.jsonRestHandler = jsonRestHandler
    }

    def getIssuesByJQL(connection) {
        Object json = jsonRestHandler.get(connection)
        def issues = null;
        json.issues.each {
            issues = it.key
        }
        return issues
    }

    def makeTransitionByIssueId(connection, transitionId) {

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
        return jsonRestHandler.post(connection, postJson)
    }
}
