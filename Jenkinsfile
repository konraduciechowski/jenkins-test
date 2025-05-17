pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout main

                sh 'git log HEAD^..HEAD --pretty="%h %an - %s" > GIT_CHANGES'
                def lastChanges = readFile('GIT_CHANGES')
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
