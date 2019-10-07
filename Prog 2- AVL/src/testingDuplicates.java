public class testingDuplicates {
    public static void main(String[] args) {
            StringAVLTree t = new StringAVLTree();

            t.insert("s");
            t.insert("s");
            t.insert("v");
            t.insert("x");
            t.insert("z");
            t.insert("f");
            t.insert("x");
            t.insert("f");
            t.insert("s");
            t.preOrderTraversal();
            System.out.println(t.height());
            System.out.println();




    }
}
