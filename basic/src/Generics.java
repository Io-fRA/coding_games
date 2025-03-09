import java.util.ArrayList;
import java.util.List;

public class Generics {

    public static void main(String[] args) {

        GenericsPrinter<Integer> genericsPrinterInt = new GenericsPrinter<>(3);
        genericsPrinterInt.print();

        GenericsPrinter<Double> genericsPrinterDbl = new GenericsPrinter<>(20.0);
        genericsPrinterDbl.print();

        shout("test", 3);
        shout("generics", 8);

        List<Integer> l = new ArrayList<>();
        l.add(3);
        printList(l);

    }

    private static <T, V> void shout (T thingToShout, V otherOne) {
        System.out.println(thingToShout + " !!!");
        System.out.println(otherOne + " !!!");
    }

    // wildcards
    private static void printList (List<? extends Number> l) {
        // Cannot have Object instead of the ? because
        // List<Integer> is not a subclass of List<Object>
        System.out.println();
    }
}
