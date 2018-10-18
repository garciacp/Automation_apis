Feature: Autenticacion
  Para validar la autenticacion de un cliente en un banco del grupo aval
  yo como cliente que poseo productos en alguno de los bancos del grupo aval
  Quiero ser autenticado en un portal de los bancos del grupo aval

  @Autenticacion
  Scenario Outline: un usuario/a con dato seguro Aval solicita ser autenticado/a en un banco Aval
    Given un usuario con datos seguro en <dato seguro> solicita autenticacion en el banco <banco>
    When el envia la peticion para ser autenticado
    Then La peticion debe ser contestada por el <banco autorizador>

    Examples:
      | dato seguro         | banco | banco autorizador |
      | rojo                | azul  | rojo              |
      | rojo                | verde | rojo              |
      | rojo                | rojo  | rojo              |
      | azul                | azul  | azul              |
      | azul                | verde | azul              |
      | azul                | rojo  | azul              |
      | verde               | azul  | verde             |
      | verde               | verde | verde             |
      | verde               | rojo  | verde             |
      | rojo - azul         | azul  | azul              |
      | rojo - azul         | verde | rojo              |
      | rojo - azul         | rojo  | rojo              |
      | rojo - verde        | azul  | rojo              |
      | rojo - verde        | verde | verde             |
      | rojo - verde        | rojo  | rojo              |
#      | azul - verde        | azul  | rojo              |
#      | azul - verde        | verde | verde             |
#      | azul - verde        | rojo  | rojo              |
      | rojo - azul - verde | azul  | azul              |
#      | rojo - azul - verde | verde | verde             |


  @datacredito
  Scenario Outline: un usuario/a registrado en datacredito desea ser validado en un banco aval
    Given un usuario que esta registrado en datacredito solicita validacion en el banco <banco>
    When el envia la peticion para ser autenticado
    Then La peticion debe ser contestada por datacredito

    Examples:
      | banco |
      | azul  |
      | verde |


  @cifin
  Scenario Outline: un usuario/a registrado en cifin desea ser validado en un banco aval
    Given un usuario que esta registrado en cifin solicita validacion en el banco <banco>
    When el envia la peticion para ser autenticado
    Then La peticion debe ser contestada por cifin

    Examples:
      | banco |
      | azul  |
      | verde |

