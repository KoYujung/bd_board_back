package com.example.bd_board.service;

import com.example.bd_board.mapper.BoardMapper;
import com.example.bd_board.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return boardMapper.createBoard(board);
    }

    public Board getBoardByNo(Integer no) {
        return boardMapper.getBoardByNo(no);
    }
    public int updateBoard(Integer no, Board board) {
        return boardMapper.updateBoardByNo(no,board);
    }

    public int deleteBoard(Integer no) {
        return boardMapper.deleteBoardByNo(no);
    }

    public List<Board> searchBoard(String type, String keyword) {
        return boardMapper.searchBoard(type, keyword);
    }

}