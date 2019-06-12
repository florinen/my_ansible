
pipeline {
    agent any
    wrap([$class: 'AnsiColorBuildWrapper', 'colorMapName': 'XTerm']) {
  sh 'something that outputs ansi colored stuff'
}
    stages {
      stage('Checkout SCM') {
          steps {
              git branch: 'master', url: 'https://github.com/florinen/my_ansible.git'
          }
                    
        }
      stage('Ansible Deploy') {
           steps {
               sh 'ansible-playbook -i hosts adduser.yaml '
            }
        }
    }
}

 
