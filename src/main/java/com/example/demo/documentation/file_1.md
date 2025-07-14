

1. Descrição geral
2. Modelo de dados atualizado
3. Regras de negócio
4. Validações
5. Exceções e considerações técnicas




---

📄 Documento Técnico – Modelo de Limite por Proposta

1. 🧾 Descrição Geral

O Limite por Proposta define um valor financeiro disponível para ser vinculado a propostas de determinado cliente. Cada limite possui regras específicas de utilização, controle de saldo, validade, compartilhamento e status.


---

2. 🧱 Modelo de Dados

Campo	Tipo	Descrição

id	UUID / Long	Identificador único do limite
clientId	UUID / Long	Identificador do cliente (chave estrangeira)
approvalDate	Date	Data de aprovação do limite
validityDate	Date	Data de validade do limite
value	BigDecimal	Valor total aprovado para o limite
usedValue	BigDecimal	Valor atualmente utilizado (soma das propostas vinculadas)
availableValue	BigDecimal	Valor disponível (calculado: value - usedValue)
scenario	String	Cenário do limite (ex: “Garantia”, “Crédito”)
modality	String	Modalidade (ex: “Operação direta”, “Repasse”)
status	Enum (ATIVO, BLOQUEADO, EXPIRADO, ENCERRADO)	Estado atual do limite
isShareable	Boolean	Flag que define se o limite pode ser compartilhado por mais de uma proposta
createdDate	DateTime	Data de criação
createdBy	String	ID do sistema ou serviço que criou
createdByUser	String	Nome/ID do usuário que criou
lastModifiedDate	DateTime	Última data de modificação
lastModifiedBy	String	ID do sistema ou serviço que modificou
lastModifiedByUser	String	Nome/ID do usuário que modificou



---

3. 📜 Regras de Negócio

Um cliente pode possuir múltiplos limites ativos simultaneamente.

Cada proposta pode usar apenas um limite.

Um limite pode ser vinculado a múltiplas propostas, desde que:

O campo isShareable esteja true.

Haja saldo disponível (availableValue >= valor da proposta).


O vínculo de proposta ao limite deve respeitar o mesmo prazo de validade (validityDate) da proposta.

As baixas (utilizações) de limite devem atualizar imediatamente os campos usedValue e availableValue.

Um limite deve ser considerado indisponível se:

O status for BLOQUEADO, EXPIRADO ou ENCERRADO.

Não houver valor disponível (availableValue <= 0).




---

4. 🔒 Validações ao Vincular Proposta

Validar se o limite.status == ATIVO.

Validar se availableValue >= valor da proposta.

Validar se validityDate é igual à data de validade da proposta.

Validar que, se isShareable == false, o limite ainda não esteja vinculado a outra proposta.

Impedir reuso de limite caso ele não esteja dentro do prazo ou ativo.



---

5. 📘 Auditoria e Histórico

Cada movimentação de valor (reserva, uso, liberação) deve gerar um registro de histórico, contendo:

ID da proposta

Data da movimentação

Tipo da movimentação (RESERVA, USO, LIBERAÇÃO, CANCELAMENTO)

Valor movimentado

Usuário responsável




---

6. 🧠 Considerações Técnicas

Os valores usedValue e availableValue podem ser armazenados para performance, mas devem ser recalculados em rotinas de consistência periódicas.

A verificação de uso compartilhado deve ser baseada tanto na flag isShareable quanto no status e saldo.

A expiração de limite pode ser automatizada com job que altera o status para EXPIRADO quando validityDate < hoje.


