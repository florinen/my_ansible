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
                 
              dir('$(WORKSPACE)/my_ansible')
              {
               
               sh 'ansible all -m ping -i hosts'
               
            }
            }
        }
    }
}