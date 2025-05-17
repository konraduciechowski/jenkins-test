pipeline {
    agent any

    stages {
        stage('Checkout') {
             steps {
                echo "Cloning the code"
                git url: "https://github.com/konraduciechowski/jenkins-test", branch: "main"
            }
        }

        stage('Run python') {
            steps {
                sh 'python main.py'
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
