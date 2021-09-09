pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo "Hello World!"
                sh 'docker version'
                sh '''docker system prune -a -f --volumes'''
                sh '''docker save --output booking.tar api.booking:latest'''
                sh 'ls'
                sh 'docker load -i booking.tar'
                sh 'docker image ls'
                sh '''docker run -p 8081:8081 api.booking:latest'''
            }
        }
    }
}
