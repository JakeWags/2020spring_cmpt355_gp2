class ExpressiosnGroup1 {
    void f() {
        // Conditional expressions
        x = z ? y : w;

        x = (y > 100) ? 0
                : (y > 80) ? 1
                : (y > 60) ? 2
                : 3;
        /*
         * Make sure the above was parsed with the correct precedence! It should be equivalent to
         * (y > 100) ? 0 : ((y > 80) ? 1 : ((y > 60) ? 2 : (3)))
         */

        x = new int[][] { { 5, 2 }, { 1 } };
        System.out.println(new String[] {});
    }
}