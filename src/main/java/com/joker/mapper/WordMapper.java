package com.joker.mapper;

import com.joker.pojo.Word;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Joker
 */
@Mapper
@Repository
public interface WordMapper {

    /**
     * 根据id查询单词
     */
    Word queryById ( int id );

    /**
     * 查询单词列表
     */
    List< Word > queryWordList ( );

    /**
     * 统计数据库总条数
     */
    int countTotal ( );

    /**
     * 根据排序查询单词
     */
    Word queryByLocal ( int local );

    /**
     * 根据英文字母查询
     */
    Word queryByWord ( String word );
}
