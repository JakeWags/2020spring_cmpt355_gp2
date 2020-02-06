abstract public class Statements {

    void f() {
        // Blocks and local variable declarations
        {
            double y;
            {{{
                String x;
            }}}
            var x;
        }

        // Empty statements
        ;; ; ;;

        // Declarations with initializers
        double[] arr2 = new double[5];
        String[][][][][][][][][][][][] ridiculousMultidimensionalArray = new String[1][2][3][4][5][6][][][][][][];

        // Assignment
        int[] arr;
        arr = new int[20];
        y = 99;
        x += y - z;
        z >>>= x;

        // Increments and decrements
        ++i;
        j--;

        // Method calls
        System.out.println("Hello, parser world!");
        z = Math.pow(9, 7);
        someMethod(1, 2, "skip a few", 99, 100);

        // Return statements
        return;
        return "something";

        // Class instantiation
        new Thread();
        new javax.swing.JFrame(null, "Frame title", true);

        // If-then
        if (false);
        if (something) {}
        if (z) System.out.println("z, whatever that is");
        if (j) {
            System.out.println("j? OK, why not.");
            double z;
            // Another block why not.
            {
                int x;
            }
        }

        // If-then-else
        if (X); else;
        if (X) {} else {}
        if (X) {
            System.out.println("Case 1");
        } else
            System.out.println("Case 2");

        // If-then-elseif
        if (X)
            System.out.println("Case 1");
        else if (Y) {
            System.out.println("Case 2");
        }

        // If-then-elseif-else
        // (Make sure the else is attached to the second if in the parse tree!)
        if (X);
        else if (Y) {
            double x;
            System.out.println(x);
        } else
            System.out.println("else");

        // While loops
        while (true);
        while (X) System.out.println(++X);
        while (X) {
            ++X;
            System.out.printf("wombat %d\n", X++);
        }

        // Do-while loops
        do; while (X);
        do {} while (X);
        do {
            ++X;
            System.out.println(X);
        } while (X);

        // For loops
        for (;;);
        for (;;){}
        for (int i = 0;;);
        for (int i = 0; i < 10;) {
            System.out.println(i);
        }
        for (;;++i) {}
        for (f(); g(); z());
        for (x+=y-5; ; throw new CanOfSpam()) {
            int y = 0;
            y ^= 1;
        }

        // Break and continue
        break;
        continue;

        // Nested statements
        if (X) {
            while (X) {
                do Y(); while (Z);
            }

            for (var f = z(); f; throw new Tantrum()) {
                for (int g = z(); g; throw new Tantrum()) {
                    if (X) {
                        continue;
                    } else if (X) {
                        new Y();
                    } else {
                        break;
                    }
                }
            }
        }
    }
}