//package auction.websockets;
//
//import entity.Bid;
//import entity.Product;
//import entity.User;
//
//import javax.json.Json;
//import javax.json.JsonObject;
//import javax.json.JsonReader;
//import javax.websocket.DecodeException;
//import javax.websocket.Decoder;
//import javax.websocket.EndpointConfig;
//import java.io.StringReader;
//
///**
// * @author Evgenia
// */
//public class BidDecoder implements Decoder.Text<Bid> {
//    @Override
//    public Bid decode(String s) throws DecodeException {
//        JsonReader reader = Json.createReader(new StringReader(s));
//        JsonObject jsonBid = reader.readObject();
//
//        JsonObject jsonUser = jsonBid.getJsonObject("user");
//        User user = new User();
//        user.setId(jsonUser.getInt("id"));
//        user.setName(jsonUser.getString("name"));
//        user.setEmail(jsonUser.getString("email"));
//        user.setGetOverbidNotifications(jsonUser.getBoolean("getOverbidNotifications"));
//
//        JsonObject jsonProduct = jsonBid.getJsonObject("product");
//        Product product = new Product();
//        product.setId(jsonProduct.getInt("id"));
//
//        Bid bid = new Bid();
//        bid.setUser(user);
//        bid.setProduct(product);
//        bid.setAmount(jsonBid.getJsonNumber("amount").bigDecimalValue());
//
//        return bid;
//    }
//
//    @Override
//    public boolean willDecode(String s) {
//        try {
//            JsonReader reader = Json.createReader(new StringReader(s));
//            JsonObject jsonBid = reader.readObject();
//
//            JsonObject jsonUser = jsonBid.getJsonObject("user");
//            jsonUser.getInt("id");
//            jsonUser.getString("name");
//            jsonUser.getString("email");
//            jsonUser.getBoolean("getOverbidNotifications");
//
//            jsonBid.getJsonNumber("amount");
//
//            return true;
//
//        } catch (NullPointerException e) {
//            System.out.println("Bid cannot be decoded");
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    @Override
//    public void init(EndpointConfig config) {
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
