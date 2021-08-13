package com.joker.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: word_test
 * @author: Joker
 * @create: 2021-06-23 15:18
 * @Description: NULL
 **/
// 数据库实体类
@Data
// 无参构造
@NoArgsConstructor
// 有参构造
@AllArgsConstructor

public class Word {

    private int id;
    private String word;
    private String translation;
    private String senior;
    private String cet4;
    private String cet6;
    private String toefl;
    private String ielts;
    private String postgraduate;
    private String frequency;
    private int loca;

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

    public String getTranslation ( ) {
        return translation;
    }

    public void setTranslation ( String translation ) {
        this.translation = translation;
    }

    public String getSenior ( ) {
        return senior;
    }

    public void setSenior ( String senior ) {
        this.senior = senior;
    }

    public String getCet4 ( ) {
        return cet4;
    }

    public void setCet4 ( String cet4 ) {
        this.cet4 = cet4;
    }

    public String getCet6 ( ) {
        return cet6;
    }

    public void setCet6 ( String cet6 ) {
        this.cet6 = cet6;
    }

    public String getToefl ( ) {
        return toefl;
    }

    public void setToefl ( String toefl ) {
        this.toefl = toefl;
    }

    public String getIelts ( ) {
        return ielts;
    }

    public void setIelts ( String ielts ) {
        this.ielts = ielts;
    }

    public String getPostgraduate ( ) {
        return postgraduate;
    }

    public void setPostgraduate ( String postgraduate ) {
        this.postgraduate = postgraduate;
    }

    public String getFrequency ( ) {
        return frequency;
    }

    public void setFrequency ( String frequency ) {
        this.frequency = frequency;
    }

    public int getLoca ( ) {
        return loca;
    }

    public void setLoca ( int loca ) {
        this.loca = loca;
    }
}
