
package com.example

class utility implements Serializable {
    def steps

    utility(steps) {
        this.steps = steps
    }

    def cloneRepo(String repoUrl, String branch = 'main') {
        def mvnHome = steps.tool name: 'maven', type: 'maven'
        steps.stage('Clone & Build') {
            steps.dir('repo') {
                steps.git url: repoUrl, branch: branch
                def output = steps.sh(script: "grep -r '.pom' .", returnStatus: true)
                if (output == 0) {
                    steps.sh "${mvnHome}/bin/mvn -B -DskipTests clean install"
                } else {
                    steps.echo "No pom file found"
                }
            }
        }
    }
}

