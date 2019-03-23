import java.util.Scanner;

public class TicTacToeTester {

	public static void main(String[] args) {
		
		// Board creation
		int[][] numBoard = new int [3][3];
		for(int i=0;i<3;i++){
			for(int j=0; j<3; j++){
				numBoard[i][j]=0;
			}
		}
		
		String[][] drawBoard = new String[3][3];
		for(int i=0;i<3;i++){
			for(int j=0; j<3; j++){
				drawBoard[i][j]="[ ]";
			}
		}
		// End of board creation
		
		// Player creation
		String playerOne = "";
		String playerTwo = "";
		Scanner input = new Scanner(System.in);
		System.out.println("Player One (X) enter name:");
		playerOne=input.nextLine();
		System.out.println("Player Two (O) enter name:");
		playerTwo=input.nextLine();
		// End of player creation
		
		// Start of game logic
		boolean done = false;
		int turn = 1;
		String player ="";
		String mark ="";
		int num=0;
		int row=0;
		int col=0;
		int total=0;
		
		restart:
		while(!done){
			// Chooses player's turn
			if(turn%2!=0){
				player = playerOne;
				mark ="X";
				num=1;	
			}
			else{
				player = playerTwo;
				mark ="O";
				num=-1;
			}
			// Draws board
			for(int i=0;i<3;i++){
				for(int j=0; j<3; j++){
					System.out.print(drawBoard[i][j]);;
					if(j==2)
						System.out.println("");
				}
			}
			// Gives options
			System.out.println(player+" enter coordinate");
			System.out.print("row: ");
			row=input.nextInt()-1;
			System.out.println("column: ");
			col=input.nextInt()-1;
			if(row>2||row<0||col>2||col<0){
				System.out.println("Invalid move");
				continue restart;
			}
			// Puts coordinate in 2d array
			if(numBoard[row][col]==0){
				numBoard[row][col]=num;
				drawBoard[row][col]="["+mark+"]";
			}
			else{
				System.out.println("Already filled");
				continue restart; }
			// Checks rows for winner
			for(int i=0; i<3; i++){
				total=0;
				for(int j=0; j<3; j++){
					total = total + numBoard[i][j];
					if(total==3||total==-3){
						done=!done;
						for(int k=0;k<3;k++){
							for(int l=0; l<3; l++){
								System.out.print(drawBoard[k][l]);;
								if(l==2)
									System.out.println("");
							}
						}
						System.out.println("Congratulations "+player+", you win!");
						System.out.println("Game took "+turn+" turns.");
						continue restart;
					}
				}
			}
			// Checks columns for winner
			total=0;
			for(int i=0; i<3; i++){
				total=0;
				for(int j=0; j<3;j++){
					total= total + numBoard[j][i];
					if(total==3||total==-3){
						done=!done;
						for(int k=0;k<3;k++){
							for(int l=0; l<3; l++){
								System.out.print(drawBoard[k][l]);;
								if(l==2)
									System.out.println("");
							}
						}
						System.out.println("Congratulations "+player+", you win!");
						System.out.println("Game took "+turn+" turns.");
						continue restart;
					}
				}
			}
			// Checks diagonals
			total=numBoard[0][0]+numBoard[1][1]+numBoard[2][2];
			if(total==3||total==-3){
				done=!done;
				for(int k=0;k<3;k++){
					for(int l=0; l<3; l++){
						System.out.print(drawBoard[k][l]);;
						if(l==2)
							System.out.println("");
					}
				}
				System.out.println("Congratulations "+player+", you win!");
				System.out.println("Game took "+turn+" turns.");
				continue restart;
			}
			total=0;
			total=numBoard[0][2]+numBoard[1][1]+numBoard[2][0];
			if(total==3||total==-3){
				done=!done;
				for(int k=0;k<3;k++){
					for(int l=0; l<3; l++){
						System.out.print(drawBoard[k][l]);;
						if(l==2)
							System.out.println("");
					}
				}
				System.out.println("Congratulations "+player+", you win!");
				System.out.println("Game took "+turn+" turns.");
				continue restart;
			}
			total=0;
			turn++;
			// Checks for draw
			if(turn>9){
				for(int k=0;k<3;k++){
					for(int l=0; l<3; l++){
						System.out.print(drawBoard[k][l]);;
						if(l==2)
							System.out.println("");
					}
				}
				System.out.println("Tie game");
				done=!done;
				continue restart;
			}
		}
	}
}

