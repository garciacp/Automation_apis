Feature: Autenticacion Andes

@authentication @DatoSeguroRojo1
Scenario: usuario con dato seguro en rojo solicita producto en azul
    Given dato seguro en rojo solicita producto en azul
    When el envia la peticion para ser autenticado
    Then la peticion debe ser aprobada en rojo

@authentication @DatoSeguroRojo
Scenario: usuario con dato seguro en rojo solicita producto en verde
    Given dato seguro en rojo solicita producto en verde
    When el envia la peticion para ser autenticado
    Then la peticion debe ser aprobada en rojo

@authentication @DatoSeguroRojo
Scenario: usuario con dato seguro en rojo solicita producto en rojo
    Given dato seguro en rojo solicita producto en rojo
    When el envia la peticion para ser autenticado
    Then la peticion debe ser aprobada en rojo

@authentication @DatoSeguroRojo
Scenario: usuario con dato seguro en rojo y verde solicita producto en rojo
    Given dato seguro en rojo y verde solicita producto en rojo
    When el envia la peticion para ser autenticado
    Then la peticion debe ser aprobada en rojo

@authentication @DatoSeguroVerde
Scenario: usuario con dato seguro en rojo y verde solicita producto en verde
    Given dato seguro en rojo y verde solicita producto en verde
    When el envia la peticion para ser autenticado
    Then la peticion debe ser aprobada en verde

@authentication @DatoSeguroRojo
Scenario: usuario con dato seguro en rojo y verde solicita producto en azul
    Given dato seguro en rojo y verde solicita producto en azul
    When el envia la peticion para ser autenticado
    Then la peticion debe ser aprobada en rojo

@authentication @DatoSeguroRojo
Scenario: usuario con dato seguro en rojo y azul solicita producto en rojo
    Given dato seguro en rojo y azul solicita producto en rojo
    When el envia la peticion para ser autenticado
    Then la peticion debe ser aprobada en rojo

@authentication @DatoSeguroRojo
Scenario: usuario con dato seguro en rojo y azul solicita producto en verde
    Given dato seguro en rojo y azul solicita producto en verde
    When el envia la peticion para ser autenticado
    Then la peticion debe ser aprobada en rojo

@authentication @DatoSeguroAzul
 Scenario: usuario con dato seguro en rojo y azul solicita producto en azul
    Given dato seguro en rojo y azul solicita producto en azul
    When el envia la peticion para ser autenticado
    Then la peticion debe ser aprobada en azul

 @authentication @DatoSeguroRojo
 Scenario: usuario con dato seguro en rojo - azul y verde solicita producto en rojo
    Given dato seguro en rojo - azul y verde solicita producto en rojo
    When el envia la peticion para ser autenticado
    Then la peticion debe ser aprobada en rojo

 @authentication @DatoSeguroVerde
 Scenario: usuario con dato seguro en rojo - azul y verde solicita producto en verde
    Given dato seguro en rojo - azul y verde solicita producto en verde
    When el envia la peticion para ser autenticado
    Then la peticion debe ser aprobada en verde

 @authentication @DatoSeguroAzul
 Scenario: usuario con dato seguro en rojo - azul y verde solicita producto en azul
    Given dato seguro en rojo - azul y verde solicita producto en azul
    When el envia la peticion para ser autenticado
    Then la peticion debe ser aprobada en azul

@authentication @DatoSeguroVerde
Scenario: usuario con dato seguro en verde solicita producto en azul
    Given dato seguro en verde solicita producto en azul
    When el envia la peticion para ser autenticado
    Then la peticion debe ser aprobada en verde

@authentication @DatoSeguroVerde
Scenario: usuario con dato seguro en verde solicita producto en verde
    Given dato seguro en verde solicita producto en verde
    When el envia la peticion para ser autenticado
    Then la peticion debe ser aprobada en verde

@authentication @DatoSeguroVerde
Scenario: usuario con dato seguro en verde solicita producto en rojo
    Given dato seguro en verde solicita producto en rojo
    When el envia la peticion para ser autenticado
    Then la peticion debe ser aprobada en verde

@authentication @DatoSeguroAzul
Scenario: usuario con dato seguro en verde y azul solicita producto en rojo
    Given dato seguro en verde y azul solicita producto en rojo
    When el envia la peticion para ser autenticado
    Then la peticion debe ser aprobada en azul

@authentication @DatoSeguroVerde
Scenario: usuario con dato seguro en verde y azul solicita producto en verde
    Given dato seguro en verde y azul solicita producto en verde
    When el envia la peticion para ser autenticado
    Then la peticion debe ser aprobada en verde

@authentication @DatoSeguroAzul
Scenario: usuario con dato seguro en verde y azul solicita producto en azul
    Given dato seguro en verde y azul solicita producto en azul
    When el envia la peticion para ser autenticado
    Then la peticion debe ser aprobada en azul

@authentication @DatoSeguroAzul
Scenario: usuario con dato seguro en azul solicita producto en rojo
    Given dato seguro en azul solicita producto en rojo
    When el envia la peticion para ser autenticado
    Then la peticion debe ser aprobada en azul

@authentication @DatoSeguroAzul
Scenario: usuario con dato seguro en azul solicita producto en verde
    Given dato seguro en azul solicita producto en verde
    When el envia la peticion para ser autenticado
    Then la peticion debe ser aprobada en azul

@authentication @DatoSeguroAzul
Scenario: usuario con dato seguro en azul solicita producto en azul
    Given dato seguro en azul solicita producto en azul
    When el envia la peticion para ser autenticado
    Then la peticion debe ser aprobada en azul

@authentication @DatoCifin
Scenario: usuario sin dato seguro solicita producto
    Given usuario sin dato seguro solicita producto
    When el envia la peticion para ser autenticado
    Then la peticion debe ser aprobada en cifin