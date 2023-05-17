# READ ME 👍

- Reglas del Juego 😶‍🌫️
    
    El juego es multijugador y pueden participar de dos a cinco jugadores. Cada jugador comienza con cinco vidas y deberá elegir un número del 0 al 100. Cuando todos los jugadores hayan elegido su número, se calculará la media y se multiplicará por 0,8. El jugador que se haya acercado más al resultado no perderá ninguna vida, mientras que los demás perderán una vida. El jugador que pierda todas sus vidas será eliminado y el último jugador en pie será el ganador.
    
- Juego 👾
    
    Al abrir el archivo Java, encontraremos cuatro botones para hacer clic. El botón "Ranking" mostrará una tabla con los jugadores, sus partidas ganadas, jugadas y los puntos que tienen si han ganado. En el botón "Historial de Partidas" se mostrará el ID de la partida, la fecha en la que se jugó y los puntos con los que se ganó la partida. El botón de “Instrucciones” mostrará las reglas del juego. Por último, al hacer clic en "Jugar", se nos pedirá que indiquemos cuántos jugadores van a participar. Una vez seleccionado el número de jugadores, cada uno deberá registrarse o iniciar sesión en nuestro juego. Una vez que todos los jugadores estén registrados, el juego comenzará. Al final de cada ronda se mostrarán las vidas de los jugadores, el número que eligieron y el resultado de la ronda. Al final de la partida se mostrará un ranking de los jugadores.

            
- Instrucciones del juego
    
    Cuando iniciemos la aplicación, nos saldrá la interfaz del juego con cuatro botones:
    
    ![Captura de pantalla 2023-05-16 194123.png](README%20Photos/Captura_de_pantalla_2023-05-16_194123.png)
    
    - Jugar
        
        Este botón, primero mostrará la historia del juego.
        
        ![Captura de pantalla 2023-05-16 194155.png](README%20Photos/Captura_de_pantalla_2023-05-16_194155.png)
        
    
    Cuando le demos al botón “Siguiente”, nos mostrará la pantalla de cantidad jugadores.
    
    El mínimo de jugadores, serán dos y el máximo serán cinco. Si introducimos un número o carácter invalido nos saldrá un mensaje de error.
    
    ![Captura de pantalla 2023-05-16 194200.png](README%20Photos/Captura_de_pantalla_2023-05-16_194200.png)
    
    Una vez le demos al botón de “Siguiente”, nos saldrá el registro o inicio de sesión:
    
    ![Captura de pantalla 2023-05-16 194206.png](README%20Photos/Captura_de_pantalla_2023-05-16_194206.png)
    
    Si no tenemos cuenta, nos tendremos que registrar pulsando “Sign Up” y poniendo un correo, username y contraseña:
    
    ![Captura de pantalla 2023-05-16 194213.png](README%20Photos/Captura_de_pantalla_2023-05-16_194213.png)
    
    Si tenemos cuenta, solamente tendremos que poner nickname y contraseña:
    
    ![Captura de pantalla 2023-05-16 194210.png](README%20Photos/Captura_de_pantalla_2023-05-16_194210.png)
    
    Una vez todos los jugadores se hayan registrado o iniciado sesión, podremos empezar a jugar. Para jugar cada jugador tendrá que elegir un número del 2 al 100. 
    
    ![Captura de pantalla 2023-05-16 194251.png](README%20Photos/Captura_de_pantalla_2023-05-16_194251.png)
    
    Cuando todos los jugadores hayan elegido el numero, saldrá la pantalla con el resultado de la ronda y el numero del resultado:
    
    ![Captura de pantalla 2023-05-16 194309.png](README%20Photos/Captura_de_pantalla_2023-05-16_194309.png)
    
    Una vez, solo quede un jugador en vida, se mostrará una pantalla con el resultado de la partida, el nombre de el ganador y dos botones. El botón de “Volver” nos dirigirá a la pantalla principal del juego, mientras que el botón de “Volver  jugar” nos iniciara otra partida con los mismos jugadores.
    
    ![Captura de pantalla 2023-05-16 194338.png](README%20Photos/Captura_de_pantalla_2023-05-16_194338.png)
    
    - Instrucciones
        
        Esté botón mostrará las instrucciones del juego.
        
        ![Captura de pantalla 2023-05-16 194148.png](README%20Photos/Captura_de_pantalla_2023-05-16_194148.png)
        
    - Ranking
        
        Este botón mostrara el ranking de todos los jugadores con los campos: “Ranking”, “Nombre”, “Partidas Jugadas”, “Partidas Ganadas” y “Puntos”.
        
        ![Captura de pantalla 2023-05-16 194143.png](README%20Photos/Captura_de_pantalla_2023-05-16_194143.png)
        
    - Historial partidas
        
        Este botón nos mostrará el historial de todas las partidas jugadas con los campos: “Id”, “Fecha” y “Puntos partida”.
        
        Puntos partida significa los puntos con los que se ha ganado.
        
        ![Captura de pantalla 2023-05-16 194131.png](README%20Photos/Captura_de_pantalla_2023-05-16_194131.png)
    
