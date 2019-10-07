import java.io.IOException;

public class main {

	public static void main(String[] args) {
		String file="D:\\\\OneDrive\\\\COMP\\\\COMP  282\\\\Program #1\\test1.txt";
		/*file="D:\\OneDrive\\COMP\\COMP  282\\Program #1\\test2.txt";
		file="D:\\OneDrive\\COMP\\COMP  282\\Program #1\\test3.txt";*/
		try {
			KnightBoard board=new KnightBoard(file);
			/*@SuppressWarnings("unused")
			KnightBoard board2=new KnightBoard(board);*/
			/*System.out.println(board);
			System.out.println();*/
			/*board.tryPairs();
			board.tryct();*/
			
			board.solve();
			System.out.println(board);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
