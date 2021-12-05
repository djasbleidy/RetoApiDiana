pipeline {
    agent any
    tools {
        gradle 'gradle'
    }
    stages {
        stage('clean') {
            steps {
               sh 'gradle clean'
            }
        }
        stage('test') {
            steps {
               sh 'gradle test aggregate'
            }
        }
        stage('informe') {
            steps {
                   publishHTML (target: [
                       reportName: 'Serenity',
                       reportDir: 'target/site/serenity',
                       reportFiles: 'index.html',
                       keepAll: true,
                       alwaysLinkToLastBuild: true,
                       allowMissing: false
                   ])
            }
        }
        stage('email'){
            steps{
                 mail (body: 'The pipeline ended successfully, the report is now available', subject: 'This is test email with serenity', to: 'robotTest.622@gmail.com')
            }
        }

    }


}