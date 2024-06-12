#!/bin/bash

# Define as cores
GREEN='\033[0;102m'
RED='\033[0;101m'
CYAN='\033[0;96m'
YELLOW='\033[0;33m'
NC='\033[0m' # No Color

#DEFINIÇÃO DE VARIAVEIS PARA SQL
CONTAINER_NAME="SecurityWingsBD"

echo -e "${CYAN}[BOT Security-Wings]:${YELLOW} Olá querido usuário ${NC}"

sudo apt-get update >/dev/null 2>&1

echo -e "${CYAN}[BOT Security-Wings]:${YELLOW} Irei fazer a instalação e configuração de tudo necessário para o sistema funcionar perfeitamente!${NC}"
echo
sleep 1

#echo -e "${CYAN}[BOT Security-Wings]: ${YELLOW} Vou verificar se o NodeJS está instalado em sua maquina...${NC}"
#echo
#sleep 1
#node -v > /dev/null 2>&1 #verifica NodeJS
#if [ $? = 0 ]; #se retorno for igual a 0
#        then #entao,
#                echo -e "${CYAN}[BOT Security-Wings]: ${GREEN}NODEJS INSTALADO!" #print no terminal
#                echo
#		echo -e "${CYAN}[BOT Security-Wings]: ${YELLOW}Prosseguindo para proxima etapa ..."
#		echo
#		echo
#
#        else #se nao,
#                echo -e "${CYAN}[BOT Security-Wings]: ${RED}NODEJS NÃO INSTALADO${NC}" #print no terminal
#                echo
#                echo -e "${CYAN}[BOT Security-Wings]: ${YELLOW}O NodeJS é necessario para a aplicação gostaria de instalar o NodeJS ? ${NC}[sim/não]" #print no terminal
#
#                read get #variável que guarda resposta do usuário
#
#        if [ \"$get\" == \"sim\" ]; #se retorno for igual a s
#                then #entao
#                echo -e "${CYAN}[BOT Security-Wings]: ${YELLOW}Iniciando a instalação !${NC}"
#                sleep 1
#		curl -fsSL https://deb.nodesource.com/setup_lts.x | sudo -E bash -
#                sudo apt-get install -y nodejs #executa instalacao do nodejs
#                sleep 1
#                echo -e "${CYAN}[BOT Security-Wings]: ${YELLOW}NodeJS instalado com ${GREEN}SUCESSO! ${YELLOW}Prosseguindo para a proxima etapa...${NC}"
#                echo
#                echo
#                sleep 2
#        fi #fecha o 2º if
#fi #fecha o 1º if
#

echo -e "${CYAN}[BOT Security-Wings]:${YELLOW}Vou verificar Se o JAVA está instalado em sua maquina...${NC}"
echo
sleep 1

java --version > /dev/null 2>&1

