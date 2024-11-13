  import java.util.*;

class C_Hamburgers {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String str = inp.next(); // recipe
        int nb = inp.nextInt(); // has nb pieces of bread
        int ns = inp.nextInt(); // has ns pieces of sausage
        int nc = inp.nextInt(); // has nc pieces of cheese
        int pb = inp.nextInt(); // price of piece of bread
        int ps = inp.nextInt(); // price of piece of sausage
        int pc = inp.nextInt(); // price of piece of cheese
        long r = inp.nextLong(); // rubles he has to shop

        int b = 0, s = 0, c = 0;
        for (char ch : str.toCharArray()) {
            switch (ch) {
                case 'B':
                    b++;
                    break;
                case 'S':
                    s++;
                    break;
                case 'C':
                    c++;
                    break;
            }
        }

        long l = 0, h = (long) 1e13;
        
        while(l<h)
        {
            long mid = l + (h-l+1)/2;
            long totalBread = mid*b;
            long totalSausage = mid*s;
            long totalCheese = mid*c;

            long extraBread = Math.max(0, totalBread - nb);
            long extraSausage = Math.max(0, totalSausage - ns);
            long extraCheese = Math.max(0, totalCheese - nc);

            long totalCost = extraBread*pb + extraSausage*ps + extraCheese*pc;

            if(totalCost <= r)
            {
                l = mid;
            }
            else
            {
                h = mid-1;
            }

        }
        System.out.println(l);

    }
}
