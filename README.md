# Tabla de contenidos
-  [Introducción](#introducción)
-  [API](#api-de-la-aplicación-employee)
  - [Recurso Employee](#recurso-employee)
    - [GET /employees](#GET-/employees)
    - [GET /employees/{id}](#GET-/employees/{id})
    - [POST /employees](#POST-/employees)
    - [PUT /employees/{id}](#PUT-/employees/{id})
    - [DELETE /employees/{id}](#DELETE-/employees/{id})

# API Rest
## Introducción
La comunicación entre cliente y servidor se realiza intercambiando objetos JSON. Para cada entidad se hace un mapeo a JSON, donde cada uno de sus atributos se transforma en una propiedad de un objeto JSON. Todos los servicios se generan en la URL /employee.api/api/. Por defecto, todas las entidades tienen un atributo `id`, con el cual se identifica cada registro:

```javascript
{
    id: '',
    attribute_1: '',
    attribute_2: '',
    ...
    attribute_n: ''
}
```

Cuando se transmite información sobre un registro específico, se realiza enviando un objeto con la estructura mencionada en la sección anterior.
La única excepción se presenta al solicitar al servidor una lista de los registros en la base de datos, que incluye información adicional para manejar paginación de lado del servidor en el header `X-Total-Count` y los registros se envían en el cuerpo del mensaje como un arreglo.

La respuesta del servidor al solicitar una colección presenta el siguiente formato:

```javascript
[{}, {}, {}, {}, {}, {}]
```

## API de la aplicación employee
### Recurso Employee
El objeto Employee tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    salary: '' /*Tipo Double*/,
    image: '' /*Tipo String*/,
    gender: '' /*Tipo Integer*/
}
```




#### GET /employees

Retorna una colección de objetos Employee en representación Detail.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-employee)
409|Un objeto relacionado no existe|Mensaje de error
500|Error interno|Mensaje de error

#### GET /employees/{id}

Retorna una colección de objetos Employee en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Employee a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Employee en [representaciones Detail](#recurso-employee)
404|No existe un objeto Employee con el ID solicitado|Mensaje de error
500|Error interno|Mensaje de error

#### POST /employees

Es el encargado de crear objetos Employee.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Employee que será creado|Sí|[Representación Detail](#recurso-employee)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Employee ha sido creado|[Representación Detail](#recurso-employee)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo crear el objeto Employee|Mensaje de error

#### PUT /employees/{id}

Es el encargado de actualizar objetos Employee.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Employee a actualizar|Sí|Integer
body|body|Objeto Employee nuevo|Sí|[Representación Detail](#recurso-employee)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Employee actualizado|[Representación Detail](#recurso-employee)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo actualizar el objeto Employee|Mensaje de error

#### DELETE /employees/{id}

Elimina un objeto Employee.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Employee a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error



[Volver arriba](#tabla-de-contenidos)
