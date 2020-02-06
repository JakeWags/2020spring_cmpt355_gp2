abstract class Fields {

    // Simple field declarations with access modifiers
    public int x;
    protected boolean alphabetical;
    short cake;
    private String name;
    public javax.swing.filechooser.FileView fileView;

    // Other modifiers
    private volatile double time;
    volatile transient private static byte hooey;

    // Initialization with declaration
    public static final String PIE = "Delicious";
    int year = 2020;
    double blah = Math.sqrt(5 * 4.8 + year);

    // Array fields
    public String[] names;
    static int[] MONTH_LENGTHS = new int[12];
    double[][][][][] stuff = new double[20000_0000][150][10*20][][];
}