public class Arrays {

    public static void testingArrays () {
        int[] tab = new int[5];
        tab[0] = 0;
        tab[1] = 6;
        tab[2] = 5;
        tab[3] = 7;
        tab[4] = 1;
        java.util.Arrays.sort(tab);
        tab = java.util.Arrays.stream(tab).sorted().toArray();

        int[] tab2;
        tab2 = java.util.Arrays.copyOf(tab, tab.length);
        System.arraycopy(tab, 0, tab2, 0, tab.length);

        tab2 = java.util.Arrays.copyOfRange(tab, 0, 3);
    }

}
