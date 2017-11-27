package hello;
/** Representa a un mensaje.
 * Basado en el tutorial de Spring.io
 * @author Diego Granados
 * @author Itzel Reyes
 * @author Yukio Tsuru
 * @version 1.0
 */
public class Message {

    private String message;

    /**
     *Constructor por default.
     */
    public Message() {
    }

    /**
     * Otro Constructor.
     * @param message String para ser asginado.
     */
    public Message(String message) {
        this.message = message;
    }

    /**
     * Getter por default para accesar al contendio del mensaje.
     * @return El contenido del mensaje.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter por default para cambiar el contendio del mensaje
     * @param message El nuevo contendio del mensaje.
     */
    public void setName(String message) {
        this.message = message;
    }
}
