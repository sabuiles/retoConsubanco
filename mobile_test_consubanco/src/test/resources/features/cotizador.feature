#language: es
Característica: Cotizador
  Como usuario de la app
  Quiero realizar cotizaciones
  Para obtener valores de muestra

  Escenario: Cotizar sin intercompania por monto
    Dado que el usuario esta logueado
      | usuario    | clave     |
      | 0010007424 | Promotor1 |
    Y el usuario crea una cotizacion
      | sucursal                                    | grupo de convenios | convenio                | renovacion inter | tipo cotizacion | monto |
      | Consupago Cd. de México, D.F. - Corporativo | Educación SNTE     | SNTE SECC. 35, COAHUILA | No               | Por monto       | 50000 |
    Entonces el usuario deberia ver los resultados de cotizaciones
