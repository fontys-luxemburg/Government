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
        sh 'yarn --cwd src/main/frontend install'
        sh 'yarn --cwd src/main/frontend run build'
        sh 'mvn clean install'
      }
    }
    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }
    stage('Deploy') {
      steps {
        sh 'docker stop $(docker ps -a -q)'
        sh 'docker-compose down'
        sh 'docker-compose up -d'
      }
    }
  }
}
