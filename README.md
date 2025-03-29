Este proyecto es una aplicación Spring Boot que gestiona discos de música. Utiliza Maven para la gestión de dependencias y está configurado para usar Java 17. La aplicación expone un API REST para realizar operaciones CRUD sobre los discos.

### Integrantes del Equipo
- Samantha Aislinn Gutiérrez Olvera
- Hugo Enrique Canizal Duarte
- Christian Ariel Palacios Hernández
- José Luis Angulo Cabello

### Descripción del Proyecto

**Nombre del Proyecto:** m9_participacion1

**Descripción:** Módulo 9. Participación 1. Discos de música

**Tecnologías Utilizadas:**
- Java 17
- Spring Boot
- Maven

### Instrucciones para Consumir el API REST

#### Obtener todos los discos
- **URL:** `/api/discos`
- **Método HTTP:** GET
- **Respuesta:** JSON con todos los discos

#### Obtener un disco por ID
- **URL:** `/api/discos/{id}`
- **Método HTTP:** GET
- **Respuesta:** JSON con el disco correspondiente al ID proporcionado

#### Agregar un nuevo disco
- **URL:** `/api/discos`
- **Método HTTP:** POST
- **Cuerpo de la Solicitud:** JSON con los datos del nuevo disco
- **Respuesta:** JSON con el disco creado

#### Actualizar un disco existente
- **URL:** `/api/discos/{id}`
- **Método HTTP:** PUT
- **Cuerpo de la Solicitud:** JSON con los datos actualizados del disco
- **Respuesta:** JSON con el disco actualizado

#### Actualizar parcialmente un disco existente
- **URL:** `/api/discos/{id}`
- **Método HTTP:** PATCH
- **Cuerpo de la Solicitud:** JSON con los datos a actualizar del disco
- **Respuesta:** JSON con el disco actualizado

#### Eliminar un disco
- **URL:** `/api/discos/{id}`
- **Método HTTP:** DELETE
- **Respuesta:** Código de estado 204 si se elimina correctamente, 404 si no se encuentra el disco

#### Obtener los integrantes del equipo
- **URL:** `/api/discos/equipo`
- **Método HTTP:** GET
- **Respuesta:** JSON con la lista de integrantes del equipo

### Ejemplo de Cuerpo de Solicitud JSON para POST y PUT
```json
{
  "titulo": "Nombre del Disco",
  "artista": "Nombre del Artista",
  "anioLanzamiento": "2023-01-01"
}
```

### Ejemplo de Cuerpo de Solicitud JSON para PATCH
```json
{
  "titulo": "Nombre del Disco Actualizado"
}
```