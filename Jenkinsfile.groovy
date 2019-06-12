
pipeline {
    agent any
    
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

 
ansiColor('xterm') {
  echo 'something that outputs ansi colored stuff'
}