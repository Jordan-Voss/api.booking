pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
            sh 'docker image ls'
            sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}