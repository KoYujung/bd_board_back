package com.example.bd_board.service;

import com.example.bd_board.mapper.BoardMapper;
import com.example.bd_board.model.Board;
import com.example.bd_board.model.Comment;
import com.example.bd_board.model.File;
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
        boardMapper.createBoard(board);

        if(!(board.getNo() == null)) {
            return board.getNo();
        } else {
            return boardMapper.createBoard(board);
        }
    }

    public Board getBoardByNo(Integer no) {
        return boardMapper.getBoardByNo(no);
    }

    public ArrayList<Integer> changeUseYN(ArrayList<Integer> no) {
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < no.size(); i ++) {
            result.add(boardMapper.changeUseYN(no.get(i)));
        }
        return result;
    }

    public int updateBoard(Integer no, Board board) {
        return boardMapper.updateBoard(no, board);
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