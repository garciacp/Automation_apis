Feature: Firma Pagare Deceval

  @Deceval @ConsultaPagare
    Scenario: Consulta de pagare en deceval sin pdf
      Given usuario Nuevo solicita consulta pagare sin pdf
      When envia la peticion de consulta sin pdf a deceval
      Then la consulta debe ser rechazada


  @Deceval @ConsultaPagare
    Scenario: Consulta de pagare en deceval con pdf
      Given usuario Nuevo solicita consulta pagare con pdf
      When envia la peticion de consulta con pdf a  deceval
      Then la consulta debe ser aprobada pagare

  @Deceval @CrearOtorgante
    Scenario: usuario nuevo crea otorgante
      Given usuario Nuevo solicita crear otorgante
      When envia la peticion para crear otorgante
      Then la consulta debe ser aprobada otorgante
      And el cliente ya existe

  @Deceval @Crearpagare
    Scenario: usuario nuevo crea pagare
      Given usuario Nuevo solicita crear pagare
      When envia la peticion para crear pagare
      Then la consulta debe ser aprobada pagare

  @Deceval @Firmarpagare
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

  @Deceval @ConsultaPagare @pruebasDeceval
    Scenario: usuario envia solicitud de consulta sin algun campo obligatorio
          Given usuario envia solicitud de consulta pagare sin algun campo obligatorio
          When usuario envia solicitud de consulta pagare sin campo pagare
          Then la solicitud es rechazada indicando el error en el header

  #Historias de usuario crear pagare
  @Deceval @Crearpagare
    Scenario: usuario solicita crear pagare sin cuenta otorgante
        Given usuario solicita crear pagare sin cuenta otorgante
        When envia la peticion para crear pagare
        Then el servicio debe generar error en la creacion de pagare

  @Deceval @Crearpagare
    Scenario: usuario solicita crear pagare sin numero pagare entidad
        Given usuario solicita crear pagare sin numero pagare entidad
        When envia la peticion para crear pagare
        Then el servicio debe generar error en la creacion de pagare

  @Deceval @Crearpagare
    Scenario: usuario solicita crear pagare sin algun campo obligatorio
        Given usuario solicita crear pagare sin algun campo obligatorio
        When envia la peticion para crear pagare
        Then el servicio debe generar error en la creacion de pagare

  #Historias de usuario firmas pagare
  @Deceval @Firmarpagare
    Scenario: usuario solicita firmar pagare con id pagare diferente
        Given usuario solicita firmar pagare con id diferente
        When envia la peticion para firmar pagare
        Then el servicio debe generar error en la firma del pagare

