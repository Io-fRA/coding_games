// Makes sense to use interface for a lot of unrelated classes
// that are desired to do a certain thing
public interface AnimalInterface {

    // Every field in an interface is static and final
    // because it is final you have to instantiate it
    // it does not necessarily make sense to have the age value for the subclasses
    int age = 0;

    // Every method is assumed to be abstract by default
    // But default methods can be used
    default void sound(){
        System.out.println("sound");
    }

    static String test() {
        return "Static method";
    }
}
