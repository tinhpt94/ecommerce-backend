package com.tinhpt.ecommerce.daoimplements;

import com.tinhpt.ecommerce.daos.CommentDAO;
import com.tinhpt.ecommerce.entities.Comment;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("commentDAO")
public class CommentDAOImpl extends AbstractDAO<Comment, Long> implements CommentDAO {
    @Override
    public List<Comment> findByProductId(int productId) {
        String sql = "SELECT * FROM comments WHERE product_id = :productId";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.setParameter("productId", productId);
        query.addEntity(Comment.class);
        return query.list();
    }
}
