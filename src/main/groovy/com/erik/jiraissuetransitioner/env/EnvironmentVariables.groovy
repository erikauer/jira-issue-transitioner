package com.erik.jiraissuetransitioner.env

class EnvironmentVariables {
    static String getJiraIssueTransitionerUrl() {
        return System.getenv()['JIRAISSUETRANSITIONER_URL'];
    }
}
