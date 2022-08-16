<div align="center">

# **Desafio 01 - IBM**

## Loja Tudo de bom

</div>
<br>

<div align="justify">

O desafio consiste na construção de uma API contendo CRUD completo para conexão com Banco de Dados (MySQL) para gerenciamento de transações.

</div>

<br>

### 📑 Arquitetura do Projeto

```
├──📁 ProjetoTDB
    ├──📁 .settings
    ├──📁 bin
    ├──📁 src
    |   └─ 📁 access
    |   |   └─📄DadosUsuario.java 
    |   |   └─📄Login.java 
    |   └─ 📁 cadastroCliente
    |   |   └─📄BDClientes.java  
    |   |   └─📄ConexaoBD.java 
    |   |   └─📄FormCliente.java   
    |   |
    |   └─ 📁 cadastroProduto
    |       └─📄BDProdutos.java  
    |       └─📄ConectaBD.java 
    |       └─📄FormProdutos.java 
    |    
    │                           
    ├─📄.classpath      
    ├─📄.project
    └─📄README.md      
```

### 🛣️ Rotas

*Clientes*

- Create: 
```
INSERT INTO clientes 
VALUES (null, nome_cliente, telefone, endereco, numero_end, ponto_ref);
```

- Read:
```
SELECT * FROM clientes;
```

*Produtos*

- Create:

```
INSERT INTO produtos
VALUES
(null, nome_produto, valor_unitario, qtd_produto, "flag_generico", "se_remedio");
```

- Read:
```
SELECT * from produtos;
 ```   