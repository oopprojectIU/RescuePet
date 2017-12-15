package linhmil.oop.hcmiu.rescuepets.entities.model;
public class Board {
	private static Board instance;
	public static int row=20;
	public static int column=8;
	public static int current=20-6-1;
	private static int[][] board= new int[20][8];
	

	private Board() {
		init();
	}

	public static Board getInstance() {
		if (instance==null) {
			instance = new Board();
		}
		return instance;
	}
	
	public int getElement(int rowi,int col) {
		System.out.print(1);
		int a = board[rowi][col];
		System.out.print(1);
		return board[rowi][col];
	}

/*	public static void printboard() {
		for (int i=0;i<20;i++) {
			for(int k=0;k<8;k++) {
				System.out.print(board[i][k]+"\t");
			}
			System.out.println("\n");
		}
	}*/

	private  void init() {
		board[0][0]= 0;
		board[0][1]= 1;
		board[0][2]= 2;
		board[0][3]= 3;
		board[0][4]= 4;
		board[0][5]= 0;
		board[0][6]= 1;
		board[0][7]= 2;
		board[1][0]= 0;
		board[1][1]= 3;
		board[1][2]= 2;
		board[1][3]= 0;
		board[1][4]= 4;
		board[1][5]= 0;
		board[1][6]= 4;
		board[1][7]= 0;
		board[2][0]= 0;
		board[2][1]= 1;
		board[2][2]= 2;
		board[2][3]= 3;
		board[2][4]= 4;
		board[2][5]= 0;
		board[2][6]= 1;
		board[2][7]= 2;
		board[3][0]= 1;
		board[3][1]= 3;
		board[3][2]= 2;
		board[3][3]= 0;
		board[3][4]= 4;
		board[3][5]= 0;
		board[3][6]= 4;
		board[3][7]= 1;
		board[4][0]= 0;
		board[4][1]= 1;
		board[4][2]= 2;
		board[4][3]= 3;
		board[4][4]= 4;
		board[4][5]= 0;
		board[4][6]= 1;
		board[4][7]= 2;
		board[5][0]= 0;
		board[5][1]= 1;
		board[5][2]= 2;
		board[5][3]= 3;
		board[5][4]= 4;
		board[5][5]= 0;
		board[5][6]= 1;
		board[5][7]= 2;
		board[6][0]= 0;
		board[6][1]= 1;
		board[6][2]= 2;
		board[6][3]= 3;
		board[6][4]= 4;
		board[6][5]= 0;
		board[6][6]= 1;
		board[6][7]= 2;
		board[7][0]= 0;
		board[7][1]= 1;
		board[7][2]= 2;
		board[7][3]= 3;
		board[7][4]= 4;
		board[7][5]= 0;
		board[7][6]= 1;
		board[7][7]= 2;
		board[8][0]= 1;
		board[8][1]= 4;
		board[8][2]= 3;
		board[8][3]= 2;
		board[8][4]= 1;
		board[8][5]= 0;
		board[8][6]= 1;
		board[8][7]= 4;
		board[9][0]= 0;
		board[9][1]= 2;
		board[9][2]= 4;
		board[9][3]= 2;
		board[9][4]= 3;
		board[9][5]= 4;
		board[9][6]= 4;
		board[9][7]= 1;
		board[10][0]= 0;
		board[10][1]= 1;
		board[10][2]= 2;
		board[10][3]= 3;
		board[10][4]= 4;
		board[10][5]= 0;
		board[10][6]= 1;
		board[10][7]= 2;
		board[11][0]= 1;
		board[11][1]= 1;
		board[11][2]= 2;
		board[11][3]= 0;
		board[11][4]= 4;
		board[11][5]= 0;
		board[11][6]= 3;
		board[11][7]= 2;
		board[12][0]= 4;
		board[12][1]= 3;
		board[12][2]= 2;
		board[12][3]= 3;
		board[12][4]= 4;
		board[12][5]= 0;
		board[12][6]= 1;
		board[12][7]= 2;
		board[13][0]= 0;
		board[13][1]= 1;
		board[13][2]= 2;
		board[13][3]= 3;
		board[13][4]= 4;
		board[13][5]= 0;
		board[13][6]= 1;
		board[13][7]= 2;
		board[14][0]= 1;
		board[14][1]= 3;
		board[14][2]= 2;
		board[14][3]= 0;
		board[14][4]= 4;
		board[14][5]= 0;
		board[14][6]= 4;
		board[14][7]= 1;
		board[15][0]= 0;
		board[15][1]= 1;
		board[15][2]= 2;
		board[15][3]= 3;
		board[15][4]= 4;
		board[15][5]= 0;
		board[15][6]= 1;
		board[15][7]= 2;
		board[16][0]= 4;
		board[16][1]= 0;
		board[16][2]= 3;
		board[16][3]= 4;
		board[16][4]= 1;
		board[16][5]= 0;
		board[16][6]= 3;
		board[16][7]= 3;
		board[17][0]= 0;
		board[17][1]= 2;
		board[17][2]= 4;
		board[17][3]= 2;
		board[17][4]= 3;
		board[17][5]= 4;
		board[17][6]= 4;
		board[17][7]= 1;
		board[18][0]= 1;
		board[18][1]= 3;
		board[18][2]= 2;
		board[18][3]= 0;
		board[18][4]= 4;
		board[18][5]= 0;
		board[18][6]= 4;
		board[18][7]= 1;
		board[19][0]= 1;
		board[19][1]= 4;
		board[19][2]= 3;
		board[19][3]= 2;
		board[19][4]= 1;
		board[19][5]= 0;
		board[19][6]= 1;
		board[19][7]= 4;
	}
	
}
