package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Corre la Aplicación.
 * Basado en el tutorial de Spring.io
 * @author Diego Granados
 * @author Itzel Reyes
 * @author Yukio Tsuru
 * @version 1.0
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        /**
         *Unit test 2
         *Revisando que la funcionalidad de Message sea correcta.
         */
        Message m = new Message();
        m.setName("Hola");
        if(!m.getMessage().equals("Hola")){
          System.out.println("Error, mensaje no encontrado");
        }

        /**
         *Unit test 3
         *Revisando que la funcionalidad de User sea correcta.
         */
        User u = new User();
        u.setNameU("Yuks");
        if(!u.getNameU().equals("Yuks")){
          System.out.println("Error, usuario no encontrado");
        }

    }
}
