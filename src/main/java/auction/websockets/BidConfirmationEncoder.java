//package auction.websockets;
//
//import entity.BidConfirmation;
//
//import javax.json.Json;
//import javax.json.JsonObjectBuilder;
//import javax.websocket.EncodeException;
//import javax.websocket.Encoder;
//import javax.websocket.EndpointConfig;
//
///**
// * @author Evgenia
// */
//public class BidConfirmationEncoder implements Encoder.Text<BidConfirmation> {
//
//    @Override
//    public String encode(BidConfirmation object) throws EncodeException {
//        JsonObjectBuilder builder = Json.createObjectBuilder();
//
//        builder.add("status", object.getStatus());
//        builder.add("reason", object.getMessage());
//
//        if (BidConfirmation.RESULT_STATUS_ADDED.equals(object.getStatus())) {
//            builder.add("topBidPrice", object.getTopBidPrice());
//            builder.add("totalCountOfBids", object.getTotalCountOfBids());
//            builder.add("topBidUser", object.getTopBidUser());
//        }
//
//        return builder.build().toString();
//    }
//
//    @Override
//    public void init(EndpointConfig config) {}
//
//    @Override
//    public void destroy() {}
//}
