var stompClient = null;
var user = null;

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

function hideUsername(u)
{
    if(u==1)
    document.getElementById("usernameForm").style.display="none";
}

function hideButtons(u)
{
    if(u==1)
    document.getElementById("connect").style.display="none";
    document.getElementById("disconnect").style.display="block";

}
function showButtons(u)
{
  if(u==1)
  document.getElementById("disconnect").style.display="none";
  document.getElementById("connect").style.display="block";
  document.getElementById("usernameForm").style.display="block";

}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendUser(){
      user = document.getElementById("user").value;
}

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': user+": "+$("#message").val()}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
    $( "#send2" ).click(function() { sendUser(); });
});
