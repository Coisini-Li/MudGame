package com.Ljh;

import com.Ljh.article.*;

import com.Ljh.creature.*;
import com.Ljh.handler.*;

import java.util.*;


/**
 * @description:
 * @author: LiJiaHao
 * @date: Created in 2020/5/31 22:04
 * @version: 1.0
 * @modified By:
 */
public class Sense {
    Person person = new Person();

    MonsterZombies monsterZombies = new MonsterZombies();
    MonsterPuppet monsterPuppet = new MonsterPuppet();
    MonsterTaoistMaster monsterTaoistMaster = new MonsterTaoistMaster();
    MonsterGluttony monsterGluttony = new MonsterGluttony();
    MonsterEmperorQin monsterEmperorQin = new MonsterEmperorQin();

    Eggshell eggshell = new Eggshell();

    SkillSet skillSet = new SkillSet();
    MonsterSet monsterSet = new MonsterSet();
    RoomSet roomSet = new RoomSet();

    private HashMap<String, Handler> handlders =new HashMap<String, Handler>();



    public Sense(){
        handlders.put("go", new HandlerGo(this));
        handlders.put("bye", new HandlerBye(this));
        handlders.put("help",new HandlerHelp(this));
        handlders.put("chop",new HandlerChop(this));
        handlders.put("use",new HandlerUse(this));

        initRoomAndMonster();
    }



    public void initSence(){
        initPerson();
        initMonster();
        initRoomAndMonster();
    }

    public void initRoomAndMonster(){
        Room room1,room2,room3,room4,room5,room6,room7;
        room1 = new Room("r1","盘龙山");
        room2 = new Room("r2","黑风墓道");
        room3 = new Room("r3","九州大地");
        room4 = new Room("r4","桃园冢");
        room5 = new Room("r5","幽冥溶洞");
        room6 = new Room("r6","皇陵地宫");
        room7 = new Room("r7","您即将到达飞升之路————府邸");

        room1.setExits("r2",room2);//盘龙山->黑风墓道

        room2.setExits("r3",room3);//黑风墓道->九州大地

        room3.setExits("r4",room4);//九州大地->r4

        room4.setExits("r5",room5);

        room5.setExits("r6",room6);

        room6.setExits("r7",room6);

        roomSet.getRooms().add(room1);
        roomSet.getRooms().add(room2);
        roomSet.getRooms().add(room3);
        roomSet.getRooms().add(room4);
        roomSet.getRooms().add(room5);
        roomSet.getRooms().add(room6);
        roomSet.getRooms().add(room7);

        room1.setMonster(monsterZombies);
        room2.setMonster(monsterPuppet);
        room3.setMonster(eggshell);
        room4.setMonster(monsterTaoistMaster);
        room5.setMonster(monsterGluttony);
        room6.setMonster(monsterEmperorQin);

        person.setCurrentRoom(room1);
    }

