# Check Point 2 - Refatoração FiapDelivery

Atividade de Object-Oriented Programming (FIAP), prof. Ygor Anjos.
Aluno: Roberto Flaquer (RM 567348)

Refatoração do código legado do FiapDelivery aplicando encapsulamento, herança, associação, construtores, documentação e Clean Code.

## O que foi corrigido

| Problema do código legado | Solução |
|---|---|
| Nomes sem sentido (`pl`, `cap`, `p`, `s`, `muda`, `vai`) | Nomes claros (`placa`, `capacidadeKg`, `pesoKg`, `status`, `atualizarStatus`, `iniciarEntrega`) e classes em PascalCase |
| Atributos `public` | Atributos `private`, com getters e setters `protected` que validam os dados (por exemplo, capacidade negativa lança `IllegalArgumentException`) |
| Código duplicado em `caminhao` e `moto` | Classe abstrata `Veiculo` com os atributos comuns; `Caminhao` e `Moto` herdam dela |
| `Rota` só aceitava `Caminhao` | `Rota` se associa a `Veiculo` (abstração), então aceita `Caminhao`, `Moto` ou qualquer veículo futuro |
| Status do pacote como `String` livre | Enum `StatusPacote` (`PENDENTE`, `EM_TRANSITO`, `ENTREGUE`) |
| Objetos criados vazios e preenchidos depois | Construtores que já criam objetos válidos |

Regra extra: a `Rota` recusa um pacote mais pesado que a capacidade do veículo.

## Estrutura

```
src/br/com/fiapdelivery/
  model/   Veiculo, Caminhao, Moto, Pacote, StatusPacote, Rota
  main/    SistemaPrincipal
diagrama-fiapdelivery.png   diagrama de classes
```

## Como executar

Requer Java 17 ou superior.

```
mkdir bin
javac -d bin src/br/com/fiapdelivery/model/*.java src/br/com/fiapdelivery/main/*.java
java -cp bin br.com.fiapdelivery.main.SistemaPrincipal
```

Saída esperada:

```
Levando pacote BR999 no veiculo Caminhao ABC1234 (3 eixos)
Levando pacote BR999 no veiculo Moto XYZ9876 (com bau)
Status do pacote: EM_TRANSITO
Operacao bloqueada: A capacidade deve ser maior que zero.
Operacao bloqueada: O pacote (80.0kg) excede a capacidade do veiculo (20.0kg).
```

## Observação sobre o diagrama

Não consegui utilizar o Astah (o programa exige conta e eu não tenho). Por isso o diagrama de classes `diagrama-fiapdelivery.png` foi gerado por outro meio, seguindo a notação UML: generalização (seta com triângulo vazado) de `Caminhao` e `Moto` para `Veiculo`, e associações de `Rota` para `Veiculo` e `Pacote`.
