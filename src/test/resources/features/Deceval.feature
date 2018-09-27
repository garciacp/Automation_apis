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
      Then la consulta debe ser aprobada

  @Deceval @CrearOtorgante
    Scenario: usuario nuevo crea otorgante
      Given usuario Nuevo solicita crear otorgante
      When envia la peticion para crear otorgante
      Then la peticion debe ser aprobada

  @Deceval @Crearpagare
    Scenario: usuario nuevo crea pagare
      Given usuario Nuevo solicita crear pagare
      When envia la peticion para crear pagare
      Then la consulta debe ser aprobada

  @Deceval @Firmarpagare
    Scenario: usuario nuevo Firma pagare
      Given usuario Nuevo solicita firmar pagare
      When envia la peticion para firmar pagare
      Then la consulta debe ser aprobada

