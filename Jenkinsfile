def SUREFIRE_REPORT_PATH = 'target/surefire-reports/TEST-TestSuite.xml'


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
                 sh 'mvn clean compile'
                 sh 'mvn test -Dsurefire.suiteXmlFiles=Testng-appium.xml'
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
