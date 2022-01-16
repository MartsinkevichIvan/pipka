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
                 sh 'mvn test -Drp.launch=aliaksandr_dyrykau_TEST -Dtest.suite=TestngWeb'
                 echo 'Finishing web tests'
            }
        }

        stage("Appium tests"){
            when {
                expression{
                    params.api
                }
            }
            steps{
                echo 'Running api tests'
                sh 'mvn test -Dtest.suite=AppiumMobileTest'
                echo 'Finishing api tests'
            }
        }
    }
}
