package com.example.bd_board.controller;

import com.example.bd_board.model.Board;
import com.example.bd_board.model.Comment;
import com.example.bd_board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board")
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();
    }

    @PostMapping("/create_board")
    public int createBoard(@RequestBody Board board) {
        return boardService.createBoard(board);
    }

    @GetMapping("/read_board/{no}")
    public ResponseEntity<Board> getBoardByNo(@PathVariable Integer no) {
        Board board = boardService.getBoardByNo(no);
        if(board != null) {
            return ResponseEntity.ok(board);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update_board/{no}")
    public int updateBoard(@PathVariable Integer no, @RequestBody Board board) {
        return boardService.updateBoard(no, board);
    }

    @PutMapping("/change_UseYN/{no}")
    public ArrayList<Integer> changeUseYN(@PathVariable ArrayList<Integer> no){
        return boardService.changeUseYN(no);
    }

    @DeleteMapping("/delete_board/{no}")
    public int deleteBoardByNo(@PathVariable Integer no) {
        return boardService.deleteBoard(no);
    }

    @GetMapping("/search_board/{type}/{keyword}")
    public List<Board> searchBoard(@PathVariable String type, @PathVariable String keyword) {
        return boardService.searchBoard(type,keyword);
    }

    @PostMapping("/register_member")
    public int registerMember(@RequestBody Board board) {
        return boardService.registerMember(board);
    }

    @PostMapping("/add_comment/{bno}")
    public int addComment(@PathVariable Integer bno, @RequestBody Comment comment) {
        return boardService.addComment(bno, comment);
    }

    @GetMapping("/get_comment/{bno}")
    public List<Comment> getComment(@PathVariable Integer bno) {
        return boardService.getComment(bno);
    }
}