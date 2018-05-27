package com.erik.jiraissuetransitioner

import com.erik.jiraissuetransitioner.env.EnvironmentVariables
import spock.lang.Specification

class EnvironmentVariablesSpec extends Specification {
    def "call getJiraIssueTransitionerUrl"() {
        setup: "Mock System class"
        GroovyMock(System, global: true)
        def jiraUrlMock = "https://my.jira.at/jira"

        and: "Stub system getenv call for JIRAISSUETRANSITIONER_URL"
        System.getenv() >> [JIRAISSUETRANSITIONER_URL: jiraUrlMock]

        when: "call getJiraIssueTransitionerUrl"
        def response = environmentVariables.getJiraIssueTransitionerUrl()

        then: "should match jiraUrlMock"
        response == jiraUrlMock
    }

    def "call getJiraIssueTransitionerJql"() {
        setup: "Mock System class"
        GroovyMock(System, global: true)
        def jiraJqlMock = "?jql=project%3Dtopsecret"

        and: "Stub system getenv call for JIRAISSUETRANSITIONER_JQL"
        System.getenv() >> [JIRAISSUETRANSITIONER_JQL: jiraJqlMock]

        when: "call getJiraIssueTransitionerJql"
        def response = EnvironmentVariables.getJiraIssueTransitionerJql()

        then: "should match jiraJqlMock"
        response == jiraJqlMock
    }

    def "call getJiraIssueTransitionerTransition"() {
        setup: "Mock System class"
        GroovyMock(System, global: true)
        def jiraTransitionMock = "61"

        and: "Stub system getenv call for JIRAISSUETRANSITIONER_TRANSITION"
        System.getenv() >> [JIRAISSUETRANSITIONER_TRANSITION: jiraTransitionMock]

        when: "call getJiraIssueTransitionerTransition"
        def response = EnvironmentVariables.getJiraIssueTransitionerTransition()

        then: "should match jiraTransitionMock"
        response == jiraTransitionMock
    }

    def "call getJiraIssueTransitionerDryRun"() {
        setup: "Mock System class"
        GroovyMock(System, global: true)
        def jiraDryRunMock = true

        and: "Stub system getenv call for JIRAISSUETRANSITIONER_DRYRUN"
        System.getenv() >> [JIRAISSUETRANSITIONER_DRYRUN: jiraDryRunMock]

        when: "call getJiraIssueTransitionerDryRun"
        def response = EnvironmentVariables.getJiraIssueTransitionerDryRun()

        then: "should match jiraDryRunMock"
        response == jiraDryRunMock
    }
}
