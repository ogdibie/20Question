/**
 * Created with IntelliJ IDEA.
 * User: Ogheneruona
 * Date: 1/4/15
 * Time: 12:13 AM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Used in modeling a Tree data structure
 */
public class TreeNode {
    private String item;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(String item) {
        this.item = item;
        left = null;
        right = null;
    }

    public TreeNode(String item, TreeNode left, TreeNode right) {
        this.item = item;
        this.right = right;
        this.left = left;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    /**
     *
     * @return   true of tree Node is a leaf Node
     */
    public boolean isaleaf(){
        return (this.right == null && this.left==null) ;
    }

    /**
     * Print the root in an in order display Pattern
     * @param root
     */
    public  static void inorderdisplay(TreeNode root){
        if (root == null)
            return;
        else{
            inorderdisplay(root.getLeft());
            System.out.println(root.getItem());
            inorderdisplay(root.getRight());
        }
    }
}
