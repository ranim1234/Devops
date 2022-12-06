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

                    sh 'C:/Program Files (x86)/apache-maven-3.8.6/bin test'

                }
            }
}
}

