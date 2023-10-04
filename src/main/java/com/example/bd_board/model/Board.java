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

    private Integer cno;
    private Integer bno;
    private Date c_created_time;
    private String c_contents;
    private String c_useYN;
}
