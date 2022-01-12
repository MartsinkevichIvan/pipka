def SUREFIRE_REPORT_PATH = 'target/surefire-reports/TEST-TestSuite.xml'


pipeline {
    agent any

    tools {
        maven "3.8.4"
        java "11"
    }

    parameters {
        booleanParam(defaultValue: true, description: 'run web tests', name: 'web')
        booleanParam(defaultValue: false, description: 'run api tests', name: 'api')
        booleanParam(defaultValue: false, description: 'run mobile tests', name: 'mobile')

    }

    stages {
        stage('Clone project') {
            echo 'Update project from git'
            git url: 'git@git.epam.com:Artsiom_Rudzko/mobile-frame-bone.git'
        }

        stage('Web tests') {
            when {
                expression { return params.web }
            }
            steps {
                echo 'Running web tests'
            }
        }
    }
}
