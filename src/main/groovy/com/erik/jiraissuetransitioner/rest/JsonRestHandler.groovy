package com.erik.jiraissuetransitioner.rest

import groovy.json.JsonSlurper

class JsonRestHandler {

    static def get(url) {
        def connection = new URL(url).openConnection() as HttpURLConnection
        connection.setRequestProperty('Accept', 'application/json')
        if (connection.responseCode == 200) {
            def json = connection.inputStream.withCloseable { inStream ->
                new JsonSlurper().parse(inStream as InputStream)
            }
            return json
        } else {
            println connection.responseCode + ": " + connection.inputStream.text
        }
    }

    static def post(url, body) {
        println body
        def connection = new URL(url).openConnection() as HttpURLConnection
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
            println connection.responseCode + ": " + connection.inputStream.text
        }
    }
}
