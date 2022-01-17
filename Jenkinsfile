def SUREFIRE_REPORT_PATH = 'target/surefire-reports/TEST-TestSuite.xml'

pipeline {
    agent any

    parameters {
        booleanParam(defaultValue: true, description: 'run web tests', name: 'web')
        booleanParam(defaultValue: false, description: 'run api tests', name: 'api')
        booleanParam(defaultValue: false, description: 'run mobile tests', name: 'mobile')

    }

    stages {
//         stage('Clone project') {
//             steps{
//                     echo 'Update project from git'
//                     git url: 'https://github.com/MartsinkevichIvan/pipka.git'
//             }
//         }

        stage('Web tests')   {
            when{
                expression {
                    params.web
                }
            }
            steps{
                build job: 'WebJob', parameters:[string(name:'test.suite',value:'TestngWeb'),
                string(name: 'rp.launch', value: 'WEB_TESTS_FROM_JENKINS')],propagate:false
            }
            post{
                always{
                    step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'],
                    thresholdMode: 2,
                    thresholds: [[$class: 'FailedThreshold', unstableThreshold: '90']],
                    tools: [[$class: 'TestngType', pattern: '**/testng-results.xml']]])
                }
            }
        }

        stage("Appium tests"){
            when {
                expression{
                    params.api
                }
            }
            steps{
                build job: 'AppiumJob', parameters:[
                string(name:'test.suite',value:'AppiumMobileTest'),
                string(name: 'rp.launch', value: "App_TESTS_FROM_JENKINS")],
                propagate:false
            }
        }
    }
}
