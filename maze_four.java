public class maze_four {
    public static void main(String[] args) {
        paths(0, 0, 2, 2, new boolean[3][3], "");
    }

    protected static void paths(int cr, int cc, int er, int ec, boolean[][] vis, String direct) {
        if (cr < 0 || cc < 0 || cr > er || cc > ec || vis[cr][cc] == true)
            return;
        
        if (cr == er && cc == ec) {
            System.out.println(direct);
            return; 
        }

        vis[cr][cc] = true;
        paths(cr - 1, cc, er, ec, vis, direct + "U");
        paths(cr + 1, cc, er, ec, vis, direct + "D");
        paths(cr, cc - 1, er, ec, vis, direct + "L");
        paths(cr, cc + 1, er, ec, vis, direct + "R"); 
        vis[cr][cc] = false;
    }
}
