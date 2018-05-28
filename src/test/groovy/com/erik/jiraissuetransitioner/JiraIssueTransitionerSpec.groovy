package com.erik.jiraissuetransitioner

import spock.lang.Specification

class JiraIssueTransitionerSpec extends Specification {
    def "integration test main function with mock jira api on apiary"() {
        setup: "basic environment setup"
        GroovyMock(System, global: true)
        def jiraUrlMock = "http://private-58204-jiraissuetransitionertestmock.apiary-mock.com"
        def jiraJqlMock = "?jql=project%3Ddevops%20and%20status%3Dabnahmebereit%20and%20updated<%3D-14d"
        def jiraTransitionMock = "61"
        def jiraDryRunMock = false

        and: "Stub system getenv calls"
        System.getenv() >> [JIRAISSUETRANSITIONER_URL: jiraUrlMock,
                            JIRAISSUETRANSITIONER_JQL: jiraJqlMock,
                            JIRAISSUETRANSITIONER_TRANSITION: jiraTransitionMock,
                            JIRAISSUETRANSITIONER_DRYRUN: jiraDryRunMock]
        when: "call main function"
        JiraIssueTransitioner.main()

        then: "calls"
        true
    }

    def "dry run integration test main function with mock jira api on apiary"() {
        setup: "basic environment setup"
        GroovyMock(System, global: true)
        def jiraUrlMock = "http://private-58204-jiraissuetransitionertestmock.apiary-mock.com"
        def jiraJqlMock = "?jql=project%3Ddevops%20and%20status%3Dabnahmebereit%20and%20updated<%3D-14d"
        def jiraTransitionMock = "61"
        def jiraDryRunMock = true

        and: "Stub system getenv calls"
        System.getenv() >> [JIRAISSUETRANSITIONER_URL: jiraUrlMock,
                            JIRAISSUETRANSITIONER_JQL: jiraJqlMock,
                            JIRAISSUETRANSITIONER_TRANSITION: jiraTransitionMock,
                            JIRAISSUETRANSITIONER_DRYRUN: jiraDryRunMock]
        when: "call main function"
        JiraIssueTransitioner.main()

        then: "calls"
        true
    }
}
