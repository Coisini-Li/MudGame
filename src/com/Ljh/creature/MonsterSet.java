package com.Ljh.creature;

import java.util.ArrayList;

/**
 * @description:
 * @author: LiJiaHao
 * @date: Created in 2020/5/30 15:27
 * @version: 1.0
 * @modified By:
 */
public class MonsterSet {
    private ArrayList<Monster> monsters = new ArrayList<>();

    //增删改查CURD
    public void inset(Monster monster){
        monsters.add(monster);
    }

    public Monster select(String id){
        Monster monster = null;
        for (Monster item:monsters
             ) {
            if (item.getId().equals(id)){
                monster = item;
                break;
            }
        }
        return monster;
    }

    public Monster selectByRoomId(String id){
        Monster monster1 = null;
        for (Monster monster:monsters
             ) {
            if (monster.getCurrentRoom().getId().equals(id)){
                monster1 = monster;
                break;
            }
        }
        return monster1;
    }

    public void delete(String id){
        if (null != select(id)){
            monsters.remove(select(id));
        }
    }

    public void update(String id,int Hp){
        if (null != select(id)){
            select(id).setHp(Hp);
        }
    }
//

    public MonsterSet() {
    }

    public MonsterSet(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }


}
