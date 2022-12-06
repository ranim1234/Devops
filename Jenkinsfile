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
}
}

