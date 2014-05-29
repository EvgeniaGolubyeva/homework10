package auction.rest;

import auction.dao.BidDAO;
import auction.dao.ProductDAO;
import auction.entity.Bid;
import auction.entity.BidConfirmation;
import auction.entity.Product;
import auction.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Evgenia
 */

@RestController
@RequestMapping("server/product")
public class ProductRestfulService {
    private ProductDAO productDAO;
    private BidDAO bidDAO;
    private BidService bidService;

    @RequestMapping(method = RequestMethod.GET, value = "/featured")
    public List<Product> getFeaturedProducts() {
        return productDAO.getFeaturedProducts();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public List<Product> getSearchProducts(@RequestParam MultiValueMap<String, String> parameters) {
        return productDAO.getSearchProducts(parameters);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Product getProduct(@PathVariable int id) {
        return productDAO.getById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{productId}/bid")
    public List<Bid> getProductBids(@PathVariable("productId") int productId) {
        return bidDAO.getBidsByProduct(productId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/bid")
    public BidConfirmation placeBid(@PathVariable("id") int productId, @RequestBody Bid bid) {
        bid.setProduct(productDAO.getById(productId));
        return bidService.placeBid(bid);
    }

    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Autowired
    public void setBidDAO(BidDAO bidDAO) {
        this.bidDAO = bidDAO;
    }

    @Autowired
    public void setBidService(BidService bidService) {
        this.bidService = bidService;
    }
}
