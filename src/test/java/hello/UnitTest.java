package hello;

import static org.junit.Assert.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import static java.util.Arrays.asList;
import static java.util.concurrent.TimeUnit.SECONDS;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UnitTest {
  @LocalServerPort
  private int port;

  static final String WEBSOCKET_URI = "ws://localhost:{port}/gs-guide-websocket";
  static final String WEBSOCKET_TOPIC = "/topic";

  BlockingQueue<String> blockingQueue;
  WebSocketStompClient stompClient;

  @Before
  public void setup() {
      blockingQueue = new LinkedBlockingDeque<>();
      stompClient = new WebSocketStompClient(new SockJsClient(
              asList(new WebSocketTransport(new StandardWebSocketClient()))));
  }

  @Test
  public void shouldReceiveAMessageFromTheServer() throws Exception {
      StompSession session = stompClient
              .connect(WEBSOCKET_URI, new StompSessionHandlerAdapter() {}, this.port)
              .get(1, SECONDS);
      session.subscribe(WEBSOCKET_TOPIC, new DefaultStompFrameHandler());

      String message = "MESSAGE TEST";
      session.send(WEBSOCKET_TOPIC, message.getBytes());

      assertEquals(message, blockingQueue.poll(1, SECONDS));
  }

  class DefaultStompFrameHandler implements StompFrameHandler {
      @Override
      public Type getPayloadType(StompHeaders stompHeaders) {
          return byte[].class;
      }

      @Override
      public void handleFrame(StompHeaders stompHeaders, Object o) {
          blockingQueue.offer(new String((byte[]) o));
      }
  }
}
