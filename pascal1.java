import java.util.ArrayList;
import java.util.List;

public class pascal1 {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> res = new ArrayList<>();
       List<Integer> ans = new ArrayList<>();
       solve(numRows,res,ans);
       return res; 
    }
    private static void solve(int numRows,List<List<Integer>> res, List<Integer> ans)
    {
        ans.add(1);
        res.add(new ArrayList<>(ans));
        for (int i = 2; i <= numRows; i++){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 0; j < ans.size() - 1; j++) {
			    list.add(ans.get(j) + ans.get(j + 1)); 
		    }
            list.add(1);
            res.add(list);
            ans=list;
        }
    }
} {
    
}
