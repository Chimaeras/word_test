package com.joker.controller;

import com.joker.mapper.WordMapper;
import com.joker.pojo.ReturnWord;
import com.joker.pojo.Word;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.*;
import com.joker.service.WordService;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.Future;

@RestController
public class WordController {

    @Resource
    private WordMapper wordMapper;
    @Resource
    private WordService wordService;

    /**
     * 查询所有单词信息
     */
    @GetMapping ( "/queryWordList" )
    public Future< List< Word > > queryUserList ( ) {
        return AsyncResult.forValue( wordMapper.queryWordList() );
    }

    /**
     * 根据单词查询
     */
    @GetMapping ( "/queryByWord/{word}" )
    public Future< Word > queryByWord ( @PathVariable String word ) {
        return AsyncResult.forValue( wordMapper.queryByWord( word ) );
    }

    /**
     * 根据id进行查询
     */
    @GetMapping ( "/queryById/{id}" )
    public Future< Word > queryById ( @PathVariable int id ) {
        return AsyncResult.forValue( wordMapper.queryById( id ) );
    }

    /**
     * 根据排序进行查询
     */
    @GetMapping ( "/queryByLoca/{local}" )
    public Future< Word > queryByLocal ( @PathVariable int local ) {
        return AsyncResult.forValue( wordMapper.queryByLocal( local ) );
    }

    /**
     * 根据count进行查询
     */
    @GetMapping ( "/queryByCount/{count}" )
    public Word queryByCount ( @PathVariable int count ) {
        return wordService.queryByCount( count );
    }

    /**
     * 返回测试结果
     */
    @GetMapping ( "/getResult" )
    public Integer result ( ) {
        return wordService.calculate();
    }

    /**
     * 开始测试，初始化单词List
     */
    @RequestMapping ( value = "/Start" )
    @Async ( "testExecutor" )
    public void saveWordNumber ( ) {
        wordService.setWordList();
    }

    /**
     * 接收前端返回的数据，存入结果单词组
     */
    @RequestMapping ( value = "/returnWord", method = RequestMethod.POST )
    public void save ( @RequestBody ReturnWord returnWord ) {
        wordService.saveReturnWord( returnWord );
    }


}
