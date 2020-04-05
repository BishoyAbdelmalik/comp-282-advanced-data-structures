import java.util.ArrayList;

public class heapoverflow {
    public static void main(String[] args) {
        ArrayList<Integer> test=new ArrayList<>();
        while (true){
            test.add(Integer.MAX_VALUE);
        }
    }
}
