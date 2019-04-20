public class ModelDuck extends Duck {
    public ModelDuck() {
        this.quackBehavior = new Quack();
        this.flyBehavior = new FlyNoWay();
    }

    public void display() {
        System.out.println("I'm a Model duck.");
    }
}