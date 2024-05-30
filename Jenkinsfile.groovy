pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/AnilkumarMaguluri18/Petclinic.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube_Server_Name') {
                    sh 'mvn sonar:sonar'
                }
            }
    }
}
