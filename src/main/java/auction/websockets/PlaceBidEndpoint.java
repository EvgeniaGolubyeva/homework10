//package auction.websockets;
//
//import auction.jms.IncomingBidsProducer;
//import dao.ProductDAO;
//import entity.Bid;
//
//import javax.inject.Inject;
//import javax.websocket.OnMessage;
//import javax.websocket.Session;
//import javax.websocket.server.PathParam;
//import javax.websocket.server.ServerEndpoint;
//
///**
// * @author Evgenia
// */
//
//@ServerEndpoint(
//        value = "/server/bid",
//        decoders = { BidDecoder.class },
//        encoders = { BidConfirmationEncoder.class })
//
//public class PlaceBidEndpoint {
//    private ProductDAO productDAO;
//    private WebSocketSessionHolder webSocketSessionHolder;
//    private IncomingBidsProducer incomingBidsProducer;
//
//    @OnMessage
//    public void placeBid(Bid bid, Session mySession) {
//        bid.setProduct(productDAO.getById(bid.getProduct().getId()));
//
//        webSocketSessionHolder.add(mySession);
//
//        incomingBidsProducer.placeBidToQueue(mySession.getId(), bid);
//    }
//
//    @Inject
//    public void setProductDAO(ProductDAO productDAO) {
//        this.productDAO = productDAO;
//    }
//
//    @Inject
//    public void setIncomingBidsProducer(IncomingBidsProducer incomingBidsProducer) {
//        this.incomingBidsProducer = incomingBidsProducer;
//    }
//
//    @Inject
//    public void setWebSocketSessionHolder(WebSocketSessionHolder webSocketSessionHolder) {
//        this.webSocketSessionHolder = webSocketSessionHolder;
//    }
//}
