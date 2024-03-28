pipeline {
  agent {
      label 'azure-1'
  }

  stages {
      stage('show')
        {
            steps {
                sh (script: """ pwd """ ,label: "stage test"  )
            }
        }
  }
}
