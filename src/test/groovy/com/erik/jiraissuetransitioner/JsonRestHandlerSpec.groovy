package com.erik.jiraissuetransitioner

import com.erik.jiraissuetransitioner.rest.JsonRestHandler
import groovy.json.JsonSlurper
import spock.lang.Specification

import javax.xml.ws.http.HTTPException
import java.nio.charset.Charset

class JsonRestHandlerSpec extends Specification {
    def "get request"() {
        setup: "create mocked connection"
        def urlConnection = Mock(HttpURLConnection)

        and: "create expected response mock"
        def jsonSlurper = new JsonSlurper()
        def jsonMock = jsonSlurper.parseText('{ \"test\": \"test\" }')

        and: "mock input stream"
        String testJsonString = '{ \"test\": \"test\" }';
        InputStream inputStream = new ByteArrayInputStream(testJsonString.getBytes());

        and: "stub response code 200"
        urlConnection.responseCode >> 200

        and: "stub input stream return value"
        urlConnection.inputStream >> inputStream

        when: "call get request"
        def response = JsonRestHandler.get(urlConnection);

        then: "header application/json is set"
        1 * urlConnection.setRequestProperty('Accept', 'application/json')

        and: "json response is correct"
        response == jsonMock
    }

    def "get connection throw error for http status unequal 200"() {
        setup: "create mocked connection"
        def urlConnection = Mock(HttpURLConnection)

        and: "and should return mocked input stream"
        InputStream inputStream = new ByteArrayInputStream(Charset.forName("UTF-16").encode("").array());
        urlConnection.inputStream >> inputStream

        and: "return response code 404"
        urlConnection.responseCode >> 404

        when: "call get request"
        JsonRestHandler.get(urlConnection);

        then: "error is thrown"
        HTTPException exception = thrown();
        exception.getStatusCode() == 404
    }
}