    public void goRoom(String direction)
    {
        Room nextRoom = person.getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            System.out.println("那里无法进入，请重新输入！");
        }
        else if (person.getCurrentRoom().getMonster().getHp() == 0){
            person.setCurrentRoom(nextRoom);
            person.MpUpdate();
        }
        else {
            System.out.println("此地妖怪未消灭，下一关通道未打开！");
        }
        if (person.getCurrentRoom().getId().equals("r2"))
            Ui.Show_2();
        if (person.getCurrentRoom().getId().equals("r3"))
            Ui.Show_3();
        if (person.getCurrentRoom().getId().equals("r4"))
            Ui.Show_4();
        if (person.getCurrentRoom().getId().equals("r5"))
            Ui.Show_5();
        if (person.getCurrentRoom().getId().equals("r6"))
            Ui.Show_6();
        showPromptAndProcess();
    }

    public void initPerson(){
        //基础属性
        person.setId("p1");
        person.setDescription("小李");
        person.setHp(200);
        person.setMaxhp(200);
        person.setLv(1);
        person.setExp(0);
        person.setExpVR(100);
        person.setDamage(30);
        person.setMp(100);
        person.setMaxMp(100);
        //技能
        skillSet.inset("Q","贯星长枪");
        skillSet.inset("W","斗枪越击");
        skillSet.inset("E","神佑枪阵");
        skillSet.inset("R","大荒星陨");

        //防具
        person.setCurrentDefense(new ArmorDefense("A1","御龙甲",10));


        //武器
        person.setCurrentWeapon(new KnifeAttack("k1","白鸟朝凤枪",-30));


    }

    public void initMonster(){

        monsterZombies.setId("zom");
        monsterZombies.setDescription("大力士僵尸");
        monsterZombies.setHp(80);
        monsterZombies.setLeftExp(60);
        monsterZombies.setCurrentRoom(roomSet.getRooms().get(0));
        monsterZombies.setCurrentWeapon(new BareHandedAttack("claws1","开天爪",-30));

        monsterPuppet.setId("pup");
        monsterPuppet.setDescription("守墓傀儡");
        monsterPuppet.setHp(120);
        monsterPuppet.setLeftExp(80);
        monsterPuppet.setCurrentRoom(roomSet.getRooms().get(1));
        monsterPuppet.setCurrentWeapon(new BareHandedAttack("hammer","金刚锤",-40));

        //彩蛋
        eggshell.setId("egg");
        eggshell.setDescription("彩蛋怪物，随机使你的攻击力提升或等级提升一级！");
        eggshell.setLeftExp(120);
        eggshell.setHp(9999);
        eggshell.setCurrentRoom(roomSet.getRooms().get(2));

        monsterTaoistMaster.setId("tao");
        monsterTaoistMaster.setDescription("阴阳天师");
        monsterTaoistMaster.setHp(150);
        monsterTaoistMaster.setLeftExp(100);
        monsterTaoistMaster.setCurrentRoom(roomSet.getRooms().get(3));
        monsterTaoistMaster.setCurrentWeapon(new BareHandedAttack("gossip","八卦掌",-50));

        monsterGluttony.setId("glu");
        monsterGluttony.setDescription("神兽饕餮");
        monsterGluttony.setHp(150);
        monsterGluttony.setLeftExp(90);
        monsterGluttony.setCurrentRoom(roomSet.getRooms().get(4));
        monsterGluttony.setCurrentWeapon(new BareHandedAttack("collision","蛮横冲撞",-60));

        monsterEmperorQin.setId("qin");
        monsterEmperorQin.setDescription("秦始龙尸皇");
        monsterEmperorQin.setHp(240);
        monsterEmperorQin.setCurrentRoom(roomSet.getRooms().get(5));
        monsterEmperorQin.setCurrentWeapon(new BareHandedAttack("Dragon","屠龙九天",-70));



        //增
        monsterSet.inset(monsterZombies);
        monsterSet.inset(monsterPuppet);
        monsterSet.inset(monsterTaoistMaster);
        monsterSet.inset(monsterGluttony);
        monsterSet.inset(monsterEmperorQin);
        monsterSet.inset(eggshell);
    }

    public void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到九州秦始龙陵！");
        System.out.println("这是一个通关小游戏,打败最后的敌人秦始尸皇你则获得胜利！");
        System.out.println("不知道怎么玩？输入 help试试看！");
        System.out.println();

        Ui.Show_1();

        showPromptAndProcess();
    }

    public void showPromptAndProcess(){
        boolean flag = false;
        System.out.println("======================================================================================================================");


        for (Monster monsters: monsterSet.getMonsters()
             ) {
            if (monsters.getCurrentRoom().getId().equals(person.getCurrentRoom().getId())){
                if (monsters.getHp() <= 0) {//控制敌人血量不为负
                    monsters.setHp(0);
                    flag = true;
                    person.getEnemyExp(monsters);//人获取经验值
                    person.upGrade();
                }
                if (!monsters.getId().equals("egg")) {
                    System.out.print("此处的敌人有:  ");//敌人状态属性
                    System.out.println(monsters.getId() + "  " + monsters.getDescription() + "  血量: " + monsters.getHp() +
                            "  攻击力: " + -monsters.getCurrentWeapon().getEffectValue() + "  技能:  " + monsters.getCurrentWeapon().getDescription());
                    break;
                }
                else {
                    eggshell.Random();
                    person.getEnemyExp(eggshell);//人获取经验值
                    person.upGrade();
                    break;
                }
            }
        }
        System.out.print(person.getDescription()+" 你目前在  " + person.getCurrentRoom());//你的状态
        System.out.println("  你的状态: 血量: "+person.getHp()+" 攻击力: "+person.getDamage()+" 法力值: "+person.getMp()+
                "  等级: "+person.getLv()+"  当前经验值: "+person.getExp());
        System.out.println("你的技能:  "+skillSet.getSkills().entrySet()+
                "  武器: "+person.getCurrentWeapon().getDescription()+
                "  攻击力: "+-person.getCurrentWeapon().getEffectValue()+
                "  防具: " +person.getCurrentDefense().getDescription()+"  防御力: "
                +person.getCurrentDefense().getEffectValue());
        if (flag){
            ProcessOptimization();//关卡钥匙
        }
       // person.MpUpdate();
        System.out.println("======================================================================================================================");
    }

    public void ProcessOptimization(){
            System.out.println("当前场景敌人已死亡，获得前往下一关的钥匙，可前往下一关！");
            System.out.print("出口有:  ");
            System.out.print(person.getCurrentRoom().getExitDesc());
            System.out.println(roomSet.getRooms().get(roomSet.getRooms().indexOf(person.getCurrentRoom())+1));
    }

    public void play(){

        //   随机地图彩蛋
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            String[] words = line.split(" ");
            Handler handler = handlders.get(words[0]);
            String value = "";
            if (words.length > 1){
                value = words[1];
            }
            if (monsterSet.getMonsters().get(4).getHp() == 0 ){
                //结束语句
                System.out.println("恭喜您已完成全部关卡，您已晋级飞升之路！");
                break;
            }
            else if (handler != null) {
                handler.doCmd(value);
                if (handler.isBye())
                    break;
            }
            else {
                System.out.println("输入错误命令，重新输入。");
            }
            if (person.getHp() <= 0){
                System.out.println("您已死亡！");
                break;
            }
        }
        System.out.println("感谢您的游玩，敬请期待下一版本飞升之路的更新！");
    }

    public SkillSet getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(SkillSet skillSet) {
        this.skillSet = skillSet;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public MonsterZombies getMonsterZombies() {
        return monsterZombies;
    }

    public void setMonsterZombies(MonsterZombies monsterZombies) {
        this.monsterZombies = monsterZombies;
    }

    public MonsterPuppet getMonsterPuppet() {
        return monsterPuppet;
    }

    public void setMonsterPuppet(MonsterPuppet monsterPuppet) {
        this.monsterPuppet = monsterPuppet;
    }

    public MonsterTaoistMaster getMonsterTaoistMaster() {
        return monsterTaoistMaster;
    }

    public void setMonsterTaoistMaster(MonsterTaoistMaster monsterTaoistMaster) {
        this.monsterTaoistMaster = monsterTaoistMaster;
    }

    public MonsterGluttony getMonsterGluttony() {
        return monsterGluttony;
    }

    public void setMonsterGluttony(MonsterGluttony monsterGluttony) {
        this.monsterGluttony = monsterGluttony;
    }

    public MonsterEmperorQin getMonsterEmperorQin() {
        return monsterEmperorQin;
    }

    public void setMonsterEmperorQin(MonsterEmperorQin monsterEmperorQin) {
        this.monsterEmperorQin = monsterEmperorQin;
    }

    public MonsterSet getMonsterSet() {
        return monsterSet;
    }

    public void setMonsterSet(MonsterSet monsterSet) {
        this.monsterSet = monsterSet;
    }

    public RoomSet getRoomSet() {
        return roomSet;
    }

    public void setRoomSet(RoomSet roomSet) {
        this.roomSet = roomSet;
    }

    public HashMap<String, Handler> getHandlders() {
        return handlders;
    }

    public void setHandlders(HashMap<String, Handler> handlders) {
        this.handlders = handlders;
    }
}
