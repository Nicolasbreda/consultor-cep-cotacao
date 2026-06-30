# Consultor de CEP e Cotação do Dólar

Aplicação de terminal desenvolvida em Java que consome APIs REST públicas para consultar endereços a partir de um CEP e a cotação do dólar em uma data específica.

## Funcionalidades

- Consulta de endereço completo a partir de um CEP (logradouro, bairro, cidade, UF)
- Consulta da cotação de compra e venda do dólar em uma data informada
- Tratamento de erros para CEP inválido e datas sem cotação disponível
- Parsing de JSON com a biblioteca Gson

## Tecnologias utilizadas

- **Java 21**
- **HttpClient** (nativo do Java, para consumo de APIs REST)
- **Gson** (biblioteca do Google para parsing de JSON)
- **API ViaCEP** — consulta de endereços
- **API PTAX (Banco Central do Brasil)** — cotação do dólar
