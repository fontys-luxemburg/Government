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
    stage('Scan code') {
      steps {
        sh '''mvn sonar:sonar \\
-Dsonar.host.url=http://sonarqube.swym.nl \\
-Dsonar.login=55d4924f14df92d208e26fbf47c05de918e3a044'''
      }
    }
    stage('deploy') {
      steps {
        sh 'docker-compose -f docker-compose.yml down'
        sh 'docker-compose -f docker-compose.yml up  -d '
      }
    }
  }
}