package com.erik.jiraissuetransitioner

import com.erik.jiraissuetransitioner.env.EnvironmentVariables
import com.erik.jiraissuetransitioner.jira.JiraRequestHandler
import com.erik.jiraissuetransitioner.rest.JsonRestHandler

class JiraIssueTransitioner {
    static void main(String[] args) {
        def jql = EnvironmentVariables.getJiraIssueTransitionerJql()
        def transitionId = EnvironmentVariables.getJiraIssueTransitionerTransition();
        def jiraRequestHandler = new JiraRequestHandler(new JsonRestHandler())
        def jiraUrl = EnvironmentVariables.getJiraIssueTransitionerUrl();
        println jql
        println transitionId
        println jiraUrl
        def issues = jiraRequestHandler.getIssuesByJQL(new URL(jiraUrl + "/rest/api/2/search" + jql).openConnection() as HttpURLConnection)
        issues.each { issue ->
            jiraRequestHandler.makeTransitionByIssueId(new URL(jiraUrl + "/rest/api/2/issue/" + issue + "/transitions").openConnection() as HttpURLConnection, transitionId)
        }
    }
}
