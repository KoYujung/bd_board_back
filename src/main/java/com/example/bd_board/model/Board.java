package com.example.bd_board.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;
import java.sql.Date;

@Data
public class Board {

    private Integer member_id;
    private Integer no;
    private Date created_time;
    private String contents;
    private String title;
    private String useYN;
    private Integer view;

    private String type;
    private String keyword;

    private MultipartFile[] files;
    private String fid;
    private String fname;
    private String fpath;
    private String fileYN;
}
