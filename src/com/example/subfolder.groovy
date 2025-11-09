package com.example

void createDelete() {

node {
    def mvnHome = tool name: 'maven', type: 'maven'
    def targetFolder = 'folder1'

    stage('del & create folders') {
        dir('repo') {
            git url: 'https://github.com/pallembhavyasri/subfolders.git', branch: 'main'

            def output = sh(script: "ls -d ${targetFolder}/*/ || true", returnStdout: true).trim()
            if (output) {
                echo "subfolders found: $output"
                sh "rm -r ${targetFolder}/*/"
                echo "subfolders deleted"
            } else {
                echo "no subfolder found"
            }

            sh "mkdir  ${targetFolder}/subfolder1"
            echo "subfolder1 created"
            sh "ls -d ${targetFolder}/*/"
        }
    }
}

  }