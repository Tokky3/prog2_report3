import jp.ac.uryukyu.ie.e215711.*;

public class Main {
    public static void main(String[] args){
        Hero hero = new Hero("勇者", 10, 5);
        Enemy enemy = new Enemy("スライム", 6, 3);

        System.out.printf("%s vs. %s\n", hero.getHeroName(), enemy.getEnemyName());//hero.name -> hero.getHeroName() , enemy.name -> enemy.getEnemyname()

        int turn = 0;
        while( hero.isHeroDead() == false && enemy.isEnemyDead()== false ){//hero.dead -> hero.isHeroDead() , enemy.dead -> enemy.isEnemyDead()
            turn++;
            System.out.printf("%dターン目開始！\n", turn);
            hero.attack(enemy);
            enemy.attack(hero);
        }
        System.out.println("戦闘終了");
    }
}