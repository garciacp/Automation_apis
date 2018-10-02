Feature: prueba

    @pruebas
    Scenario Outline: usuario con dato seguro en <banco dato seguro> solicita autenticacion en <banco>
      Given dato seguro en <banco dato seguro> solicita autenticacion en <banco>
      When el envia la peticion para ser autenticado
      Then la peticion debe ser aprobado en <banco autorizador>

    Examples:
      | banco dato seguro | banco | banco autorizador |
      |rojo               |azul   |rojo               |
      |rojo               |verde  |rojo               |
      |rojo               |rojo   |rojo               |
      |azul               |azul   |azul               |
      |azul               |verde  |azul               |
      |azul               |rojo   |azul               |
      |verde              |azul   |verde              |
      |verde              |verde  |verde              |
      |verde              |rojo   |verde              |
      |rojo - azul        |azul   |azul               |
      |rojo - azul        |verde  |rojo               |
      |rojo - azul        |rojo   |rojo               |
      |rojo - verde       |azul   |rojo               |
      |rojo - verde       |verde  |verde              |
      |rojo - verde       |rojo   |rojo               |
      |azul - verde       |azul   |rojo               |
      |azul - verde       |verde  |verde              |
      |azul - verde       |rojo   |rojo               |
      |rojo - azul - verde|azul   |azul               |
      |rojo - azul - verde|verde  |verde              |
      |rojo - azul - verde|rojo   |rojo               |





