import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class GenericsPrinter<T extends Number & Serializable>{
    // Even if Serializable is an interface, it is still extends
    // Class name first, then interfaces

    T thingToPrint;

    public GenericsPrinter(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint);
    }

}



