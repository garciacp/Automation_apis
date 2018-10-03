Feature: Firma Pagare Deceval

  @Deceval @ConsultaPagare
    Scenario: Consulta de pagare en deceval sin pdf
      Given usuario Nuevo solicita consulta pagare sin pdf
      When envia la peticion de consulta sin pdf a deceval
      Then la consulta debe ser aprobada pagare


  @Deceval @ConsultaPagare
    Scenario: Consulta de pagare en deceval con pdf
      Given usuario Nuevo solicita consulta pagare con pdf
      When envia la peticion de consulta con pdf a  deceval
      Then la consulta debe ser aprobada pagare

  @Deceval @CrearOtorgante @Basico
    Scenario: usuario nuevo crea otorgante
      Given usuario Nuevo solicita crear otorgante
      When envia la peticion para crear otorgante
      Then la consulta debe ser aprobada otorgante
      And el cliente ya existe

  @Deceval @Crearpagare @Basico
    Scenario: usuario nuevo crea pagare
      Given usuario Nuevo solicita crear pagare
      When envia la peticion para crear pagare
      Then la consulta debe ser aprobada pagare

  @Deceval @Firmarpagare @Basico
    Scenario: usuario nuevo Firma pagare
      Given usuario Nuevo solicita firmar pagare
      When envia la peticion para firmar pagare
      Then la firma debe ser aprobada

  #Historias de usuario para creacion otorgante

  @Deceval @CrearOtorgante
    Scenario: usuario crea nuevo otorgante con fecha hoy incorrecta
        Given usuario solicita crear nuevo otorgante con fecha hoy incorrecta
        When usuario envia solicitud crear nuevo otorgante
        Then la solicitud es rechazada por fecha incorrecta

  @Deceval @CrearOtorgante
    Scenario: usuario envia creacion otorgante sin numero documento
        Given usuario envia creacion otorgante sin algun campo obligatorio
        When usuario envia solicitud crear nuevo otorgante sin algun campo obligatorio
        Then la solicitud es rechazada indicando el error en el header

  #Historias de usuario consulta con pdf
  @Deceval @ConsultaPagare
    Scenario: usuario envia solicitud de consulta pagare con pdf con id inexistente
        Given usuario envia solicitud consulta pagare con pdf con id inexistente
        When usuario envia solicitud consulta pagare con pdf
        Then el servicio debe responder no existe id pagare

  @Deceval @ConsultaPagare
    Scenario: usuario envia solicitud de consulta con fecha hoy incorrecta
        Given usuario envia solicitud de consulta con fecha hoy
        When usuario envia solicitud consulta pagare con pdf con fecha hoy incorrecta
        Then el servicio debe responder error en fecha hoy

  @Deceval @ConsultaPagare
    Scenario: usuario envia solicitud de consulta sin algun campo obligatorio
          Given usuario envia solicitud de consulta pagare sin algun campo obligatorio
          When usuario envia solicitud de consulta pagare sin campo pagare
          Then la solicitud es rechazada indicando pagare requerido

  #Historias de usuario crear pagare
  @Deceval @Crearpagare
    Scenario: usuario solicita crear pagare sin cuenta otorgante
        Given el usuario solicita crear pagare sin cuenta otorgante
        When el usuario envia la peticion para crear pagare sin cuenta otorgante
        Then el pagare debe ser creado si se envia numero de documento

  @Deceval @Crearpagare
    Scenario: usuario solicita crear pagare sin numero pagare entidad
        Given el usuario solicita crear pagare sin numero pagare
        When envia la peticion crear pagare sin numero pagare
        Then el servicio debe generar error en la creacion de pagare


  #Historias de usuario firmas pagare
  @Deceval @Firmarpagare @pruebasDeceval
    Scenario: usuario solicita firmar pagare con id pagare inexistente
        Given el usuario solicita firmar pagare con id inexistente
        When envia la peticion firmar pagare con id
        Then el servicio debe generar error id pagare no existe


  #Historias de usuario cancelar pagare
  @Deceval @CancelarPagare @Basico
    Scenario: usuario solicita cancelar pagare
        Given el usuario solicita cancelar pagare con id existente
        When envia la peticion de cancelar pagare con id existente
        Then el servicio debe respoder con la cancelacion del pagare exitoso

