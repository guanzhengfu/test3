pipeline {
    agent any
    triggers {
        GenericTrigger(
                genericVariables: [
                        [key: 'commit', value: '$.commits[0].id'],
                        [key: 'committer', value: '$.commits[0].committer.name'],
                        [key: 'ref', value: '$.ref']
                ],
                token: 'test',
                causeString: 'Triggered by github webhook on commit $commit to $ref by $committer',
                printContributedVariables: true,
                printPostContent: true,
                silentResponse: true
        )
    }
    stages {
        stage('Example') {
            options {
                timeout(time: 1, unit: 'HOURS')
            }
            steps {
                echo 'Hello World662222'
            }
        }
    }
}