package com.bonc.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author:ChenZhiXiang
 * @Description:
 * @Date:Created in 14:12 2018/8/6
 * @Modified By:
 */
public class VisitorsCharacteristics implements Serializable {

    private Integer id;

    private String statMon;

    private String sexMNum;

    private String sexFNum;

    private String sexNNum;

    private String age50Num;

    private String age60Num;

    private String age70Num;

    private String age80Num;

    private String age90Num;

    private String age00Num;

    public VisitorsCharacteristics() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatMon() {
        return statMon;
    }

    public void setStatMon(String statMon) {
        this.statMon = statMon;
    }

    public String getSexMNum() {
        return sexMNum;
    }

    public void setSexMNum(String sexMNum) {
        this.sexMNum = sexMNum;
    }

    public String getSexFNum() {
        return sexFNum;
    }

    public void setSexFNum(String sexFNum) {
        this.sexFNum = sexFNum;
    }

    public String getSexNNum() {
        return sexNNum;
    }

    public void setSexNNum(String sexNNum) {
        this.sexNNum = sexNNum;
    }

    public String getAge50Num() {
        return age50Num;
    }

    public void setAge50Num(String age50Num) {
        this.age50Num = age50Num;
    }

    public String getAge60Num() {
        return age60Num;
    }

    public void setAge60Num(String age60Num) {
        this.age60Num = age60Num;
    }

    public String getAge70Num() {
        return age70Num;
    }

    public void setAge70Num(String age70Num) {
        this.age70Num = age70Num;
    }

    public String getAge80Num() {
        return age80Num;
    }

    public void setAge80Num(String age80Num) {
        this.age80Num = age80Num;
    }

    public String getAge90Num() {
        return age90Num;
    }

    public void setAge90Num(String age90Num) {
        this.age90Num = age90Num;
    }

    public String getAge00Num() {
        return age00Num;
    }

    public void setAge00Num(String age00Num) {
        this.age00Num = age00Num;
    }
}
