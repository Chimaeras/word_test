package com.joker.service;

import com.joker.mapper.WordMapper;
import com.joker.pojo.ReturnWord;
import com.joker.pojo.Word;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;


/**
 * @program: word_test
 * @author: Joker
 * @create: 2021-06-30 15:22
 * @Description: NULL
 **/

@Service
public class WordService {

    @Resource
    private WordMapper wordMapper;

    /**
     * 数组初始大小
     */
    private static int size = 10;

    /**
     * 当前单词索引
     */
    public static int count;

    /**
     * 单词List
     */
    private static ArrayList< Word > wordList = new ArrayList<>();

    /**
     * 结果List
     */
    private static ArrayList< ReturnWord > resList = new ArrayList<>();

    /**
     * 赋值函数 - 每次增加size个空间
     */
    public void assign ( ArrayList< Word > arrayList ) {
        // 根据公式生成测试单词组
        for ( int i = 0; i < size; i++ ) {
            // 数据库总单词数量
            int total = wordMapper.countTotal();
            // 根据组范围确定的随机数
            int c = ( int ) ( Math.random() * ( total / size ) );
            // 利用随机数生成测试组数据
            arrayList.add( wordMapper.queryByLocal( i * ( total / size ) + c ) );
        }
    }

    /**
     * set函数-初始化List
     */
    public void setWordList ( ) {
        System.out.println( Thread.currentThread().getName() );
        // 每次开始的时候 清空当前的wordList
        wordList.clear();
        // 清空当前的resList
        resList.clear();
        // 重置count
        count = 0;
        // 对wordList赋值
        assign( wordList );
        // 展示
        showWord( wordList );
    }

    /**
     * 扩容函数
     */
    public void expandList ( ) {
        // 对单词数组再次赋值，实现扩容
        assign( wordList );
        // 展示
        showWord( wordList );
    }

    /**
     * 保存前端返回的测试结果
     *
     * @param returnWord 测试结果
     */
    public void saveReturnWord ( ReturnWord returnWord ) {
        resList.add( returnWord );
    }

    /**
     * get函数-获取单词List
     *
     * @return -返回对象为Word的List
     */
    public ArrayList< Word > getWordList ( ) {
        return wordList;
    }

    /**
     * 根据当前索引进行查询
     *
     * @param count 当前索引
     *
     * @return Word类型 当前测试的单词类
     */
    public Word queryByCount ( int count ) {
        // 如果请求的单词数超过了初始数量，则进行扩容
        if ( count == wordList.size() ) {
            expandList();
        }
        System.out.println( Thread.currentThread().getName() );
        System.out.println( "查询 count:" + count );
        System.out.println( "查询 id:" + wordList.get( count ).getId() );

        return wordList.get( count );
    }

    /**
     * 展示测试单词数组
     *
     * @param arrayList 测试单词数组
     */
    public void showWord ( ArrayList< Word > arrayList ) {
        for ( Word word : arrayList ) {
            System.out.println( word.toString() );
        }
    }

    /**
     * 展示结果单词数组
     *
     * @param arrayList 结果单词数组
     */
    public void showReturnWord ( ArrayList< ReturnWord > arrayList ) {
        for ( ReturnWord word : arrayList ) {
            System.out.println( word.toString() );
        }
    }

    /**
     * 计算词汇量，并将结果赋值给vocabulary
     */
    public Integer calculate ( ) {
        // 展示结果数组
        showReturnWord( resList );
        System.out.println( Thread.currentThread().getName() );
        System.out.println( "返回结果" );

        // 将ID列转换成local列
        for ( ReturnWord returnWord : resList ) {
            returnWord.setId( wordMapper.queryById( returnWord.getId() ).getLoca() );
        }

        // 将resList按照local进行排序
        resList.sort( ( o1, o2 ) -> o1.getId() - o2.getId() );

        // 展示排序后的resList
        showReturnWord( resList );

        // 算法计算出最终词汇量
        int left = 0;
        int right = resList.size() - 1;

        while ( left < right ) {
            while ( resList.get( left ).getIsKnow() == 1 && left < right ) {
                left++;
            }
            while ( resList.get( right ).getIsKnow() == 0 && left < right ) {
                right--;
            }
            if ( resList.get( left ).getIsKnow() == 0 && resList.get( right ).getIsKnow() == 1 ) {
                resList.get( left ).setIsKnow( 1 );
                resList.get( right ).setIsKnow( 0 );
            }
        }

        // resList的左边第一个的ID列就是单词的local
        // 将ReturnWord转换成Word进行查询
        int vocabulary = wordMapper.queryByLocal( resList.get( left ).getId() ).getLoca();
        System.out.println( "词汇量：" + vocabulary );
        return vocabulary;
    }

}
