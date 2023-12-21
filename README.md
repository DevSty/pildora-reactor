# Introducción a Reactor en Spring Boot

Reactor es un framework reactiva basada en Java que proporciona soporte para la programación reactiva en el ecosistema Spring. En Reactor, dos tipos principales de tipos de datos reactivos son `Mono` y `Flux`.
***
## Mono y Flux

### Mono

`Mono` es un tipo de dato reactivo que representa un resultado único. Se utiliza para representar el resultado de una operación asíncrona que puede completarse con éxito, fallar o no devolver ningún resultado.

Ejemplo de uso de `Mono` en un controlador Spring:

```java
@GetMapping("/producto/{id}")
public Mono<Producto> obtenerProducto(@PathVariable Long id) {
    return productoService.obtenerProducto(id);
}
```

## Flux
`Flux` es un tipo de dato reactivo que representa una secuencia de cero o más elementos. Se utiliza para representar el resultado de una operación asíncrona que produce múltiples valores.

Ejemplo de uso de `Flux` en un controlador Spring:

```java
@GetMapping("/productos")
public Flux<Producto> obtenerTodosLosProductos() {
return productoService.obtenerTodosLosProductos();
}
```
***
## Uso Común
`Mono`: Se utiliza cuando se espera un resultado único, como obtener un objeto por su identificador.

`Flux`: Se utiliza cuando se espera una secuencia de resultados, como obtener todos los elementos de una colección.
Estos tipos de datos reactivos son fundamentales para construir aplicaciones reactivas eficientes y escalables con Spring Boot.
***
# ¡Importante! 
Asegúrate de incluir las dependencias adecuadas en tu proyecto para trabajar con Reactor. Puedes agregar las siguientes dependencias a tu archivo pom.xml:
```
<dependencies>
    <dependency>
        <groupId>io.projectreactor</groupId>
        <artifactId>reactor-core</artifactId>
    </dependency>
    <dependency>
        <groupId>io.projectreactor</groupId>
        <artifactId>reactor-spring</artifactId>
    </dependency>
</dependencies>
```