package com.example.bd_board.mapper;

import com.example.bd_board.model.Board;
import com.example.bd_board.model.Comment;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> selectAll();

    int createBoard(Board board);

    Board getBoardByNo(Integer no);

    int updateBoardByNo(@Param("no") Integer no, @Param("board") Board board);

    int changeUseYN(Integer no);

    int deleteBoardByNo(Integer no);

    List<Board> searchBoard(@Param("type") String type, @Param("keyword") String keyword);

    int addComment(@Param("bno") Integer bno, @Param("comment") Comment comment);

    List<Comment> getComment(Integer bno);

    int countComment(Integer bno);

    int addView(Integer no);

    List<Board> getTop4Boards();
}