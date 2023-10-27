package com.example.bd_board.controller;

import com.example.bd_board.model.Board;
import com.example.bd_board.model.File;
import com.example.bd_board.service.BoardService;
import com.example.bd_board.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileController {
    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }
    @PostMapping("/create_file/{bno}")
    public int createFile(File file, @PathVariable Integer bno) {
        return fileService.createFile(file, bno);
    }

    @GetMapping("/read_file/{bno}")
    public ResponseEntity<File> getFileByNo(@PathVariable Integer bno) throws IOException {
        File file = fileService.getFileByNo(bno);
        if(file != null) {
            return ResponseEntity.ok(file);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/download_file/{fid}")
    public ResponseEntity<Resource> download(@PathVariable String fid) throws IOException {
        File file = fileService.download(fid);
        Path path = Paths.get(String.valueOf(file.getFpath()));
        org.springframework.core.io.Resource resource = new InputStreamResource(Files.newInputStream(path));
        String encodeName = UriUtils.encode(String.valueOf(file.getFname()), StandardCharsets.UTF_8);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fname=\"" + encodeName + "\"")
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }
    @PutMapping("/delete_file/{fid}")
    public int deleteFile(@PathVariable String fid) {
        return fileService.deleteFile(fid);
    }
}
