package hello;

/** Representa la respuesta (Greeting).
 * Basado en el tutorial de Spring.io
 * @author Diego Granados
 * @author Itzel Reyes
 * @author Yukio Tsuru
 * @version 1.0
 */
public class Greeting {

    private String content;

    /**
     *Constructor por default.
     */
    public Greeting() {
    }

    /**
     * Otro Constructor.
     * @param content String para ser asginado.
     */
    public Greeting(String content) {
        this.content = content;
    }

    /**
    * Getter por default para accesar al contendio del mensaje.
     * @return El contenido del Greeting.
     */
    public String getContent() {
        return content;
    }

}
