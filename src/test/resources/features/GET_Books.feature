#language: es
Característica: Obtener Libros

  Antecedentes:
    Dado que se realiza la peticion para generar el token
      | clientName | clientEmail      |
      | Juan12345232211 | Pablo123324111@qa.com |
    Entonces valida que el codigo de status sea 201

  @ObtenerLibrosExitoso
  Escenario: Obtener libros exitoso
    Cuando se envia la peticion para obtener los libros
    Entonces valida que el codigo de status sea 200