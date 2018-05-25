package com.erik.jiraissuetransitioner

import com.erik.jiraissuetransitioner.jira.JiraRequestHandler
import com.erik.jiraissuetransitioner.rest.JsonRestHandler
import groovy.json.JsonSlurper
import spock.lang.Specification

class JiraRequestHandlerSpec extends Specification {
    def "search issue by jql"() {
        setup: "mock dependencies"
        def jsonRestHandlerMock = GroovyMock(JsonRestHandler, global: true)
        def connectionMock = Mock(HttpURLConnection)
        def jiraRequestHandler = new JiraRequestHandler(jsonRestHandlerMock)

        and: "stub calls"
        String testJsonString = '[{ \"issues\": [{ \"key\" : \"DEVOPS-123\" }, { \"key\" : \"DEVOPS-124\" }]}]';
        InputStream inputStream = new ByteArrayInputStream(testJsonString.getBytes());
        def jsonMock = new JsonSlurper().parse(inputStream)
        jsonRestHandlerMock.get(_) >> jsonMock

        when: "getIssuesByJQL is called"
        def response = jiraRequestHandler.getIssuesByJQL(connectionMock);

        then: "response should include all issues"
        response == ["DEVOPS-123", "DEVOPS-124"]
    }

    def "make transition by jql"() {
        setup: "mock dependencies"
        def jsonRestHandlerMock = GroovyMock(JsonRestHandler, global: true)
        def connectionMock = Mock(HttpURLConnection)
        def transitionIdMock = "61"
        def jiraRequestHandler = new JiraRequestHandler(jsonRestHandlerMock)

        and: "stub calls"
        def jsonMock = new JsonSlurper().parseText('{}')
        jsonRestHandlerMock.post(_,_) >> jsonMock

        when: "makeTransitionByIssueId is called"
        def response = jiraRequestHandler.makeTransitionByIssueId(connectionMock, transitionIdMock);

        then: "should return empty json"
        response == jsonMock
    }
}
