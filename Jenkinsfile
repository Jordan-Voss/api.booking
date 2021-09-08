pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo "Hello World!"
                sh 'docker version'
                sh 'docker volume rm $(docker volume ls -qf dangling=true)'
                sh '''docker save --output booking.tar api.booking:latest'''
                sh 'ls'
                sh '''docker load -i booking.tar'''
                sh 'docker image ls'
            }
        }
    }
}
