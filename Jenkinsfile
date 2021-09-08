pipeline {
    agent { dockerfile true }
    stages {
        stage('build') {
            steps {
                echo "Hello World!"
                sh 'docker version'
                sh '''docker save --output booking.tar api.booking:latest'''
                sh 'ls'
                sh '''docker load -i booking.tar'''
                sh 'docker image ls'
            }
        }
    }
}
