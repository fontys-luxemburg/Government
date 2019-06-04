pipeline {
  agent any
  stages {
    stage('build') {
      post {
        success {
          archiveArtifacts 'target/*.war'
          sh 'docker build -t redxice/government:deploy .'

        }

      }
      steps {
        sh '''npm install
'''
        sh 'npm run build'
        sh 'mvn clean install'
        sh 'cd src/main/frontend'
      }
    }
    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }
    stage('Deploy') {
      steps {
        sh 'docker-compose down'
        sh 'docker-compose up -d'
      }
    }
  }
}