def SUREFIRE_REPORT_PATH = 'target/surefire-reports/TEST-TestSuite.xml'
def MOBILE_PROJECT = 'mobile-frame-bone'

pipeline {
    agent any

    parameters {
        booleanParam(defaultValue: true, description: 'run web tests', name: 'web')
        booleanParam(defaultValue: false, description: 'run api tests', name: 'api')
        booleanParam(defaultValue: false, description: 'run mobile tests', name: 'mobile')

    }

    stages {
        stage('Clone project') {
        steps{
                    echo 'Update project from git'
//                     sh "git pull --rebase origin master"
                    git url: 'https://github.com/MartsinkevichIvan/pipka.git'
        }

        }

        stage('Web tests') {
            when{
                expression {
                    params.web
                }
            }
            steps{
                echo 'Running web tests'
                echo '${MOBILE_PROJECT}'
//                  sh 'mvn clean compile'
                 sh "cp ../${MOBILE_PROJECT}/${SUREFIRE_REPORT_PATH} ./mobile_result.xml"
                 echo 'Finishing web tests'


            }
            post {
                always {
                    step([$class: 'XUnitBuilder',
                    thresholdMode: 2,
                    thresholds: [[$class: 'FailedThreshold', unstableThreshold: '90']],
                    tools: [[$class: 'JUnitType', pattern: 'encoder_result.xml']]])
                }
            }

        }
    }
}
