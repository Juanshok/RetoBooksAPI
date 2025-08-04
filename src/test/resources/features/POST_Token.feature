#language: es
Característica: Generar token

  @GenerarTokenExitoso
  Esquema del escenario: Generar token exitoso
    Dado que se realiza la peticion para generar el token
      | clientName   | clientEmail   |
      | <clientName> | <clientEmail> |
    Entonces valida que el codigo de status sea 201
    Ejemplos:
      | clientName | clientEmail |
      | JuanRuizP   | Juan09@qa.com |