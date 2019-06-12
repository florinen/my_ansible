pipeline {
    agent any
    stages {
      stage('Checkout SCM') {
        git branch: 'master', url: 'https://github.com/florinen/my_ansible.git'
             
        }
      stage('Ansible Deploy') {
            
          steps {
                 
               sh 'ansible -i hosts -m ping all'
               
            }
        }
    }
}
