package com.Ljh.creature;


import com.Ljh.article.ArticleWeapon;



/**
 * @description:
 * @author: LiJiaHao
 * @date: Created in 2020/5/30 15:08
 * @version: 1.0
 * @modified By:
 */
public  class Person extends Creature {

    @Override
    public void upGrade() {
        super.upGrade();
    }

    @Override
    public void getEnemyExp(Monster enemy) {
        super.getEnemyExp(enemy);
    }

    @Override
    public void attack(ArticleWeapon articleWeapon, Creature enemy) {
        articleWeapon.useArticle(enemy);
    }

    public Person(String id, String description) {
        super(id, description);
    }

    public Person(String id, String description, int hp) {
        super(id, description, hp);
    }

    public Person() {
    }

}
