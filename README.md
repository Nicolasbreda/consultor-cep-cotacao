# Consultor CEP e Cotação

Aplicação de terminal desenvolvida em Java que consome APIs REST públicas para consultar endereços a partir de um CEP (API ViaCEP) e a cotação do dólar do dia (API do Banco Central do Brasil).

## Funcionalidades
- Consulta de endereço completo a partir de um CEP
- Consulta da cotação atual do dólar
- Tratamento de erros de conexão e dados inválidos
- Parsing de respostas JSON sem bibliotecas externas

## Tecnologias
- Java 21
- HttpClient (nativo do Java)
- APIs REST (ViaCEP e Banco Central do Brasil)

## Objetivo
Projeto desenvolvido para praticar consumo de APIs externas, tratamento de JSON e organização de código em camadas (model/service).
