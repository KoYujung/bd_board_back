package com.example.bd_board.service;

import com.example.bd_board.mapper.BoardMapper;
import com.example.bd_board.model.Board;
import com.example.bd_board.model.Comment;
import com.example.bd_board.model.Member;
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
public class BoardService {
    private final BoardMapper boardMapper;

    @Autowired
    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public List<Board> getAllBoards() {
        return boardMapper.selectAll();
    }

    public int createBoard(Board board) {
        MultipartFile[] files = board.getFiles();

        if(files != null && files.length > 0) {
            UUID uuid = UUID.randomUUID();
            String fname = files[0].getOriginalFilename();
            String fid = uuid + "_" + fname;

            String localPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";
            Path fpath = Paths.get(localPath, fid);

            try{
                Files.createDirectories(fpath.getParent());
                Files.copy(files[0].getInputStream(), fpath, StandardCopyOption.REPLACE_EXISTING);

            } catch (IOException e) {
                e.printStackTrace();
            }
            board.setFid(fid);
            board.setFname(fname);
            board.setFiles(files);
            board.setFpath(String.valueOf(fpath));
        }

        return boardMapper.createBoard(board);
    }

    public Board getBoardByNo(Integer no) {
        return boardMapper.getBoardByNo(no);
    }

    public Board download(String fid) {
        return boardMapper.download(fid);
    }

    public int updateBoard(Integer no, Board board) {
        return boardMapper.updateBoardByNo(no,board);
    }

    public ArrayList<Integer> changeUseYN(ArrayList<Integer> no) {
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < no.size(); i ++) {
            result.add(boardMapper.changeUseYN(no.get(i)));
        }
        return result;
    }

    public int deleteBoard(Integer no) {
        return boardMapper.deleteBoardByNo(no);
    }

    public List<Board> searchBoard(String type, String keyword) {
        return boardMapper.searchBoard(type, keyword);
    }

    public int addComment(Integer bno, Comment comment) {
        return boardMapper.addComment(bno, comment);
    }

    public List<Comment> getComment(Integer bno) {
        return boardMapper.getComment(bno);
    }

    public int delComment(Integer bno) {
        return boardMapper.delComment(bno);
    }

    public int countComment(Integer bno) {
        return boardMapper.countComment(bno);
    }

    public int addView(Integer no) {
        return boardMapper.addView(no);
    }

    public List<Board> getTop4Boards() {
        return boardMapper.getTop4Boards();
    }

    public int registerMember(Member member) {
        return boardMapper.registerMember(member);
    }

    public List<Member> getAllMembers() {
        return boardMapper.getAllMembers();
    }

    public Member login() {
        return boardMapper.login();
    }
}