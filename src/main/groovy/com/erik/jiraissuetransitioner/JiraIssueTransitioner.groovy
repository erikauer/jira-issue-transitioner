package com.erik.jiraissuetransitioner

import com.erik.jiraissuetransitioner.env.EnvironmentVariables
import com.erik.jiraissuetransitioner.jira.JiraRequestHandler
import com.erik.jiraissuetransitioner.rest.JsonRestHandler
import groovy.util.logging.Log

@Log
class JiraIssueTransitioner {
    static void main(String[] args) {
        def jql = EnvironmentVariables.getJiraIssueTransitionerJql()
        def transitionId = EnvironmentVariables.getJiraIssueTransitionerTransition();
        def jiraUrl = EnvironmentVariables.getJiraIssueTransitionerUrl();
        def dryRun = EnvironmentVariables.getJiraIssueTransitionerDryRun()
        def jiraRequestHandler = new JiraRequestHandler(new JsonRestHandler())
        def issues = jiraRequestHandler.getIssuesByJQL(new URL(jiraUrl + "/rest/api/2/search" + jql).openConnection() as HttpURLConnection)
        if(dryRun){
            log.info("DryRun activated! Run unset JIRAISSUETRANSITIONER_DRYRUN to disable dryrun again!")
        }
        issues.each { issue ->
            if (dryRun){
                log.info("Would perform transition on issue $issue.")
            } else {
                jiraRequestHandler.makeTransitionByIssueId(new URL(jiraUrl + "/rest/api/2/issue/" + issue + "/transitions").openConnection() as HttpURLConnection, transitionId)
                log.info "Transition of issue $issue successful."
            }
        }
    }
}
