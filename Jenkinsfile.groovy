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
            }
        }
    }
}
ansiColor('xterm') {
        ansiblePlaybook(
        playbook: '$(WORKSPACE)/my_ansible',
        inventory: '$(WORKSPACE)/my_ansible',
        credentialsId: 'bastion_keys',
        colorized: true)
    }
