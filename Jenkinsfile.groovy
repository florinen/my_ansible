
pipeline {
    agent any
    properties([parameters([string(defaultValue: 'Hello! Florin', description: '', name: 'ANSIBLE_MSG', trim: true)])])
    environment {
  MSG = "$ANSIBLE_MSG"
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
 
