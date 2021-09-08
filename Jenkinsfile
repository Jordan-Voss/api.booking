// pipeline {
// agent any
//   stages {
//           stage('Build') {
//               steps {
//                   sh 'mvn clean install'
//               }
//           }
//           stage('Build Docker Image') {
//               steps {
//               sh 'ls'
//                   sh 'docker buildx build --platform linux/arm/v7 -t api.booking .'
//                   sh 'docker save --output api.tar api.booking:latest'
//                   sh 'ls'
//                   sh 'docker load -i api.tar'
//                   sh 'docker image ls'
//                   sh 'docker run -p 8080:8080 api.booking:latest .'
//
//               }
//           }
//           stage('Deploy') {
//               steps {
//                   echo 'Deploying....'
//               }
//           }
//       }
//   }
node {
    agent any
        stage('Build') {
            sh 'mvn clean install'

            def pom = readMavenPom file:'pom.xml'
            print pom.version
            env.version = pom.version
        }

        stage('Image') {
            dir ('account-service') {
                def app = docker.build '''api:${env.version}'''
                app.push()
            }
        }

        stage ('Run') {
            docker.image('''api:${env.version}''').run('''-p 2222:2222 -h api --name api --link discovery''')
        }

        stage ('Final') {
            build job: 'customer-service-pipeline', wait: false
        }
    }

