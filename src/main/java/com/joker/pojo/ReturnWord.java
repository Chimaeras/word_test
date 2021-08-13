package com.joker.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: word_test
 * @author: Joker
 * @create: 2021-06-24 11:10
 * @Description: NULL
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnWord {
    private int id;
    private String word;
    private int isKnow;
    private int count;


    public int getId ( ) {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public String getWord ( ) {
        return word;
    }

    public void setWord ( String word ) {
        this.word = word;
    }

    public int getIsKnow ( ) {
        return isKnow;
    }

    public void setIsKnow ( int isKnow ) {
        this.isKnow = isKnow;
    }

    public int getCount ( ) {
        return count;
    }

    public void setCount ( int count ) {
        this.count = count;
    }
}
