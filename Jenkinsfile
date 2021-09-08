pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo "Hello World!"
                ssh 'docker version'
            }
        }
    }
}
