package com.joker.controller;

import com.joker.mapper.WordMapper;
import com.joker.pojo.ReturnWord;
import com.joker.pojo.Word;
import com.joker.service.WordService;
import javafx.application.Application;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.sql.Wrapper;
import java.util.List;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;


@RunWith ( SpringRunner.class )
@SpringBootTest
class WordControllerTest {


}
