package auction.dao;

import auction.entity.Product;
import auction.mybatis.ProductMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;

import javax.xml.bind.DatatypeConverter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Evgenia
 */

@Repository
public class ProductDAO {
    private SqlSessionFactory ssf;

    public List<Product> getFeaturedProducts() {
        try (SqlSession session = ssf.openSession()) {
            return session.getMapper(ProductMapper.class).getFeaturedProducts();
        }
    }

    public List<Product> getSearchProducts(MultiValueMap<String, String> params) {
        try (SqlSession session = ssf.openSession()) {
            return session.getMapper(ProductMapper.class).getSearchProducts(prepareCriteria(params));
        }
    }

    public Product getById(int id) {
        try (SqlSession session = ssf.openSession()) {
            return session.getMapper(ProductMapper.class).getById(id);
        }
    }

    private Map<String, Object> prepareCriteria(MultiValueMap<String, String> params) {
        Map<String, Object> res = new HashMap<>();

        for (String k : params.keySet()) {

            if ("date".equals(k)) {
                //parse Date from iso formatted string
                res.put(k, DatatypeConverter.parseDateTime(params.getFirst(k)).getTime());
            } else {
                res.put(k, params.getFirst(k));
            }
        }

        return  res;
    }

    @Autowired
    public void setSsf(SqlSessionFactory ssf) {
        this.ssf = ssf;
    }
}

