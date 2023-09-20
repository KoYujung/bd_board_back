package com.example.bd_board.model;

import lombok.Data;
import org.apache.coyote.http11.filters.SavedRequestInputFilter;

import java.sql.Date;

@Data
public class Board {

    private Integer member_id;
    private Integer no;
    private Date created_time;
    private String contents;
    private String title;

    private String filename;
    private String filepath;

    private String type;
    private String keyword;
}
