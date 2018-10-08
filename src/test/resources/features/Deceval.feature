Feature: Firma Pagare Deceval
  #Caso 1
  @Deceval @ConsultaPagare
    Scenario: un usuaro registrado desea visualizar un pagare sin que sea pdf
      Given el usuario solicita consultar pagare sin pdf
      When se envia la peticion de consulta sin pdf a deceval
      Then el servicio retorna pagare sin pdf

  #Caso 2
  @Deceval @ConsultaPagare
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

  @Deceval @Firmarpagare @Basico
    Scenario: un usuario desea firmar un pagare en deceval
      Given usuario necesita firmar el pagare creado anteriomente
      When envia la peticion para firmar pagare en deceval
      Then la firma debe ser aprobada

  #Historias de usuario para creacion otorgante

  @Deceval @CrearOtorgante
    Scenario: un usuario desea crear nuevo otorgante, pero envia fecha transaccion incorrecta
        Given el usuario solicita crear nuevo otorgante con fecha transaccion incorrecta
        When usuario envia solicitud crear nuevo otorgante
        Then la solicitud es rechazada por fecha de transaccion incorrecta

  @Deceval @CrearOtorgante
    Scenario: un usuario desea crear nuevo otorgante pero sin numero de documento
        Given el usuario solicita crear nuevo otorgante sin numero de documento
        When usuario envia solicitud de crear nuevo otorgante sin el numero documento
        Then la solicitud es rechazada indicando el error en el header

  #Historias de usuario consulta con pdf
  @Deceval @ConsultaPagare
    Scenario: usuario desea consultar un pagare en formato pdf, enviando un id de pagaré que no es existente en deceval
        Given usuario envia solicitud con un id pagare inexistente en deceval
        When usuario envia solicitud consulta pagare con pdf
        Then el servicio debe responder no existe pagare asociado al id ingresado

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


  #Historias de usuario cancelar pagare
  @Deceval @CancelarPagare @Basico
    Scenario: un usuario desea cancelar un pagare
        Given el usuario solicita cancelar pagare con codigo existente
        When envia la peticion de cancelar pagare con codigo existente
        Then el servicio debe respoder error de amortización ya que no existe cambio de esta previo

