package hello;
/** Representa a un usuario.
 * Basado en el tutorial de Spring.io
 * @author Diego Granados
 * @author Itzel Reyes
 * @author Yukio Tsuru
 * @version 1.0
 */
public class User {

    private String nameU;

    /**
     *Constructor por default.
     */
    public User() {
    }

    /**
     * Otro Constructor.
     * @param nameU String para ser asginado.
     */
    public User(String nameU) {
        this.nameU = nameU;
    }

    /**
    * Getter por default para accesar al contendio del mensaje.
     * @return El nombre del usuario.
     */
    public String getNameU() {
        return nameU;
    }

    /**
     * Setter por default para cambiar el contendio del mensaje
     * @param nameU El nuevo nombre del usuario.
     */
    public void setNameU(String nameU) {
        this.nameU = nameU;
    }
}
