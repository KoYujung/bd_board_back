package com.example.bd_board.model;

import lombok.Data;

import java.sql.Date;

@Data
public class Comment {
    private Integer cno;
    private Integer bno;
    private Date c_created_time;
    private String c_contents;
    private String useYN;
    private String c_member_id;
}
