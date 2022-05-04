# **Guia de Contribuição**

Este é o guia de contribuição do SisREP. Você encontrará aqui alguns recursos para ajudá-lo a contribuir com o nosso projeto.

## **Índice**

### 1. [**Antes de contribuir**](#antes-de-você-contribuir)

> #### 1.1. [**Código de Conduta**](#código de conduta)
>
> #### 1.2. [**Legal**](#legal)

### 2. [**Pré-requisitos**](#pré-requisitos)

> #### 2.1. [**Pull Request title**](#pull-request-title)
>
> #### 2.2. [**Certificado de Origem do Desenvolvedor**](#developer-certificate-of-origin)

### 3. [**Como contribuir?**](#como-contribuir?)

> #### 3.1. [**Como você pode contribuir?**](#o que você pode contribuir?)
>
> #### 3.2. [**Diretrizes de contribuição**](#contribution-guideline)
>
> #### 3.3 [**Aprovação do Pull Request**](#pull-request's-approval)

### 4. [**Comunidade**](#comunidade)

## **Antes de você contribuir**

### **Código de Conduta**

Por favor, siga o [**Código de Conduta**](CODIGO_CONDUTA.md) em todas as suas interações com o projeto.

### **Legal**

- Nosso projeto é licenciado sobre [**ASF - Apache License**](./LICENSE), versão 2, sendo assim novos arquivos devem ter o cabeçalho ASL versào 2. Para obter mais informações consulte [**Apache license**](https://www.apache.org/licenses/LICENSE-2.0).

- Todas as contribuições estão sujeitas ao [**Developer Certificate of Origin (DCO)**](https://developercertificate.org).
  Quando você fizer o seu commit , use o `**-s** ` para incluir a linha de Signed-off-by no final da mensagem de commit.

## **Pre requisitos**

Confira os requisitos antes de contribuir com o nosso projeto:

### **Título do Pull Request**

Quando abrir um PR, adicione o título com um prefixo do tipo de mudança que você está contribuindo, por exemplo `feat:` para um novo requisito. Você pode ver outros tipos na seção [**O que você pode contribuir?**](#What-can-you-contribute?).

Sua solicitação de pull deve ficar assim:

```txt
feat: Adicionando um campo no componente de imagem para permitir o redimensionamento
```

Este formato é chamado de **conventional commits**. IEle nos ajuda a entender melhor cada uma das modificações que estão sendo feitas e nos ajuda a gerar melhor os _release notes_ e as _versions_.

Para mais informações leia as [**especificaṍes oficiais**](https://www.conventionalcommits.org/).

### **Developer Certificate of Origin - DCO**

This is a security layer for the project and for the developers. It is mandatory.

Follow one of these two methods to add DCO to your commits:

**1. Command line**
Follow the steps:
**Step 1:** Configure your local git environment adding the same name and e-mail configured at your GitHub account. It helps to sign commits manually during reviews and suggestions.

```
git config --global user.name “Name”
git config --global user.email “email@domain.com.br”
```

**Step 2:** Add the Signed-off-by line with the `'-s'` flag in the git commit command:

```
$ git commit -s -m "This is my commit message"
```

**2. GitHub website**
You can also manually sign your commits during GitHub reviews and suggestions, follow the steps below:

**Step 1:** When the commit changes box opens, manually type or paste your signature in the comment box, see the example:

```
Signed-off-by: Name < e-mail address >
```

For this method, your name and e-mail must be the same registered on your GitHub account.

## **How to contribute?**

See the guidelines to submit your changes.

### **How can you contribute?**

You can contibute with a new feature, bug fix, documentation and more, check out below:

- **feat:** A new feature (adding a new component, providing new variants for an existing component, etc.).
- **fix:** A bug fix (correcting a styling issue, addressing a bug in a component's API, etc.).
  When updating non-dev dependencies, mark your changes with the `fix:` type.
- **docs:** Documentation-only changes.
- **style:** Changes that do not affect the meaning of the code
  (whitespace, formatting, missing semicolons, etc). _Not_ to be used for CSS changes as those are meaningful changes, consider using `feat:` of `fix:` instead.
- **refactor:** A code change that neither fixes a bug nor adds a feature.
- **revert:** Reverts a previous commit.

### **Contribution Guideline**

Follow the Pull Request submission guidelines below:

**Step 1.** Search for issues and PRs that relate to your submission to avoid duplication;

**Step 2.** Make sure that the issue describes the problem you're fixing, or documents the design for the feature you'd like to add. Discussing the design upfront helps to ensure that we're ready to accept your work.

**Step 3.** git clone this repository;

**Step 4.** Make your changes in a new git branch.

**Step 5.** Commit your changes using a descriptive commit message, [**Signing all your commits**](https://github.com/ZupIT/beagle/blob/main/doc/contributing/dco_rules.md) and making sure to **include appropriate test cases**.=;

**Step 6.** Push your branch to GitHub;

**Step 7.** In GitHub, send a pull request to **`beagle-c4model:main`**;

### **Pull Request's approval**

After Beagle's team analyze your contribution, we may add some questions and suggestions, you should:

- Make the required updates.
- Re-run Beagle's test suites and CI workflows to ensure everything is still working properly.
- Rebase your branch and force push to your GitHub repository (this will update your Pull Request):

  ```shell
  git rebase main -i
  git push -f
  ```

## **Community**

- Do you have any question about Beagle? Let's chat in our [**forum**](https://forum.zup.com.br/).

**Thank you for your contribution!**

**Beagle Team** 😁
