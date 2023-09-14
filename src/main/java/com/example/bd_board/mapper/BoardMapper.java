package com.example.bd_board.mapper;

import com.example.bd_board.model.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("SELECT * FROM board_db")
    List<Board> selectAll();

    @Insert("INSERT INTO board_db (title, contents, member_id) VALUES (#{title}, #{contents}, #{member_id})")
    @Options(useGeneratedKeys = true, keyProperty = "no")
    int createBoard(Board board);

    @Select("SELECT * from board_db WHERE no = #{no}")
    Board getBoardByNo(Integer no);

    @Update("UPDATE board_db SET title = #{board.title}, contents = #{board.contents}, member_id = #{board.member_id} WHERE no = #{no}")
    int updateBoardByNo(@Param("no") Integer no, @Param("board") Board board);

    @Delete("DELETE from board_db WHERE no = #{no}")
    int deleteBoardByNo(Integer no);
}