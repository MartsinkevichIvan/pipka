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
                 sh 'mvn test -Drp.launch=WEB -Dpropagate=true -Dtest.suite=TestngWeb1'
                 sh 'if [ -f "$file" ]
                     then
                         echo "$file found."
                     else
                         echo "$file not found."
                         exit 1
                     fi'
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
                sh 'mvn test -Drp.launch=Appium -Dtest.suite=AppiumMobileTest'
                echo 'Finishing api tests'
            }
        }
    }
}
