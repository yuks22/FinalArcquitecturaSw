/**
 * El autor de las funciones de setConnected(), connect(), 
 * disconnect() y showGreeting() es Spring.io
 * 
 */
var stompClient = null;
var user = null;

/**
 * Función que establece el estado de conectado.
 */
function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

/**
 * Función que se encarga de abrir una conexión a "/gs-guide-websocket".
 * Si la conexión es exitosa, el cliente se subscribe a la destino "/topic/greetings",
 * en donde el server estará publicando los mensajes.
 * Cuando se reciba el mensaje, se agregará un elemento de párrafo al DOM para 
 * mostrar el mensaje.
 */
function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
    });
}

/**
 * Función que se encarga de esconder los botones de connect y disconnect.
 * @param  {[int]}
 */
function hideButtons(u)
{
    if(u==1)
    document.getElementById("connect").style.display="none";
    document.getElementById("disconnect").style.display="block";

}

/**
 * Función que se encarga de mostrar los botones o formas.
 * @param  {[int]}
 */
function showButtons(u)
{
  if(u==1)
  document.getElementById("disconnect").style.display="none";
  document.getElementById("connect").style.display="block";
  document.getElementById("usernameForm").style.display="block";

}

/**
 * Función que lanza una alerta en caso de que el usuario no haya introducido su nombre.
 * @return {[type]}
 */
function required()  
{  
    var empt = document.forms["form1"]["text1"].value;

    if (empt == "")  
    {  
        alert("Please enter your username");  
        return false;  
    }
}

/**
 * Función que desconecta al cliente STOMP.
 */
function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

/**
 * Función que obtiene el nombre del usuario.
 */
function sendUser(){
      user = document.getElementById("user").value;
}

/**
 * Función que lanza alertas cuando el mensaje, el usuario o ambos están vacíos,
 * si no es así recupera el nombre ingresado por el usuario y utiliza el cliente STOMP
 * para enviarlo a GreetingController.greeting()
 * @return {[boolean]} 
 */
function sendName() {
    var empt = document.forms["form1"]["text1"].value;
    var empt2 = document.forms["form2"]["text2"].value;

    if (empt == "" && empt2 == "")  
    {  
        alert("Please enter your username and message");  
        return false;  
    }
    if (empt == "")  
    {  
        alert("Please enter your username");  
        return false;  
    }
    if (empt2 == "")  
    {  
        alert("Please enter your message");  
        return false;  
    }else{
        stompClient.send("/app/hello", {}, JSON.stringify({'name': user+": "+$("#message").val()}));
    }   
}

/**
 * Función que agrega el mensaje en un elemento de párrafo
 */
function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");

}

/**
 * Llama a las funciones de connect(), disconnect(), sendName() y sendUser
 */
$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
    $( "#send2" ).click(function() { sendUser(); });
});
