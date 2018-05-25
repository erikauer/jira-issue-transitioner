package com.erik.jiraissuetransitioner

import com.erik.jiraissuetransitioner.env.EnvironmentVariables
import com.erik.jiraissuetransitioner.jira.JiraRequestHandler
import com.erik.jiraissuetransitioner.rest.JsonRestHandler

class JiraIssueTransitioner {
    static void main(String[] args) {
        def jql = "?jql=project%3Ddevops%20and%20status%3Dabnahmebereit%20and%20updated<%3D-14d"
        def transitionId = "61"
        def jiraRequestHandler = new JiraRequestHandler(new JsonRestHandler())
        def jiraUrl = new EnvironmentVariables().getJiraIssueTransitionerUrl();
        def issues = jiraRequestHandler.getIssuesByJQL(new URL(jiraUrl + "/rest/api/2/search" + jql).openConnection() as HttpURLConnection)
        issues.each { issue ->
            jiraRequestHandler.makeTransitionByIssueId(new URL(jiraUrl + "/rest/api/2/issue/" + issue + "/transitions").openConnection() as HttpURLConnection, transitionId)
        }
    }
}
