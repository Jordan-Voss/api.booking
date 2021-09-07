pipeline {
    agent {label maven}
    tools {
    maven 'Maven_3.3.3'
    jdk 'java-11'
    }
  stages {
          stage('Build') {
              steps {
                  echo 'Building..'
              }
          }
          stage('Test') {
              steps {
                  echo 'Testing..'
              }
          }
          stage('Deploy') {
              steps {
                  echo 'Deploying....'
              }
          }
      }
  }