package com.example.bd_board.mapper;

import com.example.bd_board.model.Board;
import com.example.bd_board.model.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> selectAll();

    int createBoard(Board board);

    Board getBoardByNo(Integer no);

    int updateBoardByNo(@Param("no") Integer no, @Param("board") Board board);

    int changeUseYN(@Param("no") Integer no);

    int deleteBoardByNo(Integer no);

    List<Board> searchBoard(@Param("type") String type, @Param("keyword") String keyword);

    int registerMember(Board board);

    int addComment(@Param("no") Integer no, Comment comment);

}