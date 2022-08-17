<div align="center">

# **Desafio 01 - IBM**

## Loja Tudo de bom

</div>
<br>

<div align="justify">

O desafio consiste na construção de uma API contendo CRUD completo para conexão com Banco de Dados (MySQL) para gerenciamento de transações.

</div>

<br>

## 📑 Arquitetura do Projeto

```
├──📁 ProjetoTDB
    ├──📁 .settings
    ├──📁 bin
    ├──📁 src
    |   └─ 📁 access
    |   |   └─📄DBLogin.java 
    |   |   └─📄ConectaDB.java 
    |   |   └─📄FormLogin.java 
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

## 🛣️ Rotas
<br>

### *Clientes*
<br>

- Create: 
```
INSERT INTO clientes 
VALUES (null, nome_cliente, telefone, endereco, numero_end, ponto_ref, compras_cliente);
```

- Read:
```
SELECT * FROM clientes;
```

- Update:
```
UPDATE clientes SET nome_cliente = nome_cliente, telefone = telefone, endereco = endereco, numero_end = numero_end, ponto_ref = ponto_ref
WHERE id_cliente = id_cliente
```

- Delete:
```
DELETE FROM clientes WHERE id_cliente = id_cliente;
```
<br>

### *Produtos*
<br>

- Create:

```
INSERT INTO produtos
VALUES
(null, nome_produto, valor_unitario, qtd_produto, flag_generico, se_remedio, valor_desconto, valor_final);
```

- Read:
```
SELECT * from produtos;
 ```   

 - Update:
 ```
 UPDATE produtos SET nome_produto=nome_produto, valor_unitario= valor_unitario, qtd_produto=qtd_produto, flag_generico=flag_generico, se_remedio=se_remedio, valor_final
 WHERE id_produto=id_produto;
 ```

 - Delete:
 ```
 DELETE FROM produtos WHERE id_produto=id_produto;
 ```

- Controle de estoque:
```
SELECT qtd_produto FROM produtos WHERE nome_produto=nome_produto;
```
<br>

### *Login*
<br>

- Create
```
INSERT INTO login 
VALUES (usuario, senha);
```

- Read
```
SELECT * FROM login WHERE usuario = usuario AND senha = senha;
```

- Update
```
UPDATE login SET senha = senha WHERE usuario = usuario;
```

- Delete
```
DELETE FROM login WHERE id = id ;
```
