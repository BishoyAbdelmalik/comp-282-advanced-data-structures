import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class StringAVLTree {

    // should really be private but I need access
    // for my test program to work
    StringAVLNode root;
    // just one constructor
    public StringAVLTree() {
        this.root=null;
    }
    // Rotate the node to the right
    private static StringAVLNode rotateRight(StringAVLNode t) {
        //System.out.println("rotated right");
        StringAVLNode newRoot=t.getLeft();// get the pointer to the new root
        t.setLeft(t.getLeft().getRight());//set left pointer of the old root to the right of the new root
        newRoot.setRight(t);//set the right of the new root to the old root
        t=newRoot;//new root equal to t so we return it
        return t;
    }
    // Rotate the node to the left
    private static StringAVLNode rotateLeft(StringAVLNode t) {
        //System.out.println("rotated left");
        StringAVLNode newRoot=t.getRight();// get the pointer to the new root
        t.setRight(t.getRight().getLeft());//set right pointer of the old root to the left of the new root
        newRoot.setLeft(t);//set the left of the new root to the old root
        t=newRoot;//new root equal to t so we return it
        return t;
    }
    // For these next four, be sure not to use any global variables
    // and no extra counting parameters in the recursive methods, e.g.,
    // the recursive height method should just have one parameter, the
    // StringAVLNode
    // Return the height of the tree – not to be used anywhere in insert or delete
    public int height() {
        return height(this.root);
    }
    private static int height(StringAVLNode root) {
        int returnValue=0;//assumes empty root
        if(root!=null){//if root isn't null
            int depth;
            if(root.getBalance()==0){
                depth=height(root.getLeft());//get height of left subtree if they are both the same
            }else if (root.getBalance()>0){
                depth=height(root.getRight());//get height of right subtree
            }else {
                depth=height(root.getLeft());//get height of left subtree

            }
            returnValue = 1 + depth;

        }
        return returnValue;
    }



   // nadir return the distance to the closest leaf
    public int nadir() {
        int returnValue=nadir(this.root)+1;
        if(this.root==null){
            //since we add one to make the distance counting start from 1 at the first tree level
            // reset the value to 0 if the tree is actually empty
            returnValue=0;
        }
        return returnValue;
    }
    private static int nadir(StringAVLNode root) {
        int returnValue=0;//assumes empty root
       if(root!=null &&root.getLeft()==null&& root.getRight()==null){//got to a leaf or root has no children
            returnValue=0;
        }else if(root!=null ){//if root isn't null
            int depthL=nadir(root.getLeft());//get height of left subtree
            int depthR=nadir(root.getRight());//get height of right subtree
            if(depthL<depthR) {//decide which side is shorter
                returnValue = 1 + depthL;
            }else {
                returnValue=1+depthR;
            }
        }
        return returnValue;
    }

    // delete methods not used was not required but was in skeleton code
    public void delete(String d) {}
    private StringAVLNode delete(StringAVLNode t, String d) { return t;}

    // Return the number of leaves in the tree
    public int leafCt() { return leafCt(this.root); }
    private static int leafCt(StringAVLNode root) {
        int returnValue;
        if(root==null){//empty tree return 0
            returnValue=0;
        }else if(root.getLeft()==null&&root.getRight()==null){//reached end of tree || one node tree
            returnValue=1;
        }else {//add left and right sub tree leafct
            returnValue=leafCt(root.getLeft())+leafCt(root.getRight());
        }
        return returnValue;
    }

    // Return the number of perfectly balanced AVL nodes
    public int balanced() {return balanced(this.root);}
    private static int balanced(StringAVLNode root) {
        int returnValue=0;//assume its null
        if(root != null) {//if not null
            if (root.getBalance() == 0) {// if balance =0
                returnValue = 1;
            }
            returnValue += balanced(root.getLeft())+balanced(root.getRight());
        }
        return returnValue;
    }

    // Return the inorder successor, i.e., the next larger value in the tree
    // or null if there is none or str is not in the tree
    public String successor(String str) {
        StringAVLNode returnValue=null;//the node that we will return its value
        StringAVLNode parent=null;//parent of node will be used if we need to look at parents
        Deque<StringAVLNode> parents=new LinkedList<>();// all the parents of the node we will look for will be used if we need to look more than one parent up
        StringAVLNode root=this.root;//root of the tree and will be used as the node we want its successor
        StringAVLNode current=this.root;//will be used in the loop
        boolean found=false;//if its found set this to true
        //find the node
        while(current!=null){
            if(str.compareToIgnoreCase(current.getItem())==0) {//found
                root=current;
                found=true;
                current=null;
            }else if(str.compareToIgnoreCase(current.getItem())<0){//left
                parent=current;
                parents.push(parent);
                current=current.getLeft();
            }else {//right
                parent=current;
                parents.push(parent);
                current=current.getRight();
            }
        }
        if(!found || root==null) {//if not found in the tree or root equal null
            returnValue=null;
        }else if(root.getRight()!=null){// if node we want its successor have a right subtree then the successor is there
            StringAVLNode tempNode=root.getRight();//get the right node of the node we want its successor
            while(tempNode.getLeft()!=null){//go all the way to the left
                tempNode=tempNode.getLeft();
            }
            returnValue=tempNode;
        }else{//if it doesnot have a right subtree
            if(parent==null){//there were no successor on the right of the required node and no parent meaning no successor
                returnValue=null;
            }else if (parent.getLeft()!=null&&str.compareToIgnoreCase(parent.getLeft().getItem())==0){//the parent is the successor
                returnValue=parent;
            }else if(parent.getRight()!=null&&str.compareToIgnoreCase(parent.getRight().getItem())==0){//required element is right of parent
                //here we use the parents stack from earlier once we find a parent that is bigger we exit and that is the successor
                if(!parents.isEmpty()){
                    parents.pop();//remove parent of current node (ie the node that is equal to str)
                }
                boolean exit=false;
                while (!exit&&!parents.isEmpty()){
                    parent=parents.pop();
                    if(str.compareTo(parent.getItem())<0){//if parent is bigger than input string
                        returnValue=parent;
                        exit=true;
                    }else{
                        returnValue=null;
                    }
                }

            }

        }
        String returnString=(returnValue!=null)?returnValue.getItem():null;
        return returnString;
    }
    //insert a node and do nothing if node exists
    public void insert(String str) {
        this.root=insert(str,this.root);
    }
    private static StringAVLNode insert(String str, StringAVLNode t) {
        if(t==null){
            t=new StringAVLNode(str);
        }else if(str.compareToIgnoreCase(t.getItem())==0) {
            //Silence is golden..
            //input is in the tree do nothing
        }
        else if(str.compareToIgnoreCase(t.getItem())<0){//insert left
            int OldBalance;
            if(t.getLeft()!=null){
                OldBalance=t.getLeft().getBalance();
            }else {
                OldBalance=282;
            }
            t.setLeft(insert(str,t.getLeft()));
            int newBalance=t.getLeft().getBalance();
            if((OldBalance==0&& newBalance!=0)|| OldBalance==282){
                t.setBalance(t.getBalance()-1);
                if(t.getBalance()==-2){//either ll or lr
                    if(t.getLeft().getBalance()<0){//ll
                        t=rotateRight(t);//single rotation
                        t.setBalance(0);
                        t.getRight().setBalance(0);
                    }else {//lr
                        t.setLeft(rotateLeft(t.getLeft()));
                        t=rotateRight(t);
                        //fix balance factor
                        if (t.getBalance() > 0) {
                            t.getLeft().setBalance(-1);
                            t.getRight().setBalance(0);
                        } else {
                            if (t.getBalance() == 0) {
                                t.getRight().setBalance(0);
                                t.getLeft().setBalance(0);
                            } else {

                                t.getLeft().setBalance(1);
                                t.getLeft().setBalance(0);
                                t.getRight().setBalance(1);
                            }
                        }
                        t.setBalance(0);
                    }
                }
            }
        }else {//insert right
            int OldBalance;
            if(t.getRight()!=null){
                OldBalance=t.getRight().getBalance();
            }else {
                OldBalance=282;
            }
            t.setRight(insert(str,t.getRight()));
            int newBalance=t.getRight().getBalance();
            if((OldBalance==0&& newBalance!=0)|| OldBalance==282){
                t.setBalance(t.getBalance()+1);
                if(t.getBalance()==2){//either rr or rl
                    if(t.getRight().getBalance()>0){//rr
                        t=rotateLeft(t);//single rotation
                        t.setBalance(0);
                        t.getLeft().setBalance(0);
                    }else {//rl
                        t.setRight(rotateRight(t.getRight()));
                        t = rotateLeft(t);
                        if (t.getBalance() > 0) {
                            t.getLeft().setBalance(-1);
                            t.getRight().setBalance(0);
                        } else {
                            if (t.getBalance() == 0) {
                                t.getLeft().setBalance(0);
                                t.getRight().setBalance(0);
                            } else {
                                t.getLeft().setBalance(0);
                                t.getRight().setBalance(1);
                            }
                        }
                        t.setBalance(0);
                    }
                }
            }
        }
        return t;
    }

    // who are you? Put your name here!
    public static String myName() {
        return "Bishoy Abdelamlik";

    }

    /*
     * the traversal methods were used during development to help me visualize the tree
     * Can be used to print out all the elements in the tree
     */
    public void inOrderTraversal() {inOrderTraversal(this.root);}
    public void preOrderTraversal() {preOrderTraversal(this.root);}
    public void postOrderTraversal() {postOrderTraversal(this.root);}

    private void inOrderTraversal( StringAVLNode root) {
        if(root==null) {
            return;
        }
        inOrderTraversal(root.getLeft());
        //System.out.println(root.toString());
        inOrderTraversal(root.getRight());

    }
    public void inOrderTraversalToArray(ArrayList<StringAVLNode> inorder, StringAVLNode root) {
        if(root==null) {
            return;
        }
        inOrderTraversalToArray(inorder,root.getLeft());
        inorder.add(root);
        inOrderTraversalToArray(inorder,root.getRight());

    }

    private void preOrderTraversal( StringAVLNode root) {
        if(root==null) {
            return;
        }
        System.out.println(root.toString());
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());

    }
    private void postOrderTraversal( StringAVLNode root) {
        if(root==null) {
            return;
        }
        postOrderTraversal(root.getLeft());
        postOrderTraversal(root.getRight());
        //System.out.println(root.toString());
    }
    public int oldheight() {
        return oldheight(this.root);
    }

    private static int oldheight(StringAVLNode root) {
        int returnValue=0;//assumes empty root
        if(root!=null){//if root isn't null
            int depthL=oldheight(root.getLeft());//get height of left subtree
            int depthR=oldheight(root.getRight());//get height of right subtree
            if(depthL>depthR) {
                returnValue = 1 + depthL;
            }else {
                returnValue=1+depthR;
            }
        }
        return returnValue;
    }
} // end of StringAVLTree class


