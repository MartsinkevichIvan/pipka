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
            steps{
                echo 'Running web tests'
                 sh 'mvn -Dsurefire.suiteXmlFiles=src\test\resources\Testng-all.xml clean test'
                 echo 'Finishing web tests'
            }

        }
    }
}
