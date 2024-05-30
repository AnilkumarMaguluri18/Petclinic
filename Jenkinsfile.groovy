pipeline {
    agent any

    stages {
        stage('Debug') {
            steps {
                echo 'Starting Pipeline Debug'
                echo "Git URL: ${params.GIT_URL}"
                echo "Branch: ${params.BRANCH}"
            }
        }

        stage('Checkout') {
            steps {
                echo 'Checking out code from Git'
                git branch: params.BRANCH, url: params.GIT_URL
            }
        }

        // Other stages of your pipeline
    }

    parameters {
        string(name: 'GIT_URL', defaultValue: 'https://github.com/AnilkumarMaguluri18/Petclinic.git', description: 'Git repository URL')
        string(name: 'BRANCH', defaultValue: 'main', description: 'Git branch')
    }
}
