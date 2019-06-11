pipeline {
    agent any
    stages {
      stage('checkout') {
           steps {
           
                git branch: 'master', url: 'https://github.com/florinen/my_ansible.git'
             
          }
        }
        
           stage('Ansible Init') {
            steps {
                script {
                
               def tfHome = tool name: 'Ansible'
                env.PATH = "${tfHome}:${env.PATH}"
                 sh 'ansible --version'
                    
            }
            }
        }
         
        stage('Ansible Deploy') {
             
            steps {
                 
              dir('ansible/my_ansible')
              {
               
               sh 'ansible all -m ping -i hosts'
               
            }
            }
        }
    }
}