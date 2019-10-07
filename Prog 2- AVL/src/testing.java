import java.util.ArrayList;
import java.util.Random;

public class testing {
    public static void main(String[] args) {
        for(int j=0;j<1;j++) {
            StringAVLTree t = new StringAVLTree();
            Random rnd = new Random();
            //ArrayList<Character> characters = new ArrayList<>();
            ArrayList<String> characters = new ArrayList<>();
            //char[] chars={'a','d','n','k','u','g'};
            //char[]  chars={'w','s','m','g','z','a','t','j','b','c','q','o','h','v','p','n','d','r','f','i','u'};
            char[] chars = {'i', 'a', 'l', 'y', 'z', 'r', 'e', 'c', 'w', 's', 'g', 'x', 'p', 'u', 'o', 'd', 'b', 't', 'q', 'h', 'k'};
            char c;
            String s;
            //for (int i = 0; i <= 20; i++) {
//        for(int i=0; i<=30;i++){
                 for(int i=0; i<chars.length;i++){
                c = chars[i];

                //c = (char) (rnd.nextInt(26) + 'a');
                s=String.valueOf(c);
               /* c = (char) (rnd.nextInt(26) + 'a');
                s+=String.valueOf(c);*/
                if (!characters.contains(s)) {
                    characters.add(s);
                    System.out.println("Insert: " + s);
                    t.insert(s);
                    t.preOrderTraversal();
/*
                    System.out.println("Balancd nodes"+t.balanced());
*/

/*
                    System.out.println(t.height());
*/
                    System.out.println("nadir: "+t.nadir());
                    if(t.height()==t.oldheight()){
                        System.out.println("Height good");
                    }else {
                        System.out.println("Oh no Height not good");

                    }
                    System.out.println("leaf count"+t.leafCt());
                    System.out.println();
                } else {
                    i--;
                }


            }
            System.out.println("");
            System.out.print("{");
            for (String C : characters) {
                System.out.print("'" + C + "'");
                System.out.print(",");
            }
            System.out.print("}");
            System.out.println("");

/*
            test(t.root, t);
*/
            t.postOrderTraversal();
            System.out.println("Balancd nodes"+t.balanced());
/*
            System.out.println("Finished move on");
*/
            System.out.println("");

            System.out.println("Successors test");
            ArrayList<StringAVLNode> array=new ArrayList<>();
            t.inOrderTraversalToArray(array,t.root);
            for (String C : characters) {
                System.out.println(C+" Successor is "+t.successor(C));
            }
            System.out.println();
            System.out.println();
            System.out.print("{");

            for (StringAVLNode n:array){
                System.out.print("'" + n.getItem() + "'");
                System.out.print(",");
            }
            System.out.print("}");

        }


    }
/*     for(int i=0; i<chars.length;i++){

        t.preOrderTraversal();
        System.out.println(t.height());
        System.out.println();


    }*/
/*        if(t.root==null) {
        return;
    }
        System.out.println(root.toString());
    preOrderTraversal(root.getLeft());
    preOrderTraversal(root.getRight());*/
/*    public static void test(StringAVLNode t,StringAVLTree tree){
        if(t==null){
            System.out.println("yay got to the end");
            return;
        }
        if (t.getBalance()!=(tree.height(t.getRight())-tree.height(t.getLeft()))){
            System.out.println("failed on node"+t.toString());
            return;
        }else{
            test(t.getRight(),tree);
            test(t.getLeft(),tree);

        }
        System.out.println("done");

       *//* if (t.getBalance()!=(tree.height(t.getRight())-tree.height(t.getLeft()))){
            System.out.println("failed on node"+t.toString());
            return;
        }else{
            test(t.getLeft(),tree);
        }*//*
    }*/
}
