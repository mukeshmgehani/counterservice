# Counter Service

---
###Prerequisites

1. Maven latest version
2. Java 11 and Above
3. command prompt or shell
4. Docker
5. Kubernete cluster with Kubectl

---
 
### Please follow below steps to compile and run the Project


1.Go inside project with using below command from shell or command prompt.

**cmd>cd counterservice**

2.Run Maven Build command to Build the Project and create the executable Jar.

**counterservice>mvn clean install**

3.Once Build is Success then you can see runnable jar has been created in target directory. if you want to run and check then follow below commands.

**counterservice>cd target** 

**counterservice/target>java -jar counterservice-0.0.1-SNAPSHOT.jar** 

4.Once Application is Started you can hit below url to see number of counter,increase and decrease the counter.

No. of counter  -- <http://localhost:8080/counter>

Increase counter -- <http://localhost:8080/counter/increase>

Decrease counter -- <http://localhost:8080/counter/decrease>

5.If you want to deploy and run on kubernetes then follow below steps.
**Note:- Your kubernet cluster should be up and running and showing command as executed on minikube** 

**a)** Go to your project directory.

**cmd>cd counterservice**

**b)** Run below command for deploying and running on kubenetes and exposing url to hit from outside kubernetes

**cmd>kubectl apply -f kube**

**c)** you can see that deployment and service got created and you can verify with below command and see all.

**cmd>kubectl get all**

**d)** Run below command (as per minikube) to get the external IP for counter service and hit the URL.

**cmd>minikube service counterservice --url**

**e)** you can hit the endpoints and check using this url.

No. of counter  -- <Url from point .d/counter>

Increase counter -- <Url from point .d/counter/increase>

Decrease counter -- <Url from point .d/counter/decrease>

---