Feature: prueba

    @pruebas
    Scenario Outline: usuario con dato seguro en <banco dato seguro> solicita autenticacion en <banco>
      Given dato seguro en "<banco dato seguro>" solicita autenticacion en "<banco>"
      When el envia la peticion para ser autenticado
      Then la peticion debe ser <tipo de respuesta> en <banco autorizador>

    Examples:
      | banco dato seguro | banco | tipo de respuesta | banco autorizador |
      |rojo               |azul   |aprobada           |rojo               |
      |rojo               |verde  |aprobada           |rojo               |
      |rojo               |rojo   |aprobada           |rojo               |
      |azul               |azul   |aprobada           |azul               |
      |azul               |verde  |aprobada           |azul               |
      |azul               |rojo   |aprobada           |azul               |
      |verde              |azul   |aprobada           |verde              |
      |verde              |verde  |aprobada           |verde              |
      |verde              |rojo   |aprobada           |verde              |
      |rojo - azul        |azul   |aprobada           |azul               |
      |rojo - azul        |verde  |aprobada           |rojo               |
      |rojo - azul        |rojo   |aprobada           |rojo               |
      |rojo - verde       |azul   |aprobada           |rojo               |
      |rojo - verde       |verde  |aprobada           |verde              |
      |rojo - verde       |rojo   |aprobada           |rojo               |
      |azul - verde       |azul   |aprobada           |rojo               |
      |azul - verde       |verde  |aprobada           |verde              |
      |azul - verde       |rojo   |aprobada           |rojo               |
      |rojo - azul - verde|azul   |aprobada           |azul               |
      |rojo - azul - verde|verde  |aprobada           |verde              |
      |rojo - azul - verde|rojo   |aprobada           |rojo               |





