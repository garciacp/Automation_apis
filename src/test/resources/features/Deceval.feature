Feature: Firma Pagare Deceval
  #Caso 1
  @Deceval @ConsultaPagare @Basico
    Scenario: un usuaro registrado desea visualizar un pagare sin que sea pdf
      Given el usuario solicita consultar pagare sin pdf
      When se envia la peticion de consulta sin pdf a deceval
      Then el servicio retorna pagare sin pdf

  #Caso 2
  @Deceval @ConsultaPagare @Basico
    Scenario: un usuario registrado desea consultar un pagare en deceval en formato pdf
      Given el usuario solicita consultar pagare con pdf
      When se envia la peticion de consulta con pdf a deceval
      Then el servicio retorna pagare con pdf

  #Caso 3
  @Deceval @CrearOtorgante @Basico
    Scenario: un usuario desea crear un nuevo otorgante en deceval
      Given usuario nuevo solicita crear otorgante
      When el usuario envia la peticion para crear otorgante
      Then la solicitud de creacion nuevo otorgante debe ser aprobada
      And si el otorgante ya existe, se actualiza la informacion del mismo

  #Caso 4
  @Deceval @Crearpagare @Basico
    Scenario: un usuario desea crear un pagare en deceval
      Given el usuario solicita crear pagare
      When se envia la peticion para crear pagare en deceval
      Then el resultado de la solicitud de creacion de pagare debe ser aprobada
  #Caso 5
  @Deceval @Firmarpagare @Basico
    Scenario: un usuario desea firmar un pagare en deceval
      Given usuario necesita firmar el pagare creado anteriomente
      When envia la peticion para firmar pagare en deceval
      Then la firma debe ser aprobada

  #Historias de usuario para creacion otorgante
  #Caso 6
  @Deceval @CrearOtorgante
    Scenario: un usuario desea crear nuevo otorgante, pero envia fecha transaccion incorrecta
        Given el usuario solicita crear nuevo otorgante con fecha transaccion incorrecta
        When usuario envia solicitud crear nuevo otorgante
        Then la solicitud es rechazada por fecha de transaccion incorrecta
  #Caso 7
  @Deceval @CrearOtorgante
    Scenario: un usuario desea crear nuevo otorgante pero sin numero de documento
        Given el usuario solicita crear nuevo otorgante sin numero de documento
        When usuario envia solicitud de crear nuevo otorgante sin el numero documento
        Then la solicitud es rechazada indicando el error en el header

  #Historias de usuario consulta con pdf
  #Caso 8
  @Deceval @ConsultaPagare
    Scenario: un usuario desea consultar un pagare en formato pdf, enviando un id de pagaré que no es existente en deceval
        Given usuario envia solicitud con un id pagare inexistente en deceval
        When usuario envia solicitud consulta pagare con pdf
        Then el servicio debe responder no existe pagare asociado al id ingresado
  #Caso 9
  @Deceval @ConsultaPagare
    Scenario: un usuario desea consultar un pagare en deceval, enviando la fecha de transaccion incorrecta
        Given usuario desea consultar pagare con de transaccion diferente a hoy
        When usuario envia solicitud consulta pagare con pdf con fecha transaccion incorrecta
        Then el servicio debe responder error en fecha de transaccion

  @Deceval @ConsultaPagare
    Scenario: un usuario desea consultar un pagare sin diligenciar el campo del código
          Given usuario desea consultar un pagare pero desconoce el codigo
          When usuario envia solicitud de consulta pagare sin campo codigo pagare
          Then la solicitud es rechazada indicando que el codigo pagare es requerido

  #Historias de usuario crear pagare
  @Deceval @Crearpagare
    Scenario: un usuario desea crear un pagare, sin enviar el numero de cuenta del otorgante
        Given el usuario solicita crear un pagare sin conocer la cuenta otorgante
        When el usuario envia la peticion para crear pagare sin cuenta otorgante
        Then el pagare debe ser creado si se envia numero de documento del otorgante

  @Deceval @Crearpagare
    Scenario: un usuario desea crear un pagare, sin enviar el numero de pagare generado por la entidad
        Given el usuario solicita crear un pagare sin conocer el numero pagare en la entidad
        When envia la peticion de crear pagare sin el numero pagare de la entidad
        Then el servicio genera error en la creacion de pagare


  #Historias de usuario firmas pagare
  @Deceval @Firmarpagare @pruebasDeceval
    Scenario: un usuario desea firmar un pagare, enviando un codigo inexistente
        Given el usuario desea firmar un pagare con un codigo inexistente
        When envia la peticion firmar pagare con codigo inexistente
        Then el servicio debe generar error codigo pagare no existe

  #Historias de usurio cambiar estado pagare
  @Deceval @CambiarEstadoPagare @Basico
    Scenario: un usuario desea cambiar el estado de un pagare
        Given el usuario solicita cambiar estado pagare
        When el usuario envia la peticion de cambiar estado pagare
        Then el servicio debe responder cambio de estado exitoso

  @Deceval @CambiarEstadoPagare @Nuevo
      Scenario: un suario desea cambiar el estado de un pagare, enviando un codigo inexistente
          Given el usuario solicita cambiar estado pagare, pero envia un codigo inexistente
          When el usuario envia la peticion de cambiar estado pagare con codigo pagare
          Then el servicio debe responder error en el cambio de estado del pagare

  @Deceval @CambiarEstadoPagare @Nuevo
      Scenario: un usuario desea cambiar el estado de un pagare que no esta en estado provisional
          Given el usuario solicita cambiar estado pagare que no esta en estado provisional
          When el usuario envia la peticion de cambiar estado pagare en estado provisional
          Then el servicio debe responder error, el pagare no se encuentra en estado provisional

  #Historias de usuario anulacion de pagare
  @Deceval @Basico
    Scenario: un usuario desea registar la anulacion del un pagare
        Given el usuario solicita anular un pagare
        When el usuario envia la peticion de anulacion para un pagare
        Then el servicio debe responder la anulacion de pagare fue exitoso

  @Deceval @Basico
    Scenario: un usuario desea registar la anulacion del un pagare, pero enviando un codigo pagare inexistente
          Given el usuario solicita anular un pagare enviando un codigo pagare inexistente
          When el usuario envia la peticion de anulacion para un pagare inexistente
          Then el servicio debe responder error en la anulacion el pagare no existe

  #Historias de usuario cancelar pagare
  @Deceval @CancelarPagare @Basico
    Scenario: un usuario desea cancelar un pagare
        Given el usuario solicita cancelar pagare con codigo existente
        When envia la peticion de cancelar pagare con codigo existente
        Then el servicio debe respoder pagare cancelado

  @Deceval @CancelarPagare
    Scenario: un usuario desea cancelar un pagare, pero envia un codigo pagare inexistente
        Given el usuario solicita cancelar un pagare con un codigo inexistente
        When envia la peticion de cancelar pagare con un codigo erroneo
        Then el servicio debe responder error pagare inexistente


