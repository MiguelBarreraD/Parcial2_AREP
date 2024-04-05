# Parcial2_AREP


## Instrucciones de uso 





## Diseño


    ProxyServer.java:
        Esta clase es el punto de entrada de la aplicación del servidor proxy.
        Configura el servidor Spark para escuchar en un puerto específico y define los endpoints para las operaciones de búsqueda lineal y binaria.
        Implementa la lógica del algoritmo de round-robin para delegar las solicitudes a las dos instancias del servicio MathService.
        Utiliza la clase HttpConnectionExample para hacer las solicitudes GET a los servicios MathService.
        Devuelve la respuesta recibida de los servicios MathService al cliente.
    MathServices.java:
        Esta clase representa los servicios de búsqueda lineal y binaria.
        Configura el servidor Spark para escuchar en un puerto específico y define los endpoints para las operaciones de búsqueda lineal y binaria.
        Implementa la lógica de la búsqueda lineal y binaria utilizando las funciones de la clase Calculator.
        Construye y devuelve una respuesta JSON con los resultados de las operaciones de búsqueda.
    HttpConnectionExample.java:
        Esta clase proporciona un método estático main() que realiza una solicitud HTTP GET a una URL dada.
        Configura la conexión HTTP, envía la solicitud y maneja la respuesta.
        Devuelve el cuerpo de la respuesta como una cadena.
        Esta clase se utiliza en el ProxyServer para delegar las solicitudes a los servicios MathService.
    Calculator.java:
        Esta clase contiene las implementaciones de los algoritmos de búsqueda lineal y binaria.
        El método LinealSearch() realiza una búsqueda lineal en un arreglo de cadenas y devuelve la posición del elemento encontrado o -1 si no se encuentra.
        El método BinarySearch() realiza una búsqueda binaria en un arreglo de enteros y devuelve la posición del elemento encontrado o -1 si no se encuentra.
        Estos métodos se utilizan en la clase MathServices para implementar las operaciones de búsqueda.



## Construcción


## Maquinas Virtuales

