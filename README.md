# 🏥 API de Controle de Produção Clínica

Este projeto é uma **API REST desenvolvida em Java com Spring Boot**, criada para auxiliar no **controle de produção de profissionais de uma clínica**, onde o pagamento é realizado com base nos atendimentos realizados.

A aplicação substitui o controle manual feito em planilhas, organizando dados como pacientes atendidos, tempo de sessão e regras específicas de produção.

---

## 🎯 Contexto do Projeto

Na clínica:
- Os profissionais recebem **por produção** (pacientes atendidos)
- Cada atendimento possui:
  - Data
  - Dia da semana
  - Nome do paciente
  - Tempo de atendimento
  - Indicação se o paciente é **TEA** ou não
- Regras:
  - Pacientes **TEA** → sessão de **1 hora**
  - Demais pacientes → sessão de **40 minutos**
  - Quando não há atendimento, **não há pagamento**

Essa API foi criada para organizar essas informações de forma estruturada, segura e escalável.

---

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Maven**
- **Docker** (em evolução)
- **VS Code**

---

## 🧱 Arquitetura

- API REST
- Separação por camadas:
  - Controller
  - Service
  - Repository
  - Entity
- Persistência de dados com JPA / Hibernate
- Banco de dados relacional (MySQL)

---

## 📌 Funcionalidades (em desenvolvimento)

- Cadastro de atendimentos
- Identificação automática do tempo de sessão (TEA ou não)
- Registro de produção por profissional
- Consulta de atendimentos por data
- Base para cálculo de produção/pagamento
- Preparação para microsserviços e containers (Docker)

---

## 🛠️ Pré-requisitos

Antes de executar o projeto, é necessário ter instalado:

- Java 21
- Maven
- MySQL
- VS Code (ou IDE de sua preferência)
- Git

---

## ⚙️ Configuração do Banco de Dados

Crie um banco no MySQL:

```sql
CREATE DATABASE controle_producao;
