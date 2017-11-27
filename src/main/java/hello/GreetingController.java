package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
/** Controller para regresar Application.
 * Basado en el tutorial de Spring.io
 * @author Diego Granados
 * @author Itzel Reyes
 * @author Yukio Tsuru
 * @version 1.0
 */
@Controller
public class GreetingController {

  private Greeting response = new Greeting();

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")

    /**
     * M&eacutetodo que obtiene el contendio a ser desplegado en la aplicacion a partir de un usaurio y un mensaje.
     * @param  User Usuario quien manda el mensaje.
     * @param  Message  El mensje que es enviado
     * @return El contendio a desplegar
     * @throws Exception En caso de venir vacio.
     */
    public Greeting greeting(User user, Message message) throws Exception {

        response = new Greeting(message.getMessage());
        Thread.sleep(1000); // simulated delay
        return response;
    }

}
