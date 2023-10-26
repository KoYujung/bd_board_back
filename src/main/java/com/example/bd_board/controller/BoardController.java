package com.example.bd_board.controller;

import com.example.bd_board.model.Board;
import com.example.bd_board.model.Comment;
import com.example.bd_board.model.File;
import com.example.bd_board.model.Member;
import com.example.bd_board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PostMapping("/create_file/{bno}")
    public int createBoard(@RequestBody File file, @PathVariable Integer bno) {
        return boardService.createFile(file, bno);
    }

    @GetMapping("/read_board/{no}")
    public ResponseEntity<Board> getBoardByNo(@PathVariable Integer no) throws IOException {
        Board board = boardService.getBoardByNo(no);
        if(board != null) {
            return ResponseEntity.ok(board);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @GetMapping("/download_file/{fid}")
//    public ResponseEntity<org.springframework.core.io.Resource> download(@PathVariable String fid) throws IOException {
//        Board board = boardService.download(fid);
//        Path path = Paths.get(String.valueOf(board.getFpath()));
//        org.springframework.core.io.Resource resource = new InputStreamResource(Files.newInputStream(path));
//        String encodeName = UriUtils.encode(String.valueOf(board.getFname()), StandardCharsets.UTF_8);
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fname=\"" + encodeName + "\"")
//                .contentType(MediaType.parseMediaType("application/octet-stream"))
//                .body(resource);
//    }

    @PutMapping("/delete_file/{fid}")
    public int deleteFile(@PathVariable String fid) {
        return boardService.deleteFile(fid);
    }

//    @PutMapping("/update_board/{no}")
//
//    public int updateBoard(@PathVariable Integer no, Board board) {
//        return boardService.updateBoard(no, board);
//    }

    @PutMapping("/change_UseYN")
    public ArrayList<Integer> changeUseYN(@RequestBody ArrayList<Integer> no) {
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

    @PostMapping("/add_comment/{bno}")
    public int addComment(@PathVariable Integer bno, @RequestBody Comment comment) {
        return boardService.addComment(bno, comment);
    }

    @GetMapping("/get_comment/{bno}")
    public List<Comment> getComment(@PathVariable Integer bno) {
        return boardService.getComment(bno);
    }

    @PutMapping("/delete_comment/{bno}")
    public int delComment(@PathVariable Integer bno) {
        return boardService.delComment(bno);
    }

    @GetMapping("/count_comment/{bno}")
    public int countComment(@PathVariable Integer bno) {
        return boardService.countComment(bno);
    }

    @PutMapping("/add_view/{no}")
    public int addView(@PathVariable Integer no) {
        return boardService.addView(no);
    }

    @GetMapping("/get_Top4Boards")
    public List<Board> getTop4Boards() {
        return boardService.getTop4Boards();
    }

    @PostMapping("/register_member")
    public int registerMember(@RequestBody Member member) {
        return boardService.registerMember(member);
    }

    @GetMapping("/get_member")
    public List<Member> getAllMembers() {
        return boardService.getAllMembers();
    }

    @PostMapping("/login")
    public Member login() {
        return boardService.login();
    }
}