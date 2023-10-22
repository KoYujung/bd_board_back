package com.example.bd_board.service;

import com.example.bd_board.mapper.BoardMapper;
import com.example.bd_board.model.Board;
import com.example.bd_board.model.Comment;
import com.example.bd_board.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        if(board.getFiles() != null && board.getFiles().length > 0) {
            String uuid = UUID.randomUUID().toString();
            String originName = String.valueOf(board.getFiles()[0].getOriginalFilename());

            System.out.println(originName);
        }

        return boardMapper.createBoard(board);
    }

    public Board getBoardByNo(Integer no) {
        return boardMapper.getBoardByNo(no);
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