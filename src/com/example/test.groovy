package com.example

    void test1(String repoUrl, String branch = 'main') {
        echo "11"
        node{
        echo "22"
        def mvnHome = tool name: 'maven', type: 'maven'
        stage('Clone & Build') {
            echo "33"
            dir('repo') {
                echo "44"
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
    }
