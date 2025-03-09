
public abstract class AnimalAbstract {
    int t;

    abstract void makeSound();

    private void sound(){
        System.out.println("sound");
    }

    static String test() {
        return "Static method";
    }
}