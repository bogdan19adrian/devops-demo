pipeline {
    agent any
    tools {
        maven "maven"
        jdk "jdk-11"
    }
    stages {
        stage('Initialize'){
            steps{
                echo "PATH = ${M2_HOME}/bin:${PATH}"
                echo "M2_HOME = /opt/maven"
            }
        }
        stage('Build') {
            steps {
                dir("/var/jenkins_home/workspace/devops-training-v1") {
                sh 'mvn -B -DskipTests clean package'
                }
            }
        }
        stage('Deploy') {
            steps {
                if (currentBuild.currentResult == 'SUCCESS') {
                    if (env.BRANCH_NAME == ‘main’) {
                        sh 'echo "on main branch" '
                    } else {
                        sh 'echo "on other branch" '
                    }
                }
            }
        }
     }
    post {
       always {
          junit(
        allowEmptyResults: true,
        testResults: '*/test-reports/.xml'
      )
      }
   }
}