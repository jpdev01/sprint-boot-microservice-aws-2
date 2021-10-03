# aplha-back-end

fix:
fazer uma maneira de descobrir o usuário atual logado melhorar a forma como é guardado a language do
usuario

AWS:
Gerar o .jar:
mvn clean package -DskipTests

conectar:
sudo ssh -i "/media/jpt/OS/jpt/jptpgm/projects-full/alpha/aws/Amazonalphaapp.pem" ubuntu@ec2-3-143-252-179.us-east-2.compute.amazonaws.com

package:
sudo scp -i /media/jpt/OS/jpt/jptpgm/projects-full/alpha/aws/Amazonalphaapp.pem
/media/jpt/OS/jpt/jptpgm/projects-full/alpha/aplha-back-end/target/aplha-back-end-1.0-SNAPSHOT.jar
ubuntu@ec2-3-143-252-179.us-east-2.compute.amazonaws.com:~

iniciar o jar:
java -jar ...
