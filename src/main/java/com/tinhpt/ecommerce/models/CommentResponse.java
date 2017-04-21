package com.tinhpt.ecommerce.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentResponse {
    private int id;
    private String title;
    private String content;
    private double rating;
    private String ratedByUser;
    private Date createdDate;
}
