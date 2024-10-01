#language: es
Característica: Agregar articulos logueado en mi cuenta
  Como un comprador de items
  Quiero agregar productos a mi carrito
  Para poder adquirir nuevos productos

  Esquema del escenario: Agregar productos al carrito con una cuenta nueva
    Dado que el comprador se ha registrado
      | usuario | <usuario> |
      | clave   | <clave>   |
    Y el comprador se ha logueado con los datos de registro
    Y el comprador esta en la categoria "<categoria>"
    Cuando el comprador agrega el producto "<producto>"
    Entonces el comprador deberia ver el producto en el carrito
    Cuando el comprador remueve el producto "<producto>" del carrito
    Entonces el comprador deberia ver que el producto "<producto>" ya no esta en el carrito
    Cuando el comprador cierra la sesion
    Entonces el comprador no deberia ver su nombre de usuario
    Y el comprador deberia estar en la pagina principal

    Ejemplos:
      | usuario      | clave | categoria | producto          |
      | comprador118 | 123   | Phones    | Samsung galaxy s6 |