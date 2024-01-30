package hu.gatherings.gateway.sokcet;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import hu.gatherings.gateway.sokcet.entity.Message;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SocketIOController {

    private final SocketService socketService;

    // TODO: query user's rooms
    List<String> rooms = List.of("group1", "group3");

    public SocketIOController(SocketIOServer socketServer, SocketService socketService) {
        this.socketService = socketService;
        socketServer.addConnectListener(onUserConnectWithSocket());
        socketServer.addEventListener("send_message", Message.class, onMessageReceived());
    }

    private ConnectListener onUserConnectWithSocket() {
        return client -> rooms.forEach(client::joinRoom);
    }

    private DataListener<Message> onMessageReceived() {
        return (client, data, ackSender) -> socketService.sendSocketMessage(client, data);
    }
}


