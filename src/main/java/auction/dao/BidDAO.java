package auction.dao;

import auction.entity.Bid;
import auction.mybatis.BidMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Evgenia
 */

@Repository
public class BidDAO {
    private SqlSessionFactory ssf;

    public List<Bid> getBidsByProduct(int productId) {
        try (SqlSession session = ssf.openSession()) {
            return session.getMapper(BidMapper.class).getBidsByProduct(productId);
        }
    }

    public void create(Bid bid) {
        try (SqlSession session = ssf.openSession()) {
            session.getMapper(BidMapper.class).insert(bid);
            session.commit();
        }
    }

    @Autowired
    public void setSsf(SqlSessionFactory ssf) {
        this.ssf = ssf;
    }
}
