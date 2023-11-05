node{
        stage('Checkout GIT') {
                git branch: 'omar_fitouri', url: 'https://github.com/asmaoudherfi/Achat'
        }
        stage('Clean and Compile') {
                sh 'mvn clean compile'
        }
        stage('Test'){
                sh 'mvn test'
        }
        stage('Sonarqube') {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
        }
        stage('build') {
                sh 'mvn package'
        }
        stage ('upload Artifact to Nexus') {
          nexusArtifactUploader artifacts: [
          [
          artifactId: 'achat',
          classifier: '',
          file: 'target/achat-1.0.jar',
          type: 'jar'
           ]],
          credentialsId: 'nexus',
          groupId: 'tn.esprit.rh',
          nexusUrl: '192.168.56.10:8081',
           nexusVersion: 'nexus3',
           protocol: 'http',
           repository: 'maven-project',
            version: "version '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
            }
        stage('Construction Docker') {
                sh 'docker build -t omarftr/achat:1.0 .'
        }
        stage('Publication Docker') {
             def dockerImage = docker.image("omarftr/achat:1.0")
                docker.withRegistry('https://registry.hub.docker.com', 'dckr_pat__VhuglZdUUAdzDcPXF_33nE7SAM') {
                    dockerImage.push()}
                }
        stage('Build and Run Docker Compose') {
            sh 'docker compose up -d'
                }

}

