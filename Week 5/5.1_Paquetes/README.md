Crea un proyecto con dos paquetes (paquete1 y paquete2) y las siguientes clases en cada uno de ellos:
paquete1:

    ● Clase1: modificador public con cuatro atributos con modificadores public, sin modificador,
protected y private respectivamente. Del mismo modo cuatro métodos con dichos
modificadores de visibilidad. Estos pueden no realizar nada.

    ● Clase2: sin modificador en la clase y con los mismos atributos y métodos que la anterior.
paquete2:
    ● App.java con un método main desde el que habrá que intentar:
        ○ importar la Clase1. ¿Qué sucede?
        ○ importar la Clase2 ¿Qué sucede?
        ○ Acceder a todos los atributos y métodos de un objeto de la Clase1.
        
¿Qué sucede en cada caso? Revisa la teoría y los modificadores de visibilidad.
Razona cuál es el propósito de los modificadores de visibilidad y da un posible ejemplo

Se puede importar Clase1 porque es publica.

No se puede importar Clase2 porque tiene modificador default y solo se puede accederlo en el mismo paquete.

Se puede acceder solo el variable y funcion publica del Clase1.

Los defaults no porque estamos en otro paquete.

Los protecteds no porque no es una subclase.

Los privados no porque no es la misma clase.

Usamos modificadores para que los usuarios de nuestras programas tienen acceso limitado a los datos/atributos de las clases.
