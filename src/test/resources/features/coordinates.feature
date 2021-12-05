# language: es
@functionality:BE.Coordenadas.GPS
@layer:Backend
@execution:automatic
@automation:complete
Característica: Las coordenadas GPS
  Yo como administrador del portal de la compañía
  Quiero proporcionar las coordenadas de la ubicación de una persona o de un lugar de interés
  Para mostrar la ubicación en cualquier punto de la superficie terrestre

  @priority:high
  @Regression:yes
  @id:C0011
  Esquema del escenario:  Validar la busquedad de un sitio especifico
    Dado que Andres desea localizar un lugar como: <id>
    Cuando ingrese las coordenadas de búsqueda
    Entonces mostrara el sitio con la hora actual de ese lugar

    Ejemplos:
      | id               |
      | "Angola"         |
      | "Guatemala"      |
      | "Lagos"          |
      | "Bogota"         |

  @priority:medium
  @Regression:yes
  @id:C0012
  Escenario:  Validar la busquedad de un sitio cuando las coordenadas son incorrectas
    Dado que Andres desea localizar un lugar "inexistente"
    Cuando ingrese las coordenadas de búsqueda
    Entonces generara un error de "coordenadas" en la consulta

  @priority:medium
  @Regression:not
  @id:C0013
  Esquema del escenario:  Validar la busquedad de un sitio cuando el servicio no se envia un parametro
    Dado que Andres desea localizar un lugar "en especifico"
    Cuando ingrese las coordenadas de búsqueda sin <parametro>
    Entonces generara un error de <message> en la consulta
    Ejemplos:
      | parametro     | message    |
      | "lat"         | "parameter"|
      | "lng"         | "parameter"|
      | "username"    | "userNameNull"|

  @priority:medium
    @Regression:not
    @id:C0014
  Esquema del escenario:  Validar la busquedad de un sitio cuando se envian parametros incorrectos
    Dado que Andres desea localizar un lugar "en especifico"
    Cuando ingrese el parametro <parametro> incorrecto
    Entonces generara un error de <message> en la consulta
    Ejemplos:
      | parametro     | message       |
      | "lat"         | "coorerror"   |
      | "lng"         | "coorerror"   |
      | "username"    | "userName"    |