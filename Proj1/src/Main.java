import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.print("Введите  имя игрока 1: ");
		Scanner in = new Scanner(System.in);
		String name1 = in.nextLine();
		System.out.print("Введите  имя игрока 2: ");
		String name2 = in.nextLine();
		
		char[][] board = {{'-', '-', '-'},
						  {'-', '-', '-'},
						  {'-', '-', '-'}};
		
		drawBoard(board);
		
		for(int i = 0; i < 9; i++) {
			
			System.out.print(name1 + " выбери строку и столбец через пробел: ");
			String step = in.nextLine();
			
			/////Ограничение строки по длине
			if(step.length() > 3) {
				System.out.println("Превышение кол-ва символов");
				break;
			}
			
			/////Проверка на правильный ввод чисел с пробелом
			if(step.charAt(0) != '1' && step.charAt(0) != '2' && step.charAt(0) != '3') {
				System.out.println("Номер строки введен неправильно!");
				break;
			}
			if(step.charAt(2) != '1' && step.charAt(2) != '2' && step.charAt(2) != '3') {
				System.out.println("Номер столбца введен неправильно!");
				break;
			}
			if(step.charAt(1) != ' ') {
				System.out.println("После ввода строки должен идти пробел!");
				break;
			}
			
			String[] rowAndCol	= step.split(" ");
			int row1 = Integer.parseInt(rowAndCol[0]) - 1;
			if(row1 < 0 || row1 > 2) {
				System.out.println("Вышел за границы");
				break;
			}
			
			int col1 = Integer.parseInt(rowAndCol[1]) - 1;
			if(col1 < 0 || col1 > 2) {
				System.out.println("Вышел за границы");
				break;
			}
			
			/////////////Ввод значения в пустую ячейку
			if(board[row1][col1] != 'x' && board[row1][col1] != 'o') {
				board[row1][col1] = 'x';
			}
			
			drawBoard(board);
			/////////Победа 1 игрок
			if(board[0][col1] == 'x' && board[1][col1] == 'x' && board[2][col1] == 'x') {
				System.out.println("Победил " + name1);
				break;
			} else if(board[row1][0] == 'x' && board[row1][1] == 'x' && board[row1][2] == 'x') {
				System.out.println("Победил " + name1);
				break;
			} else if(board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] == 'x') {
				System.out.println("Победил " + name1);
				break;
			} else if(board[0][2] == 'x' && board[1][1] == 'x' && board[2][0] == 'x') {
				System.out.println("Победил " + name1);
				break;
			}
			////////////////////////Второй игрок
			System.out.print(name2 + " выбери строку и столбец через пробел: ");
			String step2 = in.nextLine();
			
			if(step2.length() > 3) {
				System.out.println("Превышение кол-ва символов");
				break;
			}
			
			/////Проверка на правильный ввод чисел с пробелом
			if(step2.charAt(0) != '1' && step2.charAt(0) != '2' && step2.charAt(0) != '3') {
				System.out.println("Номер строки введен неправильно!");
				break;
			}
			if(step2.charAt(2) != '1' && step2.charAt(2) != '2' && step2.charAt(2) != '3') {
				System.out.println("Номер столбца введен неправильно!");
				break;
			}
			if(step2.charAt(1) != ' ') {
				System.out.println("После ввода строки должен идти пробел!");
				break;
			}
			
			String[] rowAndCol2	= step2.split(" ");
			int row2 = Integer.parseInt(rowAndCol2[0]) - 1;
			if(row2 < 0 || row2 > 2) {
				System.out.println("Вышел за границы");
				break;
			}
			
			int col2 = Integer.parseInt(rowAndCol2[1]) - 1;
			if(col2 < 0 || col2 > 2) {
				System.out.println("Вышел за границы");
				break;
			}
			
			/////////////Ввод значения в пустую ячейку
			if(board[row2][col2] != 'x' && board[row2][col2] != 'o') {
				board[row2][col2] = 'o';
			}
			drawBoard(board);
			/////////Победа 2 игрок
			if(board[0][col2] == 'o' && board[1][col2] == 'o' && board[2][col2] == 'o') {
				System.out.println("Победил " + name2);
				break;
			} else if(board[row2][0] == 'o' && board[row2][1] == 'o' && board[row2][2] == 'o') {
				System.out.println("Победил " + name2);
				break;
			} else if(board[0][0] == 'o' && board[1][1] == 'o' && board[2][2] == 'o') {
				System.out.println("Победил " + name2);
				break;
			} else if(board[0][2] == 'o' && board[1][1] == 'o' && board[2][0] == 'o') {
				System.out.println("Победил " + name2);
				break;
			}
		}
	}
	
	public static void drawBoard(char[][] board) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
