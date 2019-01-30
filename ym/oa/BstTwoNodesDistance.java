public class BstTwoNodesDistance {

    static class BstTreeNode {
        BstTreeNode left, right;
        int key;

        BstTreeNode (int key){
            this.key = key;
            left = null;
            right = null;
        }

        BstTreeNode(BstTreeNode left, int key, BstTreeNode right){
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }

    private BstTreeNode root;

    public void CreateBSTree(int[] values,int n){
        for(int i=0;i<n;i++){
            add(values[i]);
        }
    }

    public void add(int item){
        if(root==null){
            root=new BstTreeNode(null,item,null);
        }else{
            add(root,item);
        }
    }
    public void add(BstTreeNode node,int item){
        if (item < node.key) {
            if (node.left == null) {
                node.left = new BstTreeNode(null, item, null);
            } else {
                add(node.left, item);
            }
        } else if (item > node.key) {
            if (node.right == null) {
                node.right = new BstTreeNode(null, item, null);
            } else {
                add(node.right, item);
            }
        }
    }


    public  int twoNodesDistance(int[] keyues, int n, int node1, int node2){
        BstTreeNode lcaNode = findLCANode(root, node1, node2);
        if (lcaNode == null){
            return -1;
        }

        int l1=toRootDistance(root, node1);
        int l2=toRootDistance(root, node2);
        int lcaNodeVal = lcaNode.key;
        int lcaDistance = toRootDistance(root, lcaNodeVal);
        return (l1 + l2) - 2 * lcaDistance;

    }

    public int toRootDistance(BstTreeNode root, int n) {
        return toRootDistanceHelp(root,n)-1;
    }

    public int toRootDistanceHelp(BstTreeNode root, int n) {
        if (root != null) {
            int x = 0;
            if ((root.key == n) || (x = toRootDistanceHelp(root.left, n)) > 0
                    || (x = toRootDistanceHelp(root.right, n)) > 0) {
                return x+1 ;
            }
            return 0;
        }
        return 0;
    }

    public BstTreeNode findLCANode(BstTreeNode root, int node1, int node2) {
        if (root != null) {
            if (root.key == node1 || root.key == node2) {
                return root;
            }
            BstTreeNode left = findLCANode(root.left, node1, node2);
            BstTreeNode right = findLCANode(root.right, node1, node2);

            if (left != null && right != null) {
                return root;
            }
            if (left != null) {
                return left;
            }
            if (right != null) {
                return right;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        BstTwoNodesDistance test=new BstTwoNodesDistance();
        int values[]={5,6,3,1,2,4};
//        int values[] = {1, 1, 1};

        int values_len = values.length;

        test.CreateBSTree(values, values_len);
//        BTreePrinter.printNode(test.root);
        int res=test.twoNodesDistance(values, values_len, 2, 4);
//        System.out.println(test.twoNodesDistance(values, values_len, 1, 1));
        System.out.println(test.twoNodesDistance(values, values_len, 2, 6));


//        System.out.println(test.root.key);
//        System.out.println(res);
    }


}