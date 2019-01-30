import java.util.*;


class TreeNode{
    int val;
    ArrayList<TreeNode> children;
    public TreeNode(int val){
        this.val = val;
        children = new ArrayList<>();
    }
}

class NodeWithDepth{
    TreeNode node;
    int maxDepth;
    public NodeWithDepth(TreeNode node, int maxDepth){
        this.node = node;
        this.maxDepth = maxDepth;
    }
}

public class LcaOfAnyTree{

    public static TreeNode findMaxDepthNodeLCA(TreeNode root){
        if(root == null || root.children.isEmpty()) return root;
        return depthFirstSearch(root).node;
    }

    public static NodeWithDepth depthFirstSearch(TreeNode root){
        if(root.children.isEmpty()) return new NodeWithDepth(root, 1);

        int size = root.children.size();
        int maxDepth = 0;

        NodeWithDepth returnNode= new NodeWithDepth(root, maxDepth);

        for(int i = 0; i < size; i++){
            NodeWithDepth tmp = depthFirstSearch(root.children.get(i));
            if(tmp.maxDepth > maxDepth){
                maxDepth = tmp.maxDepth;
                returnNode.node = tmp.node;
                returnNode.maxDepth = tmp.maxDepth + 1;
            }

            //Find multiple nodes which all are deepest leaf nodes
            else if(tmp.maxDepth == maxDepth){
                returnNode.node = root;
            }
        }

        return returnNode;
    }
    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        n1.children.add(n2);
        n1.children.add(n3);
        n1.children.add(n4);
        n2.children.add(n5);
        n2.children.add(n6);
        n4.children.add(n7);
        n5.children.add(n8);
        n5.children.add(n9);
        n6.children.add(n10);
//        TreeNode res = findMaxDepthNodeLCA(n3);
//        System.out.println(res.val);
//        System.out.println("-------------");
        System.out.println("n1: " + findMaxDepthNodeLCA(n1).val);
        System.out.println("n2: " + findMaxDepthNodeLCA(n2).val);
        System.out.println("n3: " + findMaxDepthNodeLCA(n3).val);
        System.out.println("n4: " + findMaxDepthNodeLCA(n4).val);
        System.out.println("n5: " + findMaxDepthNodeLCA(n5).val);
        System.out.println("n6: " + findMaxDepthNodeLCA(n6).val);
        System.out.println("n7: " + findMaxDepthNodeLCA(n7).val);
        System.out.println("n8: " + findMaxDepthNodeLCA(n8).val);
        System.out.println("n9: " + findMaxDepthNodeLCA(n9).val);
        System.out.println("n10: " + findMaxDepthNodeLCA(n10).val);
    }
}