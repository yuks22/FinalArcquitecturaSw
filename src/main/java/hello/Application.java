package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        //Unit test 2
        Message m = new Message();
        m.setName("Hola");
        if(!m.getMessage().equals("Hola")){
          System.out.println("Error, mensaje no encontrado");
        }

        //Unit test 3
        User u = new User();
        u.setNameU("Yuks");
        if(!u.getNameU().equals("Yuks")){
          System.out.println("Error, usuario no encontrado");
        }

    }
}
