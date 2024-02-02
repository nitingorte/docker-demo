# Install java
```
sudo apt update
sudo apt install openjdk-17-jre -y
java -version
```
# Install jenkins
```
sudo wget -O /usr/share/keyrings/jenkins-keyring.asc \
  https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key
echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] \
  https://pkg.jenkins.io/debian-stable binary/ | sudo tee \
  /etc/apt/sources.list.d/jenkins.list > /dev/null
sudo apt-get update
sudo apt-get install jenkins -y
```
# Start jenkins
```
sudo systemctl enable jenkins
sudo systemctl start jenkins
sudo systemctl status jenkins
```
# Update security inbound rules

![image](https://github.com/nitingorte/docker-demo/assets/92674727/e02617bd-e4e3-4b85-b193-6be759a423c1)

# Add jenkins plugins

Manage Jenkins --> Available plugins
1. openJDK-native-plugin
2. Eclipse Temurin installer
3. Docker
4. Docker pipeline
5. docker-build-step
6. SonarQube Scanner
7. SSH2 easy

# Configure jenkins tools

Manage Jenkins --> Tools

1. JDK installations --> JDK --> Install automatically --> version --> jdk-17
2. Maven installations --> Maven name --> Install automatically --> version --> latest
3. Docker installations --> Docker name --> Install automatically --> version --> latest

# Jenkins job create & configuration

Dashboard --> Create a job --> name --> Freestyle project --> OK
job --> Configuration 
1. General --> Check Discard old builds --> Max of builds to keep --> 2
2. Source Code Management
   
   a. Git --> Repository URL --> https://[your-token]@[ssh-repo-url] 

   example.
   ```
   https://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@github.com/nitingorte/docker-demo.git
   ```
   b. Build Triggers --> GitHub hook trigger for GITScm polling
4. Build Steps --> Invoke top-level Maven targets
  Maven Version --> select
  Goals --> clean install -DskipTests

# Sonarqube install
```
wget https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-10.3.0.82913.zip
sudo apt install unzip
unzip sonarqube-10.3.0.82913.zip
cd sonarqube-10.3.0.82913/bin/linux-x86-64/
./sonar.sh console
```
# Update security inbound rules for sonarqube
![image](https://github.com/nitingorte/docker-demo/assets/92674727/46ddbae1-9a51-4433-8f7f-a745d3d9c4b9)

# Sonarqube 
1. login to http://[ec2-public-ip]:9000 with admin as default username & password.

# Using Docker
1. Docker install
```
sudo apt-get update
sudo apt-get install docker.io -y
```
```
sudo usermod -aG docker $USER  # Replace with your system's username, e.g., 'ubuntu'
newgrp docker
sudo chmod 777 /var/run/docker.sock
```
2. Sonarqube install
```
docker run -d -p 9000:9000 --name sonarqube --network jenkins-pipeline sonarqube:lts-community
```
# Sonarqube configuration
1. Manage Jenkins --> Configuration
![image](https://github.com/nitingorte/docker-demo/assets/92674727/fa38e9f0-444b-481d-9f21-33c3b88d2705)

2. Manage Jenkins --> Tools
  a. Git
    ![image](https://github.com/nitingorte/docker-demo/assets/92674727/b5b3fcb1-caeb-4f49-b8da-25ddeac1b019)

  b. Sonarqube 
    ![image](https://github.com/nitingorte/docker-demo/assets/92674727/7531570d-0a20-4412-ad4b-89d08a3d215e)

  c. Maven
    ![image](https://github.com/nitingorte/docker-demo/assets/92674727/bd50f1e3-7af2-48ff-a8b3-57f73ac8d49b)

3. Dashboard --> Job --> Configuration
  a. Maven

      ![image](https://github.com/nitingorte/docker-demo/assets/92674727/2a0464c5-1bef-41c7-ade0-ac8d47b951bb)
   
  b. Sonarqube scanner
  
       ![image](https://github.com/nitingorte/docker-demo/assets/92674727/401f8e4d-09d2-445a-8974-b9f66a2f7fbb)

 









