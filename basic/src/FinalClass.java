public final class FinalClass {
    // Does prevent any other class to extend it
    // next line cannot happen
    // public class FinalClassExtended extends FinalClass

    // cannot be reassigned
    public static final Integer VAL = 6;

    // cannot be overridden by subclasses
    public final void eat() {
        System.out.println("eat");
    }

}
