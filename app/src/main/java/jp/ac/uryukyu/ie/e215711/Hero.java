package jp.ac.uryukyu.ie.e215711;

/**
 * ヒーロークラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Hero {
    private String name;
    /**
     * Hero.nameの文字列のgetter。
     * @return getterで取り出したname。
     */
    public String getHeroName(){
        return this.name;
    }
    /**
     * Hero.nameの文字列のsetter。
     * @param name フィールドに代入する名前。
     */
    public void setHeroName(String name){
        this.name = name;
    }

    private int hitPoint;
    /**
     * Hero.hitPointの数値のgetter。
     * @return getterで取り出したhitPoint。
     */
    public int getHeroHitPoint(){
        return this.hitPoint;
    }
    /**
     * Hero.hitPointの数値のetter。
     * @param hitPoint フィールドに代入するHPの値。
     */
    public void setHeroHitPoint(int hitPoint){
        this.hitPoint = hitPoint;
    }

    private int attack;
    /**
     * Hero.attackの数値のgetter。
     * @return getterで取り出したattack。
     */
    public int getHeroAttack(){
        return this.attack;
    }
    /**
     * Hero.attackの数値のsetter。
     * @param attack フィールドに代入するattackの値。
     */
    public void setHeroAttack(int attack){
        this.attack = attack;
    }

    private boolean dead;
    /**
     * Hero.deadの真偽値のgetter。
     * @return　TrueOrFalse 勇者の生死に関する真偽値。
     */
    public boolean isHeroDead(){
        return this.dead;
    }
    /**
     * Hero .deadの真偽値のsetter。
     * @param dead 真偽値。
     */
    public void setHeroDead(boolean dead){
        this.dead = dead;
    }

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name ヒーロー名
     * @param maximumHP ヒーローのHP
     * @param attack ヒーローの攻撃力
     */
    public Hero (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * Enemyへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param e 攻撃対象
     */
    public void attack(Enemy e){
        int damage = (int)(Math.random() * attack);
        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, e.getEnemyName(), damage);//e.name -> e.getEnemyName()
        e.wounded(damage);
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", name);
        }
    }
}