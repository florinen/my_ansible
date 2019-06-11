pipeline {
    agent any
    stages {
      stage('checkout') {
           steps {
           
                git branch: 'master', url: 'https://github.com/florinen/my_ansible.git'
             
          }
        }
        
        stage('Ansible Deploy') {
             
            steps {
                 
                             
               sh 'ansible all -m ping -i hosts'
               
            }
        }
    }
}
