//package auction.websockets;
//
//import javax.annotation.PostConstruct;
//import javax.inject.Singleton;
//import javax.websocket.Session;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author Evgenia
// */
//
//@Singleton
//public class WebSocketSessionHolder {
//    private Map<String, Session> webSocketSessions = new HashMap<>();
//
//    public void add(Session webSocketSession) {
//        webSocketSessions.put(webSocketSession.getId(), webSocketSession);
//    }
//
//    public Session get(String id) {
//        return webSocketSessions.get(id);
//    }
//}
