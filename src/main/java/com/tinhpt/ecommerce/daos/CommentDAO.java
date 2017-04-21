package com.tinhpt.ecommerce.daos;

import com.tinhpt.ecommerce.entities.Comment;

import java.util.List;

public interface CommentDAO {
    Comment persist(Comment comment);

    List<Comment> findByProductId(int productId);
}
