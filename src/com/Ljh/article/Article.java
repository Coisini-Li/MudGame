package com.Ljh.article;



/**
 * @description:
 * @author: LiJiaHao
 * @date: Created in 2020/5/30 15:39
 * @version: 1.0
 * @modified By:
 */
public class Article {
    private String id;
    private String description;

    private int price;//价值
    private int degree;//等级
    private int effectValue;//效果 进攻 防御 加血


    public Article() {
    }

    public Article(String id, String description, int effectValue) {
        this.id = id;
        this.description = description;
        this.effectValue = effectValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public int getEffectValue() {
        return effectValue;
    }

    public void setEffectValue(int effectValue) {
        this.effectValue = effectValue;
    }
}
