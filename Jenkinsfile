pipeline{

    agent any

    stages {

        stage('Git Checkout'){

            steps{

                script{

                    git branch: 'main', url: 'https://github.com/ranim1234/Devops.git'
                }
            }
        }


         stage('UNIT testing'){

                steps{

                   bat 'mvn test'

                }
            }
         stage('Integration testing'){

                steps{

                       script{

                             bat 'mvn verify -DskipUnitTests'
                         }
                     }
                 }
                         stage('Maven build'){

                             steps{

                                 script{

                                     bat 'mvn clean install'
                                 }
                             }
                         }
                                  stage('Static code analysis'){

                                      steps{

                                          script{

                                              withSonarQubeEnv(credentialsId: 'sonar-api'){

                                                  bat 'mvn clean package sonar:sonar'
                                              }
                                             }

                                          }
                                      }
                                                  stage("Quality Gate") {
                                                       timeout(time: 1, unit: 'HOURS') {
                                                           waitForQualityGate abortPipeline: true
                                                       }
                                                 }
}
}

