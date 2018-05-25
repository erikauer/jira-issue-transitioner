package com.erik.jiraissuetransitioner.rest

import groovy.json.JsonSlurper
import javax.xml.ws.http.HTTPException

class JsonRestHandler {

    static def get(connection) {
        connection.setRequestProperty('Accept', 'application/json')
        if (connection.responseCode == 200) {
            def json = connection.inputStream.withCloseable { inStream ->
                new JsonSlurper().parse(inStream as InputStream)
            }
            return json
        } else {
            println connection.responseCode + ": " + connection.inputStream.text
            throw new HTTPException(connection.responseCode);
        }
    }

    static def post(connection, body) {
        connection.setRequestProperty('Accept', 'application/json')
        connection.setRequestProperty('Content-Type', 'application/json')

        connection.with {
            doOutput = true
            requestMethod = 'POST'
            outputStream.withWriter { writer ->
                writer << body
            }
        }
        if (connection.responseCode == 204) {
            return new JsonSlurper().parseText('{}')
        } else {
            println "Error. Status Code 204 was expected. Got " + connection.responseCode + " instead."
            throw new HTTPException(connection.responseCode);
        }
    }
}
