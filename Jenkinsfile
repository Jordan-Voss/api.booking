pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo "Hello World!"
                sh 'docker image ls'
//                 sh '''docker system prune -a -f --volumes'''
//                 sh '''docker image build -t api.booking .'''
//                 sh 'docker image ls'
//                 sh '''docker container run -p 1111:1111 api.booking'''
            }
        }
    }
}
