pipeline {
    agent any

    stages 
    {
        stage('Hello') 
		{
            steps 
			{
                echo 'Hello World'
            }
        }
         stage('HealthCheck') 
		{
            steps 
			{
                bat '''dir
				 ping 96.84.175.78 -n 5'''
            }
        }
        stage('Execute Selenium Tests') 
		{
            steps 
			{
                git 'https://github.com/sudheer51/CloudMMP.git'
                dir('mmp')
				{
					bat 'mvn clean test'
            	}
			}
		}
	}
}
