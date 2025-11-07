package com.example

    void test1(String repoUrl, String branch = 'main') {
        def mvnHome = tool name: 'maven', type: 'maven'
        stage('Clone & Build') {
            dir('repo') {
                git url: repoUrl, branch: branch
                def output = sh(script: "grep -r '.pom' .", returnStatus: true)
                if (output == 0) {
                    sh "${mvnHome}/bin/mvn -B -DskipTests clean install"
                } else {
                    echo "No pom file found"
                }
            }
        }
    }