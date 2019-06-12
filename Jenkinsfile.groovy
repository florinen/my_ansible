pipeline {
    agent any
    properties([parameters([choice(choices: ['addusers'], description: 'this playbook adds an remove users', name: 'What playbook to run')])])
    stages {
      stage('Checkout SCM') {
          steps {
              git branch: 'master', url: 'https://github.com/florinen/my_ansible.git'
          }
                    
        }
      stage('Ansible Deploy') {
           steps {
               sh 'ansible -i hosts -m ping all'
            }
        }
    }
}
