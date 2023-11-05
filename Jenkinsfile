node {
    stage('clone') {
 git branch: 'AsmaBranch', url: 'https://github.com/asmaoudherfi/Achat.git'

}
 stage('clean') {
     sh 'mvn clean'
 }
 stage('compile') {
     sh 'mvn compile'
 }

stage('SonarQube Analysis') {

                withSonarQubeEnv {
                    sh 'mvn clean package sonar:sonar'
                }

        }

        stage("Quality Gate") {

                waitForQualityGate abortPipeline: true ,credentialsId: 'sonarQube'

        }
       stage('Collect JaCoCo Coverage') {
                  jacoco(execPattern: '**/target/jacoco.exec')


}

stage('Test with JaCoCo') {

              //   Run your tests with JaCoCo enabled and generate JaCoCo XML reports
              sh 'mvn  test jacoco:report'

}
  stage('build') {
     sh 'mvn package'
 }


 stage('Test JUNIT') {

                // Run your JUnit tests
                sh 'mvn test' // Replace with the test command for your project
            }
 stage ('upload Artifact to Nexus') {

          nexusArtifactUploader artifacts: [
          [
          artifactId: 'achat',
          classifier: '',
          file: 'target/app.jar.jar',
          type: 'jar'
           ]],
          credentialsId: 'nexus',
          groupId: 'tn.esprit.rh',
          nexusUrl: '192.168.33.10:8081',
           nexusVersion: 'nexus3',
           protocol: 'http',
           repository: 'maven-project',
             version: "version '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"



            }





stage('slack') {
          slackSend channel: 'devopss', message: 'bonjour asma voici un nouveau bluid ${env.JOB_NAME} [${env.BUILD_NUMBER}]  '
}
stage('docker build') {
        sh 'docker build -t asmaoudherfi/achatprojet:1.0 .'


}
//stage('docker push') {
 //   def dockerImage = docker.image("asmaoudherfi/achatprojet:1.0")

        //docker.withRegistry('https://registry.hub.docker.com','dckr_pat_OHzbqSzlZkDPMuKuyUrO0hkTNDU') {
                       // dockerImage.push()
                  //  }


//}
stage('Build and Run Docker Compose') {
        sh 'docker compose up -d'
    }
    stage('Prometheus Metrics Scraping') {

                // Liste des noms de job Prometheus à scraper
                def prometheusJobs = [
                    'Nexus',
                    'SonarQube',
                    'docker',
                    'jenkins',
                    'prometheus'
                ]

                def prometheusURL = 'http://192.168.33.10:9090' // URL de votre serveur Prometheus

                // Parcourir la liste des jobs et déclencher le scraping pour chaque job
                for (def jobName in prometheusJobs) {
                    def prometheusScrapeCommand = "curl -X GET $prometheusURL/api/v1/targets?match[]=$jobName"
                    sh script: prometheusScrapeCommand, returnStatus: true
                    echo "Metrics scraped for $jobName"
                }
                }


}