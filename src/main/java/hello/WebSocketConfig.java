package hello;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
/** Genera la conexion con WebSocket.
 * Basado en el tutorial de Spring.io
 * @version 1.0
 */

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    /**
     *Proporciona una configuraci&oacuten esencial para manejar mensajes con protocolos simples de mensajer&iacutea como STOMP.     * @param MessageBrokerRegistry config [description]
     *@param config La confirucion que se va a llevar a cabo.
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }
    /**
     *Define m&eacutetodos para configurar el manejo de mensajes con el protocolo STOMP para clientes WebSocket.
     * @param registry Endopoint a ser agregado.
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }

}
