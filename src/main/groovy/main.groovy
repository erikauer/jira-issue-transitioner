import com.erik.jiraissuetransitioner.JiraIssueTransitioner

app = new JiraIssueTransitioner();
app.run("?jql=project%3Ddevops%20and%20status%3Dabnahmebereit%20and%20updated<%3D-14d","61")