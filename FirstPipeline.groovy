String gitCredentials = "jenkins-local"

pipeline {
    agent any

    stages {
        stage('Checkout') {
             steps {
                echo "Cloning the code"
                git url: "https://github.com/konraduciechowski/jenkins-test", branch: "main", credentialsId: gitCredentials
            }
        }

        stage('Run python') {
            steps {
                echo 'installing requirements'
                //sh 'pip install requirements.txt'
                sh 'python3 main.py'
            }
        }
    }

    post {
        success {
            echo "Build successful"
            // You can add additional steps here, like running tests or notifications.
        }

        failure {
            echo "Build failed"
        }
    }
}
