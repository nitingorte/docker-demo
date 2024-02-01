# install java
```
sudo apt update
sudo apt install openjdk-17-jre
java -version
```
# install jenkins
```
sudo wget -O /usr/share/keyrings/jenkins-keyring.asc \
  https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key
echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] \
  https://pkg.jenkins.io/debian-stable binary/ | sudo tee \
  /etc/apt/sources.list.d/jenkins.list > /dev/null
sudo apt-get update
sudo apt-get install jenkins
```
# start jenkins
```
sudo systemctl enable jenkins
sudo systemctl start jenkins
sudo systemctl status jenkins
```
# update security inbound rules

![image](https://github.com/nitingorte/docker-demo/assets/92674727/e02617bd-e4e3-4b85-b193-6be759a423c1)

# add jenkins plugins

Manage Jenkins --> Available plugins
1. openJDK-native-plugin
2. Eclipse Temurin installer
3. Docker
4. Docker pipeline
5. docker-build-step

# configure jenkins tools

Manage Jenkins --> Tools

1. JDK installations --> JDK --> Install automatically --> version --> jdk-17
2. Maven installations --> Maven name --> Install automatically --> version --> latest
3. Docker installations --> Docker name --> Install automatically --> version --> latest

# create root user on ec2 instance
```
sudo usermod -aG jenkins $USER
sudo systemctl restart jenkins
```
# jenkins job create & configuration

Dashboard --> Create a job --> name --> Freestyle project --> OK
job --> Configuration 
1. General --> Check Discard old builds --> Max of builds to keep --> 2
2. Source Code Management
   a. Git --> Repository URL --> https://<your-token>@<ssh-repo-url>
      example. ```https://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@github.com/nitingorte/docker-demo.git```
   b. Build Triggers --> GitHub hook trigger for GITScm polling
3. Build Steps --> Invoke top-level Maven targets
  Maven Version --> select
  Goals --> clean install -DskipTests
















