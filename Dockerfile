
#imagem base
FROM openjdk:1
#label caso publique a imagem
LABEL maintener="jptruchinski@gmail.com"

#profile q vou subir
# AREA dentro do spring boot onde voce consegue definir parametros, ex, um config de banco etc. (separar dev, homolog e prod)
ARG PROFILE
#opcoes adicionais
ARG ADDITIONAL_OPTS

# VARIAVEL DE AMBIENTE
ENV PROFILE={PROFILE}
# guardar os parametros do java, ex: quantidade xmx, xms etc
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

#diretorio de trabalho dentro da docker
WORKDIR opt/alpha-back-end

#jogar o jar da minha maquina para dentro da docker
#vai chamar de app.jar dentro do workdir
COPY /target/aplha*.jar app.jar

# SHELL PARA EXECUTAR ALGO
# so para deixar o cmd pronto
SHELL ["/bin/sh", "-c"]

# expor a porta 8080
EXPOSE 8080
# 5005 = PARA CONECTAR DEBUG
EXPOSE 5005

CMD java ${ADDITIONAL_OPTS} -jar app.jar --spring.profiles.active=${PROFILE}