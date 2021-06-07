API REST 24/05/21
========================================================

NOTAS GENERALES
---------------

Desarrollo de una API REST con Java (Jersey) para el manejo de los datos de una agenda de contactos.
La API permite realizar las operaciones CRUD sobre los datos almacenados en una estructura en memoria.
Tomando como referencia la URL base indicada, las operaciones permitidas están mapeadas de la siguiente manera:

 · Listar los contactos (JSON): GET
       /webapi/contact

       La aplicación te devuelve los contactos que hay usando esta url:
       http://localhost:8080/DII_P4_RUBEN_GARCIA_DIEZ/webapi/contact

 · Obtener el número de contactos: GET
       /webapi/contact/size

       Para obtener el numero de contactos basta con usar esta url:
       http://localhost:8080/DII_P4_RUBEN_GARCIA_DIEZ/webapi/contact/size

 · Insertar un contacto: POST
       /webapi/contact

       Para insertar un contacto con el método POST hay que tener en cuenta los nombres de los parámetros:

       n = nombre
       a1 = primer apellido
       a2 = segundo apellido
       e = email
       t = teléfono
       c = comentarios

       Ninguno de los parámetros puede quedarse en blanc.
       El email es la clave con la que se hacen las operaciones, esta no puede modificarse después de insertada,
       por lo que es recomendable fijarse bien al insertarla.

 · Actualizar un contacto: PUT
       /webapi/contact

       Para modificar puedes variar uno de los siguientes parámetros menos el email, el email se necesita para saber que
       contacto quieres modificar, por lo que hay que introducirlo.

       n = nombre
       a1 = primer apellido
       a2 = segundo apellido
       e = email
       t = teléfono
       c = comentarios

 · Eliminar un contacto: DELETE
       /webapi/contact

       Para eliminar un contacto hay que introducir su email con el siguiente nombre de parámetro.

       e = email

NOTAS ESPECIFICAS
-----------------

No existen.

OTRAS CONSIDERACIONES
---------------------

No se consideran.