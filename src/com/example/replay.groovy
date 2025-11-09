package com.example

void reposClone() {

node {
    def mvnHome = tool name: 'maven', type: 'maven'

    stage('Clone Repositories') {
        checkout([
            $class: 'GitSCM',
            branches: [[name: 'main']],
            userRemoteConfigs: [[
                url: 'https://github.com/hpehl/maven-multi-module-template.git'
            ]],
            extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: 'repo1']],
            changelog: false,
            poll: false
        ])

        checkout([
            $class: 'GitSCM',
            branches: [[name: 'main']],
            userRemoteConfigs: [[
                url: 'https://github.com/pallembhavyasri/mavenhw.git'
            ]],
            extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: 'repo2']],
            changelog: false,
            poll: false
        ])

        checkout([
            $class: 'GitSCM',
            branches: [[name: 'master']],
            userRemoteConfigs: [[
                url: 'https://github.com/sharmar0790/spring-boot-multi-module-maven'
            ]],
            extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: 'repo3']],
            changelog: false,
            poll: false
        ])
    }

    stage('Build Repositories') {
       sh "cd repo1 && ${mvnHome}/bin/mvn -B -DskipTests clean install"
        sh "cd repo2 && ${mvnHome}/bin/mvn -B -DskipTests clean install"
        sh "cd repo3 && ${mvnHome}/bin/mvn -B -DskipTests clean install"

    }
}
  }