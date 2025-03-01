import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class BinaryTreeLevelOrderTraversal {


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        LinkedList<TreeNode> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                if (t != null){
                    level.add(t.val);
                    q.add(t.left);
                    q.add(t.right);
                }
            }
            if (!level.isEmpty()) list.add(level);
        }
        return list;
    }
}
