import java.util.Scanner;

public class TicTacToe {
	private Player player1, player2;
	 Board board;
	 
	 public static void main(String[] args) {
		 TicTacToe t = new TicTacToe();
		 t.startGame();
	 }
	 
	 public void startGame() {
		 Scanner sc = new Scanner(System.in);
		 //player input
		 player1 = takePLayerInput(1);
		 player2 = takePLayerInput(2);
		 while(player1.getSymbol() == player2.getSymbol()) {
			 System.out.println("Symbol already taken !! Pick another symbol.");
			 char symbol = sc.next().charAt(0);
			 player2.setSymbol(symbol);
		 	}
		 // Create Board
		 Board board = new Board(player1.getSymbol(), player2.getSymbol());
		 
		 //Conduct the game
		 boolean player1Turn = true;
		 int status = Board.INCOMPLETE;
		 while(status == Board.INCOMPLETE || status == Board.INVALID) {
			 if(player1Turn) {
				 System.out.println("Player 1 -" + player1.getName() + "'s turn");
				 System.out.println("Enter x coordinate");
				 int x = sc.nextInt();
				 System.out.println("Enter y coordinate");
				 int y = sc.nextInt();
				 status = board.move(player1.getSymbol(),x,y);
				 if(status != Board.INVALID) {
					 player1Turn = false;
					 board.print();
				 }else {
					 System.out.println("Invalid Movve !! Tray Again !!");
				 }
				 
			 }
			 else {
				System.out.println("Player 2 -" + player2.getName() + "'s turn");
				System.out.println("Enter x coordinate");
				int x = sc.nextInt();
				System.out.println("Enter y coordinate");
				int y = sc.nextInt();
			    status = board.move(player2.getSymbol(),x,y);
				if(status != Board.INVALID) {
					player1Turn = true;
					board.print();
				  }
				else {
					 System.out.println("Invalid Movve !! Tray Again !!");
				 }
					 
			  }
				 
		}
		 if(status == Board.PLAYER_1_WINS) {
			 System.out.println("Player 1 " + player1.getName() + " wins !!");
		 }
		 else if(status == Board.PLAYER_2_WINS){
			 System.out.println("Player 2 " + player2.getName() + " wins !!");
		 }
		 else {
			 System.out.println("Draw");
		 }
		 
		 
		 
   }
		 
		 
	 private Player takePLayerInput(int num) {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter Player " + num + " name :");
		 String name = sc.nextLine();
		 System.out.println("Enter Player " + num + " symbol :");
		 char symbol = sc.next().charAt(0);
		 Player p = new Player(name, symbol);
		 return p;
		 
	 }

}
