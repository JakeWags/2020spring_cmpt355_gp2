class Expressions {
    void f() {
        // Literals
        x = 25;
        x = 0xbeadedL;
        x = 928.238723872;
        x = .1f;
        x = 1e90;
        x = true;
        x = false;
        x = ' ';
        x = '\n';
        x = '\\';
        x = "";
        x = " ";
        x = "stuff in a string";
        x = null;

        // Variable/field reference
        x = y;
        x = too.many.dots.to.take.seriously.but.what.can.you.____dew;

        // Array subscripting
        x = args[0];
        x = stuff[0][1][2];

        // Pre-/post-increments
        x = --x;
        x = x++ + ++x;

        // Unary operators
        x = -x;
        x = +x;
        x = ~x;
        x = !x;

        // Binary operators
        x = x + x;
        x = x % x;
        x = x << y;
        x = x & x;
        x = x || x;
        x = x == x;

        // Binary operators - associativity
        x = x + x + x + x + x; // should associate to the left
        x = x << x << x << x;  // all binary operators associate to the left, except...
        x = x = x = x = x = x; // should associate to the right

        // Precedence (correct grouping shown in comments)
        x = x + y * z;              // x + (y * z)
        x = z += w < x - y;         // z += (w < (x - y))
        x = w >> !y || z;           // (w >> (!y)) || z
        x = z |= w != x % y;        // z |= (w != (x % y))
        x = ~w * y + z;             // ((~w) * y) + z
        x = w == x && y / z;        // (w == x) && (y / z)
        x = u % v++ ^ w >>> y | z;  // ((u % (v++)) ^ (w >>> y)) | z
        x = z %= !u || v - w * y;   // z %= ((!u) || (v - (w * y)))
        x = u == v++ ^ x & y << z;  // (u == (v++)) ^ (x & (y << z))

        // instanceof
        x = cheese instanceof Munster;
        x = str instanceof java.io.PrintStream;

        // Assignment and combined assignment
        x = y = z;
        x = u += v += w += x += y += z;
        x.y.z = x;
        (x.y).z = x;
        this.x = x;

        // Method call
        x = Math.pow(y, z);
        x = Math.sqrt(Math.PI);
        x = f(1, 2, "skip a few", 99, 100);

        // Class instantiation
        x = new Badger("Henriette");
        x = new javax.swing.JFrame(null, "A window", true);

        // Array creation
        x = new int[25];
        x = new int[y * z + 1];
        x = new int[a][b][c][d][][][][][][][];

        // Cast
        x = (String)y;
        x = (int)(double)(java.lang.Double[])(java.lang.Object)something;

        // this reference
        x = this.x;
        this.x = this.x;

        // Parentheses for grouping
        x = (x);
        x = (1 + 2) * 3;

        // Combinations of the above
        (x.y).z = (((Math.sin(stuff, 0x200000__4b)))) >>> f(null, 1e5f / null) instanceof String;
        x = new Excuse("cold hands")[25][y] && ++everyCheeseEver;
    }
}