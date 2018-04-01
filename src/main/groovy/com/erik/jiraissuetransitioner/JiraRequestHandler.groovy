package com.erik.jiraissuetransitioner

import groovy.json.JsonSlurper

class JiraRequestHandler {

    static def getIssuesByJQL(jqlQuery) {

        def configScript = '''
        environments {
            development {
                jira.URL = 'http://private-58204-jiraissuetransitionertestmock.apiary-mock.com/'
            }
            production {
                jira.URL = 'https://prod-url/'
            }
        }
        '''

        def urlConfig = new ConfigSlurper('development').parse(configScript)
        def connection = new URL(urlConfig.jira.URL + "/rest/api/2/search")
                .openConnection() as HttpURLConnection

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
}
