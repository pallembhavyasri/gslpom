package com.example

void mergeConflict() {

node {
    stage('merge') {
        def response

        withCredentials([usernamePassword(credentialsId: 'webhooktest', usernameVariable: 'GIT_USER', passwordVariable: 'GIT_TOKEN')]) {
            def requestBody = """
                {
                    "base": "main",
                    "head": "child1",
                    "commit_message": "Merge child1 into main"
                }
            """

            response = httpRequest(
                url: "https://api.github.com/repos/pallembhavyasri/webhooktest/merges",
                httpMode: 'POST',
                validResponseCodes: '200:499',
                customHeaders: [
                    [name: 'Authorization', value: 'Bearer ' + GIT_TOKEN]
                ],
                requestBody: requestBody,
                returnContent: true
            )
            echo "after merge suucess the full API response: ${response.content}"
        }

        def code = response.status
        if (code == 409) { 
            echo "Merge conflict detected hence comparing between 2 commits"

            def apiurl = "https://api.github.com/repos/pallembhavyasri/webhooktest/compare/main...child1"
            def compareResponse = httpRequest(
                url: apiurl,
                validResponseCodes: '200'
            )

            echo "API response body is ${compareResponse.content}"

            def obj = readJSON(text: compareResponse.content)
            echo "files size is ${obj.files.size()}"

            if (obj.files.size() != 0) {
                obj.files.each { file ->
                    echo "File name is: ${file.filename}"
                }
            }
        }
        else{
            echo "there are no conflicts"
        }
    }
}

}