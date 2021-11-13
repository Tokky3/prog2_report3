package jp.ac.uryukyu.ie.e215711;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy {
    private String name;
    /**
     * Enemy.nameの文字列のgetter
     * @return getterで取り出したname。
     */
    public String getEnemyName(){
        return this.name;
    }
    /**
     * Enemy.nameの文字列のsetter
     * @param name フィールドに代入する名前。
     */
    public void setEnemyName(String name){
        this.name = name;
    }

    private int hitPoint;
    /**
     * Enemy.hitPointの数値のgetter。
     * @return　getterで取り出したhitPointの数値。
     */
    public int getEnemyHitPoint(){
        return this.hitPoint;
    }
    /**
     * Enemy.hitPointの数値のsetter。
     * @param hitPoint　フィールドに代入するHPの数値。
     */
    public void setEnemyHitPoint(int hitPoint){
        this.hitPoint = hitPoint;
    }

    private int attack;
    /**
     * Enemy.attackの数値のgetter。
     * @return getterで取り出したattackの数値。
     */
    public int getEnemyAttack(){
        return this.attack;
    }
    /**
     * Enemy.attackの数値のsetter。
     * @param attack　フィールドに代入するattackの数値。
     */
    public void setEnemyAttack(int attack){
        this.attack = attack;
    }

    private boolean dead;
    /**
     * Enemy.deadの真偽値のgetter。
     * @return TrueOrFale getterで取り出した真偽値。
     */
    public boolean isEnemyDead(){
        return this.dead;
    }
    /**
     * Enemy.deadの真偽値のsetter。
     * @param dead　敵の生死に関する真偽値。
     */
    public void setEnemyDead(boolean dead){
        this.dead = dead;
    }

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public Enemy (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * Heroへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param hero 攻撃対象
     */
    public void attack(Hero hero){
        if(hitPoint>0){
        int damage = (int)(Math.random() * attack);
        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, hero.getHeroName(), damage);// hero.name -> hero.getHeroName()
        hero.wounded(damage);
        }
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
            System.out.printf("モンスター%sは倒れた。\n", name);
        }
    }

}