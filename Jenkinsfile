pipeline {
agent any
  stages {
          stage('Build') {
              steps {
                  sh 'mvn clean install'
              }
          }
          stage('Build Docker Image') {
              steps {
                  sh 'docker buildx build --platform linux/arm/v7 -t api.booking .'
                  sh 'docker save --output api.tar api.booking:latest'
                  sh 'ls'
                  sh 'docker load -i api.tar'
                  sh 'docker image ls'
                  sh 'docker run -p 8080:8080 api.booking:latest .'

              }
          }
          stage('Deploy') {
              steps {
                  echo 'Deploying....'
              }
          }
      }
  }