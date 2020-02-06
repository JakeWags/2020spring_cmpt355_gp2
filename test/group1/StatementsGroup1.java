interface StatementsGroup1 {

    default void f() {
        // final variables must be initialized upon declaration. It's possible to check this with the parser, but I
        // suggest doing it in the semantic analyzer instead!
        final int x = 25;

        final double y = 11.8, z = x;

        java.lang.String cheese = "Münster", butterfly = "Schmetterling", age;

        int[] numbers = {1, 2, 3};
        final double[][][] cantthinkofanything = {{{5}, {}}, {{0}}};

        this.antelope(1, 2, 0.5, "Hi");
        super.antelop("never");

        for (int number : numbers) {
            if (number > 5)
                while (number > 5)
                    --number;
            else for (; number < 5; ++number);
        }

        for (var zebra : herd)
            herd.delete(zebra);

        switch (month) {
            case 1: System.out.println("Januar"); break;
            case 2: System.out.println("Februar");
            case 3:
            case 4:
            case 5:
            case 6: System.out.println("Juni"); break;
        }

        if (f())
            switch (f()) {
                default: break;
            }

    }
}