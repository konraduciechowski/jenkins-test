String gitCredentials = "jenkins-local"

pipeline {
    agent any

    stages {
        stage('Checkout') {
             steps {
                echo "Cloning the code"
                git url: "https://github.com/infoshareacademy/jpydzr7-pandas-revise", branch: "main", credentialsId: gitCredentials
            }
        }

        stage('Run python') {
            steps {
                echo 'installing requirements'
		sh '''
			python3 -m venv .venv
			ls -la .venv/bin/
			. .venv/bin/activate && pip install -r requirements.txt
			python3 pandas-revise.py
		   '''	
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
