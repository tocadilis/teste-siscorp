# teste-siscorp


POST: /api/produtos/
insere um produto no banco de dados em memória (H2)

POST: /api/produtos/banco-jms
insere um produto no banco de dados em memória (H2) e também na fila, que por sua vez altera o nome do produto (update)

GET: /api/produtos/
retorna todos os produtos cadastrados

GET: /api/produtos/{id}
retorna o produto de acordo com o id informado

DELETE: /api/produtos/{id}
deleta o produto de acordo com o id informado

GET: /api/produtos/findAllPageable
retorna uma lista paginada de produtos 
