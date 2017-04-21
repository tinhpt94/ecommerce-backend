package com.tinhpt.ecommerce.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {
    private String title;
    private String content;
    private double rating;
    private int userId;
    private int productId;
}
