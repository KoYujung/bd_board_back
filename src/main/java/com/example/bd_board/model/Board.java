package com.example.bd_board.model;

import lombok.Data;
import java.sql.Date;

@Data
public class Board {

    private Integer member_id;
    private Integer no;
    private Date created_time;
    private String contents;
    private String title;
    private String useYN;

    private String type;
    private String keyword;
}
