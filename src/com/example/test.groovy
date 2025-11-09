package com.example

    void test1() {
        node{
        def mvnHome = tool name: 'maven', type: 'maven'
        stage('Clone & Build') {
            dir('repo') {
                git url: 'https://github.com/hpehl/maven-multi-module-template.git', 
                branch: 'main'
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
