package com.example.bd_board.service;

import com.example.bd_board.mapper.BoardMapper;
import com.example.bd_board.model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FileService {

    private final BoardMapper boardMapper;

    @Autowired
    public FileService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public int createFile(File file, Integer bno) {
        MultipartFile[] files = file.getFiles();

        int result= 0;
        if(files != null && files.length > 0) {
            for(int i = 0; i < files.length; i ++) {

                UUID uuid = UUID.randomUUID();
                String fname = files[i].getOriginalFilename();
                String fid = uuid + "_" + fname;

                String localPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";
                Path fpath = Paths.get(localPath, fid);

                try{
                    Files.createDirectories(fpath.getParent());
                    Files.copy(files[i].getInputStream(), fpath, StandardCopyOption.REPLACE_EXISTING);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                file.setFid(fid);
                file.setFname(fname);
                file.setFpath(String.valueOf(fpath));

                result+=boardMapper.createFile(file, bno);
            }
        }
        return result;
    }

    public List<File> getFileByNo(Integer bno) {
        return boardMapper.getFileByNo(bno);
    }

    public File download(String fid) {
        return boardMapper.download(fid);
    }

    public ArrayList<Integer> deleteFile(ArrayList<String> fid) {
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < fid.size(); i ++) {
            result.add(boardMapper.deleteFile(fid.get(i)));
        }
        return result;
    }
}
