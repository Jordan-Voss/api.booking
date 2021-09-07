pipeline {
agent any
  stages {
          stage('Build') {
              steps {
                  sh 'mvn clean install'
              }
          }
          stage('Test') {
              steps {
                  echo 'Starting Testing..'
              }
          }
          stage('Deploy') {
              steps {
                  echo 'Deploying....'
              }
          }
      }
  }