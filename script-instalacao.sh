#!/bin/bash

echo "---------------------------------------------------------------"
echo "Atualizando o sistema operacional"
sudo apt update && sudo apt upgrade
echo "---------------------------------------------------------------"

echo "Verificando se o NodeJS está instalado"
node -v #verifica versao atual do java
if [ $? = 0 ]; #se retorno for igual a 0
        then #entao,
                echo "Node instalado" #print no terminal
		echo "Prosseguindo para proxima etapa ..."
		echo "---------------------------------------------------------------"

        else #se nao,
                echo "NodeJS não instalado" #print no terminal
                echo "gostaria de instalar o NodeJS ? [s/n]" #print no terminal

                read get #variável que guarda resposta do usuário

        if [ \"$get\" == \"s\" ]; #se retorno for igual a s
                then #entao
		curl -fsSL https://deb.nodesource.com/setup_lts.x | sudo -E bash -
                sudo apt-get install -y nodejs #executa instalacao do nodejs
        fi #fecha o 2º if
fi #fecha o 1º if

echo "Verificando se o java está instalado"
java --version #verifica versao atual do java
if [ $? = 0 ]; #se retorno for igual a 0
	then #entao,
		echo "java instalado" #print no terminal
		echo "Prosseguindo para a proxima etapa..."
		echo "---------------------------------------------------------------"
	else #se nao,
		echo "java não instalado" #print no terminal
		echo "gostaria de instalar o java? [s/n]" #print no terminal

		read get #variável que guarda resposta do usuário

	if [ \"$get\" == \"s\" ]; #se retorno for igual a s
		then #entao
		sudo apt install openjdk-17-jre -y #executa instalacao do java
	fi #fecha o 2º if
fi #fecha o 1º if

echo "Verificando se o banco de dados MySQL está instalado"
mysql --version #Verifica a versão do mysql
if [ $? = 0 ]; #se retorno for igual a 0
	then #entao,
		echo "MySQL Instalado" #print no terminal
		echo "---------------------------FINALIZANDO-------------------------"
	else #se nao,
		echo "MySQL não instalado" #print no terminal
		echo "gostaria de instalar o MySQL? [s/n]" #print no terminal

		read get #variável que guarda resposta do usuário

	if [ \"$get\" == \"s\" ]; #se retorno for igual a s

		then #entao
		sudo apt install mysql-server #executa instalacao do java
	fi #fecha o 2º if
fi #fecha o 1º if

echo "---------------------------------------------------------------"
echo "----------------------CONFIGURANDO MYSQL-----------------------"
echo "---------------------------------------------------------------"

echo "---------------------------------------------------------------"
echo "-------------------Iniciando Serviço MySQL---------------------"
echo "------------Insira a senha do seu usuario do S.O---------------"
echo "---------------------------------------------------------------"

systemctl start mysql.service

echo "---------------------------------------------------------------"
echo "---------------------Verificando Status------------------------"
echo "---------------------------------------------------------------"

systemctl status mysql.service

echo "---------------------------------------------------------------"
echo "------------Iniciando configurações de segurança---------------"
echo "-----------------*****LEIA COM ATENÇÃO*****--------------------"
echo "---------------------------------------------------------------"

echo "------------------------RECOMENDAÇÕES--------------------------"
echo "-------------1° configuração colocar a resposta 'y'------------"
echo "-------------2° configuração colocar a resposta '0'------------"
echo "-------------3° configuração colocar a resposta 'n'------------"
echo "-------------4° configuração colocar a resposta 'y'------------"
echo "-------------5° configuração colocar a resposta 'n'------------"
echo "-------------6° configuração colocar a resposta 'y'------------"
echo "---------------------------------------------------------------"

sudo mysql_secure_installation

echo "---------------------------------------------------------------"
echo "-------------CONECTANDO AO MYSQL E CRIANDO TABELAS-------------"
echo "---------------------------------------------------------------"

sudo mysqladmin -u root password 'urubu100'

sudo mysql -u root -p"urubu100" -e "CREATE DATABASE IF NOT EXISTS securityWings;"

sudo mysql -u root -p"urubu100" securityWings -e "CREATE DATABASE securityWings;

USE securityWings;

CREATE TABLE Empresa(
    idEmpresa int primary key auto_increment,
    nome varchar(45),
    cnpj char(14) unique,
    email varchar(255),
    telefone char(11),
    senha varchar(255)
);

CREATE TABLE Endereco(
    idEndereco int primary key auto_increment,
    cidade varchar(50),
    bairro varchar(50),
    uf char(2),
    rua varchar(50),
    cep char(8),
    complemento varchar(30),
    fkEmpresa int,
    constraint fk_endereco_empresa foreign key (fkEmpresa) references Empresa(idEmpresa)
);

CREATE TABLE usuario(
    idUsuario int primary key auto_increment,
    nome varchar(45),
    cpf char(11)unique,
    email varchar(255) UNIQUE,
    isAdmin boolean,
    isManager boolean,
    senha varchar(255),
    fkEmpresa int,
    constraint fk_empresa_funcionario foreign key (fkEmpresa) references Empresa(idEmpresa)
);

CREATE TABLE ComputadorESpec(
    idComputador int primary key auto_increment,
    processadorModelo varchar(45),
    processadorNucleosFisicos int,
    processadorNucleosLógicos int,
    processadorFrequencia float,
    discoTotal int,
    ramTotal int,
    fkEmpresa int,
    fkUsuario int,
    constraint fkEmpresa foreign key (fkEmpresa) references Empresa(idEmpresa),
    constraint fkUsuarioComp foreign key(fkUsuario) references usuario(idUsuario)
);


CREATE TABLE Monitoramento(
    idMonitoramento int primary key auto_increment,
    processadorUso float,
    ramUtilizada float,
    ramDisponivel float,
    ramUso float,
    discoUso float,
    bytesEnviados long,
    bytesRecebidos long,
    dataCaptura varchar(100),
    fkComputador int,
    fkUsuario int,
    constraint fkComputadorMon foreign key (fkComputador) references ComputadorESpec(idComputador),
    constraint fkUsuarioMon foreign key(fkUsuario) references usuario(idUsuario)
);"


