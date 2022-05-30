# Sicredi Test - Votos Associados App

### Este projeto foi realizado para o teste de desenvolvedor Android da Sicredi. 

Foi desenvolvido em Kotlin utilizando os mais avançados recursos que a linguagem oferece como arquitetura MVVM e Coroutines, como também, os recursos do framework Retrofit para comunicação com API Rest e recursos das bibliotecas Jetpack como Databinding.

Com base nos requerimentos e instruções fornecidas para desenvolvimento foi implementado as seguintes funcionalidades:
- Busca por CPF para validação de votação;
- Construção de tela via Json, fornecido via API.


## Começando
A maneira mais fácil de visualizar o aplicativo em ação é baixando e instalando o [apk >>][apk-download-url]

Se deseja visualizar o código e os detalhes de implementação você pode utilizar o Android Studio:
#### Pré-requisitos
 - Android SDK v31
 - Android Studio 3.5+

Para baixar o projeto:
1. **Clone o repositório**
   ```console
   git clone https://github.com/rodrigobn/test-sicred
   ```
2. **Abra o projeto no Android Studio:**
   - No menu do Android Studio, clique em `File > Open`.
   - Como alternativa, na tela "Bem-vindo", clique em > `Open an existing Android Studio project`.
   - Selecione a pasta do projeto e clique em OK.

## Arquitetura
Foi utilizado **MVVM** _(Model-View-ViewModel)_. Este Pattern suporta ligação bidirecional entre View e ViewModel, com isto é possível termos propagação automática de mudanças e LiveData (Objeto Observável) é utilizado para essa finalidade. 


<img src="https://i.imgur.com/mGNkir2.png" />


Como pode ser visto na imagem anterior, a arquitetura divide-se em três camadas:

1. **View** - São Activity e Fragment, ou seja, é onde fica os componentes de interface que o usuário interage. Essa camada se comunica exclusivamente com a ViewModel.

2. **ViewModel** - É a camada responsável por expor métodos, comandos e propriedades que mantém o estado da View, ela se comunica com a camada de dados e retorna resultados de uma ação por meio de objetos observáveis.

3. **Model** - É a camada responsável pela regra de negócio da aplicação, persistência de dados e comunicação com serviços externos. Ela exclusivamente responde comandos solicitados pela ViewModel.

## Principais Bibliotecas Utilizadas

- [Koin](https://insert-koin.io/) Utilizada para Injeção de Depência (DI), ela cria as instâncias em tempo de execução.
- [Android Material Compontes](https://material.io/components) Possibilita a utilização dos mais novos componentes do Material Design.
- [Retrofit](https://square.github.io/retrofit/) Client HTTP. Utilizada para fazer comunicação com API Rest.
- [Koleton](https://github.com/ericktijerou/koleton) Fornece uma maneira fácil de mostrar o esqueleto de qualquer visualização, útil para estados de loading.
- [Valifi](https://github.com/mlykotom/valifi) Usada para validação de formulário. Possui suporte a databinding.

---
[apk-download]: https://img.shields.io/badge/download%20apk-DEBUG-blue.svg?style=for-the-badge&logo=android
[apk-download-url]: https://github.com/rodrigobn/test-sicredi/releases/download/1.0.0/sicredi-test_v1.0.0-debug.apk
