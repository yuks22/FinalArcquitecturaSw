package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

  private Greeting response = new Greeting();

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")

    public Greeting greeting(User user, Message message) throws Exception {

        response = new Greeting(message.getMessage());
        Thread.sleep(1000); // simulated delay
        return response;
    }

}
