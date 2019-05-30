pipeline {
  agent any
  stages {
    stage('build') {
      post {
        success {
          archiveArtifacts '*.war'
          sh 'docker build -t redxice/goverment:deploy .'

        }

      }
      steps {
        sh 'mvn clean install'
      }
    }
    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }
    stage('Deploy'){
      steps {
          sh 'docker-compose up -d'
        }
    }
  }
}