pipeline {
    agent any
    triggers {
        GenericTrigger(
                genericVariables: [
                        [key: 'ref', value: '$.ref']
                ],
                causeString: 'Triggered on $ref',
                token: 'abc123',
                printContributedVariables: true,
                printPostContent: true,
                silentResponse: false,
                regexpFilterText: '$ref',
                regexpFilterExpression: 'refs/heads/' + BRANCH_NAME
        )
    }
    stages {
        stage('Example') {
            options {
                timeout(time: 1, unit: 'HOURS')
            }
            steps {
                echo 'Hello World663333444'
            }
        }
    }
}