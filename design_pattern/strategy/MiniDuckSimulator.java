public class MiniDuckSimulator {
    public static void main(String... s) {
        Duck duck = new MallardDuck();
        duck.performFly();
        duck.performQuack();
        duck.display();

        Duck modelDuck = new ModelDuck();
        modelDuck.display();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyRocketPower());
        modelDuck.performFly();
    }
}