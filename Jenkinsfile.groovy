
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
               sh 'ansible -i hosts -m ping all'
               sh 'ansible-playbook -i hosts adduser.yaml '
            }
        }
    }
}

 
