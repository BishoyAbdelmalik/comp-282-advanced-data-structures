class StringAVLNode {
    private String item;
    private int balance;
    private StringAVLNode left, right;

    // just one constructor, please
    public StringAVLNode(String str) {
        this.left=null;
        this.right=null;
        this.balance=0;
        this.item=str;
    }
    public int getBalance() {return this.balance;}
    public void setBalance(int bal) {
        this.balance=bal;
    }
    public String getItem() {return this.item;}
    // no setItem
    public StringAVLNode getLeft() {return this.left;}
    public void setLeft(StringAVLNode pt) {
        this.left=pt;
    }
    public StringAVLNode getRight() {return this.right;}
    public void setRight(StringAVLNode pt) {
        this.right=pt;
    }

    //I added that
    public String toString(){
        return "Value:"+item+" Balance:"+balance;
    }
} // StringAVLNode