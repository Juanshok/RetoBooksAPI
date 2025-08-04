#language: es
Característica: Obtener Ordenes

  Antecedentes:
    Dado que se realiza la peticion para generar el token
      | clientName | clientEmail      |
      | Juan123452322 | Pablo1233241@qa.com |
    Entonces valida que el codigo de status sea 201

  @ObtenerOrdenesExitoso
  Escenario: Obtener ordenes exitoso
    Cuando se envia la peticion para obtener ordenes
    Entonces valida que el codigo de status sea 200