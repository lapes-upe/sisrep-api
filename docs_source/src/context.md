## **Documentação da Arquitetura**

---

Documentar a arquitetura de um sistema de software compreende um esforço que exige tempo, conhecimento de ferramentas e técnicas de diagramação. O principal desafio é contemplar uma estratégia que permita que as informações arquiteturais sejam simples, objetivas e minimamente burocráticas de se manter.

Aqui, nosso principal objetivo é tornar o registro das informações arquiteturais atualizados e disponíveis utilizando uma abordagem que nos permita fugir de dois cenários reais das documentações na engenharia de software:

- **Cenário 1:** Documentações complexas, confusas, obsoletas, que perdem seu propósito. Um investimento de esforço para algo que muitas vezes não é utilizado.

- **Cenário 2:** Documentações que sofrem com falhas, pouca informação e muita erosão.

A vivência de quaisquer um destes dois cenários não é benéfica para qualquer pessoa que trabalhe no ciclo de vida deste sistema.

A arquitetura do projeto tem como principal objetivo melhorar a experiência do usuário, por este motivo é essencial documentá-la, porque ela responde a várias perguntas, por exemplo:

- Como os componentes do SisREP se integram, seja internamente ou com outros sistemas?
- Como consigo escalá-lo?
- Como garantir sua segurança?
- Como implemento um novo caso de uso?
- Como garanto a autenticação e a autorização?
- Quais restrições arquiteturais devo seguir na hora de implementar?
- Quais padrões de nomenclatura devo utilizar?

Pensando nisso, criamos uma visualização da nossa arquitetura utilizando uma abordagem mais mais simples: o C4Model.

## **O registro arquitetural do SisPRE**

---

Ao longo das páginas deste site, você poderá analisar em detalhes como a arquitetura do SisPRE está projetada, suas tecnologias, convenções, padrões adotados e restrições.
Aqui ela é expressa por camadas com base no C4 Model proposto por Simon Brown. Cada camada é focada diferentes públicos alvo, em suas diferentes necessidades e níveis de detalhe, a se saber:

- Camada 1: apresenta o contexto geral e propósito do sistema da perspectiva a um usuário técnico e/ou não técnico seja ele interno ou externo à equipe de desenvolvimento.

- Camada 2: apresenta o sistema do ponto de vista de seus containers e relacionamentos a um usuário técnico interno ou externo à equipe de desenvolvimento, com capacidade de entender tecnicamente os aspectos relacionados às decisões direcionadas a suas tecnologias, linguagens, frameworks, entre outros.

- Camada 3: com o foco no publico alvo mais técnico, aqui o sistema é apresentado aos desenvolvedores e engenheiros de software com um alto grau de entendimento técnico de todas as restrições arquiteturais impostas. Aqui todos os componentes, restrições, convenções e regras arquiteturais necessárias para a implementação aderente a esta arquitetura s"ao explanadas e detalhadas com o nível de detalhe que permita ao usuário implementar um caso de uso como um guia arquitetural.

\*Camada 4: apresenta o sistema com o nível mais denso em detalhes e contempla artefatos uml com base na abordagem de visões arquiteturais 4+1 de Philippe Kruchten

A abordagem do C4Model é uma otima estratégia para trazer mais clareza e expressar, a cada nível mais interno, um grau maior de detalhe e informações que o respectivo nível anterior.

Nossa construção foi realizada com o suporte da ferramenta [**c4builder**](https://adrianvlupu.github.io/C4-Builder/).
