package com.erik.jiraissuetransitioner.env

class EnvironmentVariables {
    static String getJiraIssueTransitionerUrl() {
        return System.getenv()['JIRAISSUETRANSITIONER_URL'];
    }
    static String getJiraIssueTransitionerJql() {
        return System.getenv()['JIRAISSUETRANSITIONER_JQL'];
    }
    static String getJiraIssueTransitionerTransition() {
        return System.getenv()['JIRAISSUETRANSITIONER_TRANSITION'];
    }
}
