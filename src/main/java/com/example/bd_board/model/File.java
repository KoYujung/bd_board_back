package com.example.bd_board.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class File {
    MultipartFile[] files;
    private String fid;
    private String fname;
    private String fpath;
    private int bno;

}
