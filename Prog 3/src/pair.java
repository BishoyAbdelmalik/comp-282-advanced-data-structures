// use this class to return two values in the outside-in and the 2-pivot // partition methods
class pair {
    public int left, right;
    public pair(int left, int right) {
        this.left = left;
        this.right = right;
    }
    // some getters below
    public int getLeft(){
        return left;
    }
    public int getRight(){
        return right;
    }
}