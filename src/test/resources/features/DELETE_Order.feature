#language: es
Característica: Eliminar orden

  Antecedentes:
    Dado que se realiza la peticion para generar el token
      | clientName | clientEmail   |
      | Juan1234526  | Pablo135@qa.com |
    Entonces valida que el codigo de status sea 201

  @EliminarOrdenExitoso
  Esquema del escenario: Eliminar orden exitoso
    Cuando se envia la peticion de eliminar orden
      | orderId   |
      | <orderId> |
    Entonces valida que el codigo de status sea 201
    Ejemplos:
      | orderId               |
      | hh30Nbp9hXRmyF1sc0YKe |