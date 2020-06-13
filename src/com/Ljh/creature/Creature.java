package com.Ljh.creature;

import com.Ljh.Room;
import com.Ljh.article.ArticleAttack;
import com.Ljh.article.ArticleDefense;
import com.Ljh.article.ArticleWeapon;


import java.util.ArrayList;


/**
 * @description:
 * @author: LiJiaHao
 * @date: Created in 2020/4/26 11:04
 * @version: 1.0
 * @modified By:
 */
public class Creature {
    private String id;
    private String description;//name
    private Room currentRoom;//当前位置
    private int Maxhp;//最大生命值
    private int hp;//生命值
    private int Exp;//经验值
    private int ExpVR;//升级所需要的经验值
    private int damage;//攻击力
    private int Mp;//法力值
    private int MaxMp;//最大法力值
    private int lv;//等级
    private ArticleAttack currentWeapon;//当前武器
    private ArticleDefense currentDefense;//当前防具

    private SkillSet skillSet;//技能

    private ArrayList<ArticleWeapon> articleWeapons = new ArrayList<>();

    //使用技能造成伤害
    public void UseSkill(Creature enemymonster,int damage){
        enemymonster.setHp(enemymonster.getHp()-damage);
    }

    //攻击函数
    public void attack(ArticleWeapon articleWeapon,Creature enemy){
        articleWeapon.useArticle(enemy);
    }

    //获取敌人的经验值函数
    public void getEnemyExp(Monster enemy){
        int value = enemy.getLeftExp();
        enemy.setLeftExp(0);
        this.Exp +=value;
    }

    //升级函数
    public void upGrade(){
        if(this.Exp >= this.ExpVR){
            this.lv++;
            setExp(this.Exp-this.ExpVR);
            this.ExpVR+=20;
            this.Maxhp+=20;
            this.damage+=10;
            this.MaxMp+=10;
            this.currentWeapon.setEffectValue(this.currentWeapon.getEffectValue()-10);
            setHp(this.Maxhp);
            setMp(this.MaxMp);
            System.out.println("您已升级，生命上限获得提升！");
        }
    }

    //法力值每回合增加函数
    public void MpUpdate(){
        if (this.Mp<this.MaxMp){
            this.Mp+=10;
        }
    }



    //防御函数，变相加血函数
    public void DefenseAddblood(int effectvalue){
        this.hp+=effectvalue;
    }


    public Creature() {
    }

    public Creature(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return Mp;
    }

    public void setMp(int mp) {
        Mp = mp;
    }

    public int getMaxMp() {
        return MaxMp;
    }

    public void setMaxMp(int maxMp) {
        MaxMp = maxMp;
    }

    public int getExp() {
        return Exp;
    }

    public void setExp(int exp) {
        Exp = exp;
    }

    public SkillSet getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(SkillSet skillSet) {
        this.skillSet = skillSet;
    }

    public Creature(String id, String description, int hp) {
        this.id = id;
        this.description = description;
        this.hp = hp;
    }

    public String getId() {
        return id;
    }

    public int getMaxhp() {
        return Maxhp;
    }

    public void setMaxhp(int maxhp) {
        Maxhp = maxhp;
    }

    public int getLv() {
        return lv;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getExpVR() {
        return ExpVR;
    }

    public void setExpVR(int expVR) {
        ExpVR = expVR;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public ArticleAttack getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(ArticleAttack currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public ArrayList<ArticleWeapon> getArticleWeapons() {
        return articleWeapons;
    }

    public ArticleDefense getCurrentDefense() {
        return currentDefense;
    }

    public void setCurrentDefense(ArticleDefense currentDefense) {
        this.currentDefense = currentDefense;
    }

    public void setArticleWeapons(ArrayList<ArticleWeapon> articleWeapons) {
        this.articleWeapons = articleWeapons;
    }
}
