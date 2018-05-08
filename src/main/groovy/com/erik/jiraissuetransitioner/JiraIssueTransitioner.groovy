package com.erik.jiraissuetransitioner

import com.erik.jiraissuetransitioner.jira.JiraRequestHandler

class JiraIssueTransitioner {
    static void main(String[] args) {
        def jql = "?jql=project%3Ddevops%20and%20status%3Dabnahmebereit%20and%20updated<%3D-14d"
        def transitionId = "61"
        def issues = JiraRequestHandler.getIssuesByJQL(jql)
        issues.each { issue ->
            JiraRequestHandler.makeTransitionByIssueId(issue, transitionId)
        }
    }
}
