node{
    stage('Clone'){
            git branch: 'AlaaBranch', url: 'https://github.com/asmaoudherfi/Achat.git'
    }
    stage('Clean'){
            sh 'mvn clean'
    }
    stage('Compile'){
            sh 'mvn compile'
    }

    stage('SonarQube Analysis') {
            withSonarQubeEnv {
                sh 'mvn clean package sonar:sonar'
            }
    }
    stage('Quality gate') {
            waitForQualityGate abortPipeline: true, credentialsId: 'sonarqube'
    }

    stage('JaCoCo Analysis') {
            jacoco(execPattern: '**/target/jacoco.exec')
            sh 'mvn clean test jacoco:report'
    }

    stage('Build'){
            sh 'mvn package'
    }

    stage ('Upload Artifact to Nexus') {
          nexusArtifactUploader artifacts: [
          [
              artifactId: 'achat',
              classifier: '',
              file: 'target/achat-1.0.jar',
              type: 'jar'
           ]],
          credentialsId: 'nexus-credentials',
          groupId: 'tn.esprit.rh',
          nexusUrl: '192.168.33.10:8081',
          nexusVersion: 'nexus3',
          protocol: 'http',
          repository: 'maven-project',
          version: "version '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
    }

    stage('slack') {
          slackSend channel: 'achat-pipeline', message: 'Build is completed check the artifact ! '
    }

    stage('docker build') {
        sh 'docker build -t alaaeddinezarrouk/achat:1.0 .'
    }

    stage('docker push') {
        def dockerImage = docker.image("alaaeddinezarrouk/achat:1.0")
        docker.withRegistry('https://registry.hub.docker.com','Docker-credentials') {
            dockerImage.push()
        }
    }
    stage('Build and Run Docker Compose') {
        sh 'docker compose up -d'
    }




}