- Programación 😈
    
    El juego esta programado en JavaFx, y los Fxml los hemos diseñado gracias a SceneBuilder.
    
    Como IDE hemos utilizado IntelliJ. 
    
    Ahora vamos a explicar que hace cada archivo de el programa.
    
    - Controllers
        - InicioController
            
            Este es un controlador de una aplicación de juego en JavaFX que contiene cuatro métodos que se llaman al hacer clic en cuatro botones diferentes en la interfaz gráfica de usuario
            
            - Atributos
                - `**private Scene scene;**`
                - `**private Stage stage;**`
            - Métodos
                - `**public void JugarHistoria(ActionEvent event) throws IOException`** es invocado al hacer clic en un botón en la pantalla de inicio del juego. Su función es cambiar la escena actual de la aplicación a la pantalla "HistoriaView.fxml". Esto se logra cargando el archivo FXML correspondiente y configurando la nueva escena en el escenario actual.
                    - `**public void VerInstrucciones(ActionEvent event) throws IOException`** es invocado al hacer clic en otro botón en la pantalla de inicio del juego. Su función es cambiar la escena actual de la aplicación a la pantalla de "InstruccionesView.fxml".
                        - `**public void VerRanking(ActionEvent event) throws IOException`** es invocado al hacer clic en otro botón en la pantalla de inicio del juego. Su función es cambiar la escena actual de la aplicación a la pantalla de "RankingGeneralView.fxml".
                            - `**public void VerHistorialPartidas(ActionEvent event) throws IOException`** es invocado al hacer clic en otro botón en la pantalla de inicio del juego. Su función es cambiar la escena actual de la aplicación a la pantalla de "HistorialPartidasView.fxml".
        - InicioApplication
            
            Este archivo java es una clase Java que se utiliza para iniciar una aplicación de juego de adivinanzas utilizando JavaFX.
            
            Aquí hay una descripción de lo que hace cada parte del código:
            
            - El código está contenido en el paquete **`com.example.juegoadivina`**.
            - La clase **`InicioApplication`** extiende la clase **`Application`** de JavaFX, lo que indica que es una aplicación JavaFX.
            - El método **`start()`** se ejecuta cuando se inicia la aplicación. Carga un archivo FXML llamado "InicioView.fxml" utilizando un **`FXMLLoader`**, crea una escena con el contenido del archivo FXML y la muestra en un **`Stage`** (escenario).
            - El método **`main()`** es el punto de entrada de la aplicación. Llama al método **`launch()`** para iniciar la aplicación JavaFX.
            
            En resumen, este código carga un archivo FXML que contiene la interfaz de usuario de la aplicación de juego de adivinanzas, muestra la interfaz de usuario en un escenario y proporciona métodos para reiniciar la aplicación cuando sea necesario.
            
            - Métodos
                - `**@Override public void start(Stage stage) throws IOException`** se llama cuando se inicia la aplicación y crea la escena principal cargando el archivo FXML de "InicioView.fxml" y configurando el título de la ventana y su tamaño. Luego muestra la escena en el escenario.
                - `**public static void main(String[] args)**` es el punto de entrada principal de la aplicación. Llama al método **`launch`** de la clase **`Application`** para iniciar la aplicación y mostrar la escena principal en la pantalla.
        - InstruccionesController
            
            Este es un controlador de eventos en JavaFX para la pantalla de "Instrucciones" de la aplicación de juego.
            
            - Métodos
                - `**@FXML public void VolverPrincipio(ActionEvent event) throws IOException**` se llama cuando se hace clic en el botón "Volver al inicio" en la pantalla de instrucciones.
        - HistorialPartidasController
            
            Este es un controlador de eventos en JavaFX para la pantalla "Historial de Partidas" de una aplicación de juego.
            
            - Métodos
                - `**@FXML public void VolverPrincipio(ActionEvent event) throws IOException**` se llama cuando se hace clic en el botón "Volver al inicio" en la pantalla de instrucciones.
        - RankingGeneralController
            
            Este es un controlador de eventos en JavaFX para la pantalla "Ranking General" de una aplicación de juego.
            
            - Métodos
                - `**@FXML public void VolverPrincipio(ActionEvent event) throws IOException**` se llama cuando se hace clic en el botón "Volver al inicio" en la pantalla de instrucciones.
        - HistoriaController
            
            Este controlador se encarga de manejar las acciones de los botones en la vista "HistoriaView" para navegar entre las diferentes vistas de la aplicación.
            
            - Métodos
                - `**@FXML public void ElegirJugadores(ActionEvent event) throws IOException**` es invocado al hacer clic en un botón en la pantalla de la "Historia" del juego. Su función es cambiar la escena actual de la aplicación a la pantalla "CantidadJugadoresView.fxml". Esto se logra cargando el archivo FXML correspondiente y configurando la nueva escena en el escenario actual.
                    - `**@FXML public void VolverPrincipio(ActionEvent event) throws IOException`** es invocado al hacer clic en otro botón en la pantalla de la "Historia" del juego. Su función es cambiar la escena actual de la aplicación a la pantalla de inicio "InicioView.fxml".
            
        - CantidadJugadoresController
            
            Este controller se encarga de manejar la escena donde el usuario ingresa la cantidad de jugadores que participarán en el juego.
            
            - Atributos
                - **`private Stage stage;`** y **`private Scene scene;`** son variables para almacenar el objeto Stage y Scene de la aplicación.
                    - **`public static int cantidadJugadores;`** es una variable estática que se utiliza para almacenar la cantidad de jugadores que se ingresaron en la escena actual. La palabra clave **`static`** significa que la variable pertenece a la clase en lugar de una instancia específica de la clase.
                        - **`public static ArrayList<JugadorPartida> jugadoresPartida = new ArrayList<>();`** es una variable estática que se utiliza para almacenar los objetos JugadorPartida, que representan a cada jugador que participa en el juego. Estos objetos se crearán más adelante en la aplicación cuando se ingrese el nombre de cada jugador.
                            - **`@FXML private TextField cantidadJugadoresTF;`** es una etiqueta de JavaFX que se refiere al campo de texto donde el usuario ingresa la cantidad de jugadores.
                                - **`@FXML private Label errorMessage;`** es una etiqueta de JavaFX que se refiere a un mensaje de error que se muestra si el usuario ingresa una cantidad no válida de jugadores.
            
            - Métodos
                - **`@FXML public void VolverHistoria(ActionEvent event) throws IOException`** es un método que se llama cuando se hace clic en el botón "Volver" en la escena actual. Este método carga la escena HistoriaView.fxml y la muestra.
                    - **`@FXML public void ElegirNombres(ActionEvent event) throws IOException`** es un método que se llama cuando se hace clic en el botón "Elegir Nombres" en la escena actual. Este método valida la cantidad de jugadores ingresada por el usuario y luego carga la escena NombreJugadorView.fxml si la cantidad es válida. Si la cantidad no es válida, se muestra un mensaje de error.
                        - **`public boolean validarCantidad(String input)`** es un método auxiliar que valida la cantidad de jugadores ingresada por el usuario. Este método devuelve **`false`** si la cantidad no es un número entero positivo mayor o igual a 2, y devuelve **`true`** si es válido.
        - Jugador
            
            Esta clase representa a un jugador en un juego y tiene los siguientes atributos:
            
            - Atributos
                - ranking: representa el rango o clasificación del jugador en el juego.
                - nombre: representa el nombre del jugador.
                - email: representa la dirección de correo electrónico del jugador.
                - password: representa la contraseña del jugador (se espera que esté encriptada).
                - partidasJugadas: representa el número de partidas jugadas por el jugador.
                - partidasGanadas: representa el número de partidas ganadas por el jugador.
                - puntos: representa la cantidad de puntos acumulados por el jugador.
            
            La clase tiene varios constructores para crear instancias de Jugador con diferentes conjuntos de atributos. Algunos de los métodos y funciones importantes de la clase incluyen:
            
            - Metodos
                - setPassword: un método privado que establece la contraseña del jugador. La contraseña se encripta antes de almacenarla en el atributo "password".
                - getRanking y setRanking: métodos para obtener y establecer el ranking del jugador.
                - getNombre y setNombre: métodos para obtener y establecer el nombre del jugador.
                - getEmail: un método para obtener la dirección de correo electrónico del jugador.
                - getPassword: un método para obtener la contraseña encriptada del jugador.
                - getPartidasJugadas y setPartidasJugadas: métodos para obtener y establecer el número de partidas jugadas por el jugador.
                - getPartidasGanadas y setPartidasGanadas: métodos para obtener y establecer el número de partidas ganadas por el jugador.
                - getPuntos y setPuntos: métodos para obtener y establecer la cantidad de puntos acumulados por el jugador.
                - addPartidaJugada: un método para incrementar el contador de partidas jugadas.
                - addPartidaGanadas: un método para incrementar el contador de partidas ganadas.
                - addPuntos: un método para agregar una cantidad específica de puntos al total del jugador.
            
            En resumen, esta clase representa la información y el comportamiento de un jugador en un juego, incluyendo su clasificación, nombre, dirección de correo electrónico, contraseña, estadísticas de juego (partidas jugadas, ganadas, puntos) y métodos para modificar y acceder a estos atributos.
            
        - JugadorPartida
            
            El código que has compartido muestra una clase llamada "JugadorPartida" (PlayerGame) que extiende la clase "Jugador" (Player) anteriormente mencionada. Esta clase representa a un jugador en el contexto de una partida de juego específica y agrega funcionalidad adicional relacionada con la partida. Aquí está el resumen de lo que hace esta clase:
            
            - Atributos
                - Herencia: La clase JugadorPartida hereda todos los atributos y métodos de la clase Jugador, ya que extiende esa clase. Esto significa que todos los atributos y métodos de Jugador están disponibles en JugadorPartida.
                - rankingPartida: Este es un atributo adicional que representa la posición o clasificación del jugador dentro de la partida. El valor de este atributo se actualiza en función de la cantidad de rondas que ha jugado el jugador. Cuantas más rondas juegue, mejor será su rankingPartida.
                - vidas: Este atributo representa el número de vidas restantes del jugador en la partida.
                - masCercano: Este atributo booleano indica si el jugador está más cerca de adivinar la respuesta correcta en la partida.
                - numerosElegidos: Esta es una lista (ArrayList) que almacena los números elegidos por el jugador durante la partida.
                - Constructores: La clase tiene varios constructores para crear instancias de JugadorPartida con diferentes conjuntos de atributos. Algunos de los constructores son similares a los de la clase Jugador, pero también se aseguran de establecer un valor predeterminado para el atributo vidas.
            
            La clase JugadorPartida agrega métodos adicionales para interactuar con los atributos específicos de la partida. Algunos de estos métodos son:
            
            - Métodos
                - `getVidas:` devuelve el número de vidas restantes del jugador.
                - `esVivo:` verifica si el jugador todavía está vivo (si tiene vidas restantes).
                - `getNumerosElegidos:` devuelve la lista de números elegidos por el jugador durante la partida.
                - `getNumeroElegido:` devuelve el último número elegido por el jugador.
                - `quitarVida:` reduce en uno el número de vidas del jugador (siempre que el número de vidas sea mayor que cero).
                - `cantidadRondas:` devuelve la cantidad de rondas que ha jugado el jugador (basado en la cantidad de números elegidos).
            
            En resumen, esta clase extiende la clase Jugador y agrega funcionalidad específica para una partida de juego, incluyendo el seguimiento de vidas restantes, números elegidos y el cálculo del ranking de la partida.
            
        - RondaController
            
            El código muestra una clase llamada "RondaController". Esta clase es un controlador que maneja la lógica y la interacción de la interfaz de usuario relacionada con una ronda de juego. Aquí está el resumen de lo que hace esta clase:
            
            - Atributos: La clase tiene varios atributos, incluyendo una instancia de Stage y Scene para gestionar la navegación entre las diferentes vistas de la aplicación. También hay dos atributos (@FXML) que están vinculados a elementos de la interfaz de usuario: un Label llamado "nombreJugador" y un PasswordField llamado "numeroElejido".
            - Inicialización: El método "initialize" se llama cuando se inicializa el controlador. Dentro de este método, se incrementa el valor de una variable "idRonda" (que no se muestra en el código proporcionado) y se establece el contador "i" en -1. Luego, se itera a través de la lista de jugadores de la partida hasta encontrar el primer jugador vivo, actualizando el valor de "i". Esto se hace para asegurarse de que el jugador actual sea uno que esté vivo. También hay un control para manejar una excepción de "ArrayIndexOutOfBoundsException" en caso de que no haya jugadores vivos.
            - Evento "jugadorSiguiente": Este método se llama cuando se produce un evento "ActionEvent" en la interfaz de usuario, generalmente asociado a un botón de "jugador siguiente". Dentro de este método, se verifica si el índice "i" es menor que el tamaño de la lista de jugadores de la partida. Si es así, se llama al método "metodoPrinciapl" (posiblemente debería ser "metodoPrincipal") y se pasa el evento. Si no, se llama al método "toResultadoRonda" para navegar a la página de resultado de la ronda.
            - Métodos
                - changeLabelNombre: Este método actualiza el texto del Label "nombreJugador" con el nombre del jugador actual.
                - `metodoPrinciapl`: Este método se encarga de guardar el número elegido por el jugador actual, controlar su validez y decidir a qué página de la interfaz de usuario navegar a continuación. Si el número no es válido, se guarda en el ArrayList "numerosElegidos" del jugador actual, se pasa al siguiente jugador vivo y se verifica si se debe navegar a la página de resultado de la ronda o cambiar al siguiente jugador. Si el número es válido, se muestra un mensaje de error.
                - `toResultadoRonda`: Este método se llama para navegar a la página de resultado de la ronda. Antes de hacerlo, se llama al método "setGanadorRonda" para determinar quién ha ganado la ronda y se llama al método "changeVidas" para actualizar las vidas de los jugadores. Luego, se carga la interfaz de usuario desde el archivo "RondaResultadoView.fxml" y se muestra en la ventana de la aplicación.
                - `calcularResultado`: Este método calcula un número para determinar quién está más cerca de él. Realiza la suma de los números elegidos por los jugadores vivos y devuelve el resultado calculado.
                - `setGanadorRonda`: Este método establece el atributo "masCercano" en "true" para el jugador que está más cerca del resultado calculado. Para determinar esto, se calcula la diferencia entre el número elegido por cada jugador vivo y el resultado calculado, y se encuentra el jugador con la diferencia mínima.
                - `changeVidas`: Este método cambia las vidas de los jugadores después de cada partida. Reduce las vidas de todos los jugadores vivos, excepto del jugador más cercano (con el atributo "masCercano" establecido en "true").
                - `resetMasCercano`: Este método restablece el atributo "masCercano" de todos los jugadores, estableciéndolo en "false".
                - `cantidadVivosRonda`: Este método devuelve la cantidad de jugadores vivos en la ronda.
            
            En resumen, esta clase de controlador maneja la lógica relacionada con una ronda de juego, incluyendo la gestión de jugadores, el cálculo de resultados, la actualización de vidas y la navegación entre las diferentes páginas de la interfaz de usuario.
            
        - RondaResultadoController
            
            Este controlador, llamado "RondaController", es responsable de gestionar la lógica y la interacción de la interfaz de usuario relacionada con una ronda de juego. Proporciona funcionalidades clave para el desarrollo del juego, incluyendo el control de jugadores, el cálculo de resultados, la actualización de vidas y la navegación entre diferentes vistas.
            
            - Metodos:
                - **`initialize()`**: Este método se ejecuta al iniciar el controlador y se encarga de establecer los valores iniciales. Incrementa el identificador de ronda y busca el primer jugador vivo en la lista de jugadores.
                - **`changeLabelNombre()`**: Este método se utiliza para actualizar la etiqueta que muestra el nombre del jugador actual en la interfaz de usuario.
                - **`calcularResultado()`**: Este método calcula un número para determinar qué jugador se acerca más a él. Suma los números elegidos por los jugadores vivos y devuelve el resultado calculado.
                - **`setGanadorRonda()`**: Este método identifica al jugador que está más cerca del resultado calculado y establece el atributo "masCercano" en "true" para ese jugador.
                - **`changeVidas()`**: Este método reduce las vidas de los jugadores vivos después de cada partida, excepto para el jugador más cercano. También restablece el atributo "masCercano" de todos los jugadores.
                - **`toResultadoRonda(ActionEvent event)`**: Este método se utiliza para cargar y mostrar la página de resultados de la ronda. Antes de la navegación, se llama a los métodos para determinar el ganador de la ronda y actualizar las vidas de los jugadores.
                - **`cantidadVivosRonda()`**: Este método devuelve el número de jugadores vivos en la ronda.
            
            Estos métodos son esenciales para gestionar el flujo del juego, realizar cálculos de resultados y actualizar la interfaz de usuario en consecuencia. Su implementación asegura una experiencia de juego interactiva y coherente.
            
        - PasswordEncrypter
            
            Esta clase, llamada "PasswordEncrypter", proporciona un método para cifrar contraseñas utilizando el algoritmo de hash SHA-256. El objetivo principal es convertir una contraseña en texto plano en su correspondiente hash criptográfico antes de almacenarla o compararla con contraseñas cifradas almacenadas previamente en un sistema.
            
            El método principal de la clase es **`encryptPassword(String password)`**, que toma una cadena de texto (la contraseña sin cifrar) como entrada y devuelve su versión cifrada como una cadena de caracteres en formato hexadecimal.
            
            El proceso de cifrado se realiza utilizando el algoritmo de hash SHA-256, que es ampliamente utilizado y considerado seguro. La contraseña se convierte en una secuencia de bytes y se pasa a través de la función hash SHA-256. El resultado es un arreglo de bytes que representa el hash criptográfico de la contraseña original.
            
            Luego, se convierte cada byte del hash en una cadena hexadecimal correspondiente utilizando un bucle **`for`**. Se agrega un "0" al principio si la cadena hexadecimal resultante tiene una longitud de un solo carácter. Finalmente, todas las cadenas hexadecimales se concatenan en un solo objeto **`StringBuilder`**, que se convierte en una cadena y se devuelve como el hash cifrado de la contraseña.
            
            Es importante destacar que este método solo cifra las contraseñas, no las descifra. El objetivo es generar un hash único e irreversible para cada contraseña, de modo que puedan compararse sin revelar la contraseña original en caso de que la base de datos sea comprometida.
            
        
    - Style.css
        
        Este archivo CSS define algunos estilos para elementos en la interfaz de usuario.
        
        - El estilo ".texto" establece un fondo blanco semi-transparente para el texto y el color de la letra en negro.
        - El estilo ".button" establece el color de fondo, el color del borde y el color del texto para los botones, así como también el radio de la esquina de los botones.
        - El estilo ".pane" establece una imagen de fondo usando la propiedad "-fx-background-image". También establece la posición de la imagen en el centro de la ventana.
        - El estilo ".titulo" establece el tamaño de fuente y el color del texto para los títulos.
        - El estilo ".button:hover" establece los colores de fondo, borde y texto para cuando el usuario pasa el cursor sobre un botón.
    - MongoDB
        - MongoCon.java
            
            Este código representa una clase llamada "MongoCon" que se utiliza para interactuar con una base de datos MongoDB en el contexto de un juego de adivinanzas. Aquí hay una descripción de las principales funcionalidades de esta clase:
            
            1. **Conexión a la base de datos**: La clase establece una conexión con una base de datos MongoDB local utilizando el URL de conexión **`mongodb://localhost:27017`** y el nombre de la base de datos "mydb". Se crea un objeto **`MongoClient`** y se obtiene una instancia de **`MongoDatabase`** para interactuar con la base de datos.
            2. **Colecciones de la base de datos**: Se definen tres colecciones de MongoDB en esta clase: "Jugador", "Partida" y "DetallePartida". Se obtienen instancias de **`MongoCollection<Document>`** para cada una de estas colecciones, lo que permite realizar operaciones de lectura y escritura en ellas.
            3. **Validación de usuario y contraseña**: El método **`isUserPassValid`** recibe un nombre de usuario y una contraseña como parámetros. Realiza una consulta a la colección "Jugador" para verificar si existe un documento que coincida con el nombre de usuario y la contraseña proporcionados. Si se encuentra un documento válido, se crea un objeto **`Jugador`** con los datos obtenidos y se devuelve. En caso contrario, se devuelve **`null`**.
            4. **Verificación de disponibilidad de nombre de usuario y correo electrónico**: El método **`isNombreEmailAvailable`** verifica si un nombre de usuario y correo electrónico están disponibles en la base de datos. Se realizan dos consultas separadas en la colección "Jugador" para contar el número de documentos que coinciden con el nombre de usuario y el correo electrónico dados. Si ambos recuentos son igual a cero, significa que tanto el nombre de usuario como el correo electrónico no existen en la base de datos y se devuelve **`true`**. De lo contrario, si alguno de los recuentos es mayor que cero, significa que el nombre de usuario o el correo electrónico ya existen en la base de datos y se devuelve **`false`**.
            5. **Obtención del rango más alto**: El método **`getLatestRank`** recupera el rango del jugador con el rango más alto en la colección "Jugador". Realiza una consulta en la colección para obtener el documento con el rango más alto, y luego devuelve ese valor. Si la colección está vacía, se devuelve **`1`**.
            6. **Registro de un nuevo jugador**: El método **`signUp`** recibe un objeto **`Jugador`** que representa al jugador a ser registrado. Se crea un documento de MongoDB con los datos del jugador y se inserta en la colección "Jugador". Si la operación de inserción es exitosa, se devuelve **`true`**; de lo contrario, se devuelve **`false`**.
            7. **Actualización de datos de jugador**: El método **`updateJugador`** actualiza los datos de un jugador existente en la colección "Jugador". Recibe un objeto **`Jugador`** con los nuevos datos del jugador y realiza una actualización en el documento correspondiente utilizando el nombre de usuario como filtro. Si la actualización es exitosa (se modifica al menos un documento), se devuelve **`true`**; de lo contrario, se devuelve **`false`**.
            8. **Actualización de rango**: El método **`updateRanking`** actualiza el rango de los jugadores en la colección "Jugador" basado en la cantidad de puntos que han obtenido. Primero, se obtiene una lista ordenada de los jugadores según sus puntos en orden descendente. Luego, se recorre la lista y se actualiza el rango de cada jugador en el documento correspondiente utilizando su nombre de usuario como filtro.
            9. **Cierre de conexión**: El método **`close`** se encarga de cerrar la conexión con la base de datos y liberar los recursos asociados.
            
            Esta clase proporciona una interfaz para realizar operaciones comunes de lectura y escritura en la base de datos MongoDB relacionadas con el juego de adivinanzas, como la autenticación de usuarios, registro de nuevos jugadores y actualización de datos de jugadores existentes.
            
