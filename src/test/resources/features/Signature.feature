Feature: Servicio de Firma Onpremise con Andes

@SignatureAndes
Scenario: Usuario Nuevo No acepta tratamiento datos personales y no acepta terminos y condiciones
    Given Usuario Nuevo no acepta TDP y no acepta TYC
    When el envia la peticion para que sea firmada digitalmente
    Then la peticion debe ser declinada

@SignatureAndes
Scenario: Usuario Nuevo No acepta tratamiento datos personales y si acepta terminos y condiciones
    Given Usuario Nuevo no acepta TDP y si acepta TYC
    When el envia la peticion para que sea firmada digitalmente
    Then la peticion debe ser declinada

@SignatureAndes
Scenario: Usuario Nuevo Si Acepta tratamiento datos personales y No acepta terminos y condiciones
    Given Usuario Nuevo si acepta TDP y no acepta TYC
    When el envia la peticion para que sea firmada digitalmente
    Then la peticion debe ser declinada

@SignatureAndes
Scenario: Usuario Nuevo Si Acepta tratamiento datos personales y Si Acepta terminos y condiciones
    Given Usuario Nuevo si acepta TDP y si acepta TYC
    When el envia la peticion para que sea firmada digitalmente
    Then la peticion debe ser aprobada

@SignatureAndes
Scenario: Usuario Registrado No acepta tratamiento datos personales y no acepta terminos y condiciones
    Given Usuario Registrado no acepta TDP y no acepta TYC
    When el envia la peticion para que sea firmada digitalmente
    Then la peticion debe ser aprobada

@SignatureAndes
Scenario: Usuario Registrado No acepta tratamiento datos personales y si acepta terminos y condiciones
    Given Usuario Registrado no acepta TDP y si acepta TYC
    When el envia la peticion para que sea firmada digitalmente
    Then la peticion debe ser aprobada

@SignatureAndes
Scenario: Usuario Registrado Si Acepta tratamiento datos personales y No acepta terminos y condiciones
    Given Usuario Registrado si acepta TDP y no acepta TYC
    When el envia la peticion para que sea firmada digitalmente
    Then la peticion debe ser aprobada

@SignatureAndes
Scenario: Usuario Registrado Si Acepta tratamiento datos personales y Si Acepta terminos y condiciones
    Given Usuario Registrado si acepta TDP y si acepta TYC
    When el envia la peticion para que sea firmada digitalmente
    Then la peticion debe ser aprobada

@SignatureAndes
Scenario: Usuario Nuevo con un score menor a 90 desea firmar el documento
    Given Usuario Nuevo con un score menor a 89
    When el envia la peticion para que sea firmada digitalmente
    Then la peticion debe ser declinada

@SignatureAndes
Scenario: Usuario Nuevo con un score igual a 90 desea firmar el documento
    Given Usuario Nuevo con un score igual a 90
    When el envia la peticion para que sea firmada digitalmente
    Then la peticion debe ser aprobada

@SignatureAndes
Scenario: Usuario Nuevo con un score mayor a 90 desea firmar el documento
    Given Usuario Nuevo con un score mayor a 91
    When el envia la peticion para que sea firmada digitalmente
    Then la peticion debe ser aprobada cifin






