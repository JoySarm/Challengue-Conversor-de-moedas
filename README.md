# Conversor de Moedas

Este é um projeto simples de um Conversor de Moedas desenvolvido em Java, com interface de linha de comando. Ele utiliza a API [ExchangeRate-API](https://www.exchangerate-api.com/) para obter taxas de câmbio em tempo real e a biblioteca `Gson` para processar as respostas JSON.

O projeto foi estruturado com base nos princípios de Orientação a Objetos, separando as responsabilidades de interação com o usuário e a lógica de negócio.

## 🚀 Funcionalidades

* Converte valores entre moedas (USD, ARS, BRL, COP).
* Obtém taxas de câmbio dinâmicas e atualizadas.
* Interface de menu interativa via console.
* Tratamento de erros para entradas inválidas do usuário e falhas na requisição da API.

## 💻 Tecnologias Utilizadas

* **Java 11+**
* **Gson:** Biblioteca para serialização e desserialização de objetos Java para JSON.
* **ExchangeRate-API:** Serviço de API para taxas de câmbio.

## 🛠️ Como Executar o Projeto

### Pré-requisitos

* JDK (Java Development Kit) 11 ou superior instalado.
* IntelliJ IDEA ou outra IDE com suporte a projetos Maven.
* Uma chave de API da [ExchangeRate-API](https://www.exchangerate-api.com/).

### Passo a Passo

1.  **Clone o Repositório**

    ```bash
    git clone [https://github.com/seu-usuario/conversor-de-moedas.git](https://github.com/seu-usuario/conversor-de-moedas.git)
    ```

2.  **Adicione a Dependência do Gson**

    Seu projeto usa Maven para gerenciar as dependências. Abra o arquivo `pom.xml` e adicione a seguinte dependência dentro da tag `<dependencies>`:

    ```xml
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.11.0</version>
    </dependency>
    ```

    Após salvar o `pom.xml`, o IntelliJ irá automaticamente baixar a biblioteca.

3.  **Configure a Chave da API**

    Abra o arquivo `PrincipalConversorMoedas.java` e substitua a string `coloque_sua_chave_aqui` pela sua chave de API pessoal da ExchangeRate-API.

    ```java
    String chaveApi = "coloque_sua_chave_aqui"; // Substitua pela sua chave
    ```

4.  **Execute a Aplicação**

    Execute a classe principal `PrincipalConversorMoedas.java`. O menu de opções será exibido no console, e você poderá interagir com o conversor.

## 📚 Estrutura do Projeto

O projeto segue uma arquitetura simples e organizada para separar as responsabilidades:

* `PrincipalConversorMoedas.java`: Contém o método `main`. É a **classe principal** que gerencia a interface com o usuário (exibe o menu, lê as entradas) e coordena a chamada para o conversor.
* `ConversorDeMoedas.java`: Uma **classe de serviço** que encapsula toda a lógica de negócio. Ela é responsável por construir a URL da API, fazer a requisição HTTP, processar o JSON e realizar o cálculo da conversão.

## ✒️ Autor

* Desenvolvido por **[Seu Nome]**