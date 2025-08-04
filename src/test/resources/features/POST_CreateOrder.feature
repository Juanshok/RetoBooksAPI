#language: es
Característica: Creacion exitosa de orden

  Antecedentes:
    Dado que se realiza la peticion para generar el token
      | clientName           | clientEmail              |
      | Juan123452 | Pablo1234@qa.com |
    Entonces valida que el codigo de status sea 201

  @CreacionOrdenExitosa
  Esquema del escenario: Creacion de Orden
    Cuando se envia la peticion de creacion de libros
      | bookId   | customerName   |
      | <bookId> | <customerName> |
    Entonces valida que el codigo de status sea 201
    Ejemplos:
      | bookId | customerName |
      | 1      | Juanpa       |