if [ $? = 0 ]; #se retorno for igual a 0
	then #entao,
		echo -e "${CYAN}[BOT Security-Wings]: ${GREEN}JAVA INSTALADO ${NC}" #print no terminal
		echo
		echo -e "${CYAN}[BOT Security-Wings]: ${YELLOW}Prosseguindo para a proxima etapa...${NC}"
		echo
		echo
	else #se nao,
		echo -e "${CYAN}[BOT Security-Wings]: ${RED}JAVA NÃO INSTALADO${NC}" #print no terminal
		echo
		echo -e "${CYAN}[BOT Security-Wings]: ${YELLOW}O Java é necessário para a aplicação deseja instalar o JAVA em sua maquina?${NC} [sim/não]" #print no terminal

		read get #variável que guarda resposta do usuário

	if [ \"$get\" == \"sim\" ]; #se retorno for igual a s
		then #entao
		echo -e "${CYAN}[BOT Security-Wings]: ${YELLOW}Iniciando a instalação JAVA !${NC}"
		sleep 1
    (sudo apt install openjdk-17-jre -y >/dev/null 2>&1) &
        pid=$!
        while kill -0 $pid 2>/dev/null; do
            echo -n -e "${GREEN}.${NC}"
            sleep 1
        done
    echo
    echo
		echo -e "${CYAN}[BOT Security-Wings]: ${YELLOW}Java instalado com ${GREEN}SUCESSO! ${YELLOW}Prosseguindo para a proxima etapa...${NC}"
		echo
		echo
	fi #fecha o 2º if
fi #fecha o 1º if

echo -e "${CYAN}[BOT Security-Wings]: ${YELLOW}Vou verificar se o Docker está instalado em sua maquina...${NC}"
echo
sleep 1

docker --version >/dev/null 2>&1

if [ $? = 0 ];
	then
		echo -e "${CYAN}[BOT Security-Wings]: ${GREEN}Docker instalado${NC}"
		echo -e "${CYAN}[BOT Security-Wings]: ${YELLOW}Prosseguindo para a proxima etapa...${NC}"
		echo
	else
		echo -e "${CYAN}[BOT Security-wings]: ${RED}Docker não instalado${NC}"
		echo -e "${CYAN}[BOT Security-Wings]: ${YELLOW}Gostaria de instalar o Docker?${NC}[sim/não]"
		echo
		
		read get
	
	if [ \"$get\" == \"sim\" ];
		
		then 
		echo -e "${CYAN}[BOT Security-Wings]: ${YELLOW}Iniciando instalação Docker${NC}"
		sleep 1

    echo -e "${CYAN}[BOT Security-Wings]: ${YELLOW}Instalando o Docker...${NC}"
    (sudo apt-get install -y docker.io >/dev/null 2>&1) &
    pid=$!
    while kill -0 $pid 2>/dev/null; do
        echo -n -e "${GREEN}.${NC}"
        sleep 1
    done
    echo
		echo
		echo -e "${CYAN}[BOT Security-Wings]: ${YELLOW}Docker instalado com ${GREEN}sucesso! ${YELLOW}Prosseguindo para a proxima etapa...${NC}"
		echo
	fi
fi

echo -e "${CYAN}[BOT Security-Wings]:${YELLOW} Vou iniciar a configuração do Docker para criar um container para o banco de dados MySQL!${NC}"

sudo systemctl start docker
sudo systemctl enable docker
sudo docker pull mysql:5.7
sudo docker run -d -p 3306:3306 --name SecurityWingsBD -e "MYSQL_DATABASE=securityWings" -e "MYSQL_ROOT_PASSWORD=Urubu.100" mysql:5.7
echo -e "${CYAN}[BOT Security-Wings]: ${YELLOW}Estamos criando e configurando o container, aguarde 30 segundos por favor${NC}"
sudo docker start SecurityWingsBD

sleep 30


sudo docker exec -i SecurityWingsBD mysql -uroot -pUrubu.100 securityWings <<EOF
GRANT ALL PRIVILEGES ON *.* TO 'root'@'172.17.0.1' IDENTIFIED BY 'Urubu.100' WITH GRANT OPTION;
FLUSH PRIVILEGES;

CREATE TABLE Empresa(
    idEmpresa int primary key auto_increment,
    nome varchar(45),
    cnpj char(18) unique,
    telefone char(15)
);

CREATE TABLE Endereco(
    idEndereco int primary key auto_increment,
    cidade varchar(50),
    bairro varchar(50),
    uf char(2),
    rua varchar(50),
    cep char(9),
    complemento varchar(30),
    fkEmpresa int
);

CREATE TABLE usuario(
    idUsuario int primary key auto_increment,
    nome varchar(45),
    cpf char(14) unique,
    email varchar(255) UNIQUE,
    isAdmin boolean,
    isManager boolean,
    senha varchar(255),
    fkEmpresa int
);

CREATE TABLE ComputadorESpec(
    idComputador int primary key auto_increment,
    processadorModelo varchar(150),
    processadorNucleosFisicos int,
    processadorNucleosLogicos int,
    processadorFrequencia float,
    discoTotal int,
    ramTotal int,
    fkEmpresa int,
    fkUsuario int
);

CREATE TABLE Monitoramento(
    idMonitoramento int primary key auto_increment,
    processadorUso Double,
    ramUso double,
    discoUso double,
    bytesEnviados long,
    dataCaptura varchar(100),
    fkComputador int
);

CREATE TABLE parametrosDeAlerta (
    idEmpresa int,
	  enviado boolean,
    ramWarning varchar(50),
    ramDanger varchar(50),
    processadorWarning varchar(50),
    processadorDanger varchar(50),
    internetWarning varchar(50),
    internetDanger varchar(50),
    discoWarning varchar(50),
    discoDanger varchar(50),
    PRIMARY KEY (idEmpresa)
);

CREATE TABLE categoria (
    idCategoria int primary key auto_increment,
    categorias varchar(50)
);

CREATE TABLE processos (
    idProcesso int primary key auto_increment,
    nomeAmigavel varchar(50),
    processoName varchar(50),
    fkCategoria int
);

CREATE TABLE permissoes (
    idPermissao INT PRIMARY KEY AUTO_INCREMENT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fkEmpresa INT,
    fkProcesso INT,
    isAllowed BOOLEAN,
    isVisible BOOLEAN
);

GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'Urubu.100' WITH GRANT OPTION;
FLUSH PRIVILEGES;
EOF





