Aqui você vai encontrar todas as informações básicas sobre o projeto SisPRE - Sistema de Reaproveitamento de Disciplinas da UPE.

## **O que é o Reaproveitamento de Disciplinas?**

---

A resolução [CEPE Nº 035/2016](../docs/assets/resolucao_035_2016.pdf) é o insturmento que normatiza o Processo de Reaproveitamento de Estudos (PRE) nos cursos de graduação no âmbito da Universidade de Pernambuco. Este instrumento de referência tem como base o parecer do CNE/CES(67/2003) e atualiza a resolução CEPE 038/2015.e visa estimular práticas de estudos independentes em busca de uma autonomia intelectual e profissional progressiva do discente.

## **O que é o SisPRE?**

---

SisPRE é uma iniciativa que busca a construção de uma solução de sistema, com o objetivo de suportar e guiar a operacionalização, monitoramento e publicação dos resultados da aplicação do instrumento de Reaproveitamento de Disciplinas no âmbito da UPE Campus Garanhuns.

Será através dela que os discentes, docentes, coordenadores de curso, secretaria e gestores poderão preencher, validar e consultar os processos de Reaproveitamento de Disciplinas que foram executados no âmbito do campus compartilhando o corpo de conhecimento em torno deste instrumento, otimizando e acelerando suas tramitações.

## **Como surgiu o SisPRE?**

---

O Departamento de Computação da Universidade de Pernambuco Campus Garanhuns oferece à comunidade dois cursos de computação: Licenciatura em Computação e Bacharelado em Engenharia de Software. Existe uma visão na condução destes cursos em sempre alinhar as vivências práticas e teóricas através da construção de projetos colaborativos nos moldes de fábrica de software visando o próprio campus como cliente potencial.

Este tipo de abordagem torna possível propiciar aos alunos, em diferentes estágios de seus cursos, a vivência colaborativa de projetos de desenvolvimento de um produto de software. Além de aproximar os discentes em formação da vivência real e aplicada dos conhecimentos, contribuímos com o processo de melhoria da excelência institucional.

Por esta razão, acreditamos que a iniciativa de costrução do SisPRE tem o potencial de poder propiciar o estreitamento entre os elos de ensino, pesquisa e extensão na vivência dos docentes e discentes dirata ou indiretamente envolvidos.

{{% alert color="warning" %}}
Este sistema é uma iniciativa do Multicampi Garanhuns de operacionalizar a normatização do SisPRE oportunizando também aos discentes a vivência de construção de um produto em todas as etapas do ciclo de desenvolvimento de um software real.
{{% /alert %}}

## **Documentaçao da Arquitetura**

---

O principal objetivo deste site é manter e registrar a arquitetura do sistema SisPRE. Documentar a arquitetura de um sistema de software compreende um esforço que exige tempo, conhecimento de ferramentas e técnicas de diagramação. O principal desafio é contemplar uma estratégia que permita que as informações arquiteturais sejam simples, objetivas e minimamente burocráticas de se manter.

Aqui nosso principal objetivo é tornar o processo de manter o registro das informações arquiteturais utilizando uma abordagem que nos permita fugir de dois cenários reais das documentações na engenharia de software:

- **Cenário 1:** Documentações complexas, confusas, obsoletas, que perdem seu propósito. Um investimento de esforço para algo que muitas vezes não é utilizado.

- **Cenário 2:** Documentações que sofrem com falhas, pouca informação e muita erosão.

A vivência de quaisquer um destes dois cenários não é benéfica para qualquer pessoa que trabalhe no ciclo de vida deste sistema.

A arquitetura do projeto tem como principal objetivo melhorar a experiência do usuário, por este motivo é essencial documentá-la, porque ela responde a várias perguntas, por exemplo:

- Como os componentes do PAD se integram, seja internamente ou com outros sistemas?
- Como consigo escalá-lo?
- Como garantir sua segurança?

Pensando nisso, o time do PAD-UPE criou uma visualização da nossa arquitetura utilizando uma abordagem mais mais simples: o C4 Model.

## **O que é o C4Model?**

---

Proposto po Simon Brown o C4 Model é baseado no modelo 4+1 e o UML. Ele foca em resolver problemas da documentação de arquitetura, com base em quatro tipos de diagramas que atendem a diferentes públicos alvo com diferentes níveis de detalhe.
A grande ideia é trazer mais clareza para o projeto utilizando níveis diferentes de diagramas que vão expressar, a cada nível mais interno, um grau maior de detalhe que o do nível anterior.
