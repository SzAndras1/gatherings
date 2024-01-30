package hu.gatherings.gateway.sokcet;

import com.corundumstudio.socketio.SocketIOClient;
import hu.gatherings.gateway.sokcet.entity.Message;
import org.springframework.stereotype.Service;

@Service
public class SocketService {
    public void sendSocketMessage(SocketIOClient senderClient, Message message) {
        String room = message.getGroupId();
        for (SocketIOClient client : senderClient.getNamespace().getRoomOperations(room).getClients()) {
            client.sendEvent("read_message", message);
        }
    }
}
