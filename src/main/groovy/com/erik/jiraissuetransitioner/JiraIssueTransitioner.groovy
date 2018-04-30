package com.erik.jiraissuetransitioner

import com.erik.jiraissuetransitioner.jira.JiraRequestHandler

class JiraIssueTransitioner {
    void run(String jql, String transitionId) {
        def issues = JiraRequestHandler.getIssuesByJQL(jql)
        issues.each { issue ->
            JiraRequestHandler.makeTransitionByIssueId(issue, transitionId)
        }
    }
}
