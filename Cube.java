
public class Cube {

  public static void fillArray(char[][][] rubix, int face, char side, char color){
    //should fill in the given side with the given color
    for(int i = 0; i<3; i++){
      for(int inner = 0; inner<3; inner++){
        rubix [face][i][inner]=color;
      }
  }
  }
 


  public static void visualize(char [][][] rubix ) {
    //Print the top of the cube
  /*   W|W|W
       W|W|W
       W|W|W */
    System.out.println("      " + rubix[0][0][0] + "|" + rubix[0][0][1] + "|" + rubix[0][0][2]);
    System.out.println("      " + rubix[0][1][0] + "|" + rubix[0][1][1] + "|" + rubix[0][1][2]);
    System.out.println("      " + rubix[0][2][0] + "|" + rubix[0][2][1] + "|" + rubix[0][2][2]);
  // The top rows of the cube
  System.out.print(rubix[1][0][0] + "|" + rubix[1][0][1] + "|" + rubix[1][0][2]);
    System.out.print(" " + rubix[2][0][0] + "|" + rubix[2][0][1] + "|" + rubix[2][0][2]);    
    System.out.print(" " + rubix[3][0][0] + "|" + rubix[3][0][1] + "|" + rubix[3][0][2]);
    System.out.println(" " + rubix[4][0][0] + "|" + rubix[4][0][1] + "|" + rubix[4][0][2]);
  // Middle rows
  System.out.print(rubix[1][1][0] + "|" + rubix[1][1][1] + "|" + rubix[1][1][2]);
  System.out.print(" " + rubix[2][1][0] + "|" + rubix[2][1][1] + "|" + rubix[2][1][2]);
  System.out.print(" " + rubix[3][1][0] + "|" + rubix[3][1][1] + "|" + rubix[3][1][2]);
  System.out.println(" " + rubix[4][1][0] + "|" + rubix[4][1][1] + "|" + rubix[4][1][2]);
  //Bottow Rows
  System.out.print(rubix[1][2][0] + "|" + rubix[1][2][1] + "|" + rubix[1][2][2]);
  System.out.print(" " + rubix[2][2][0] + "|" + rubix[2][2][1] + "|" + rubix[2][2][2]);
  System.out.print(" " + rubix[3][2][0] + "|" + rubix[3][2][1] + "|" + rubix[3][2][2]);
  System.out.println(" " + rubix[4][2][0] + "|" + rubix[4][2][1] + "|" + rubix[4][2][2]);
  //Bottom of cube
  System.out.println("      " + rubix[5][0][0] + "|" + rubix[5][0][1] + "|" + rubix[5][0][2]);
  System.out.println("      " + rubix[5][1][0] + "|" + rubix[5][1][1] + "|" + rubix[5][1][2]);
  System.out.println("      " + rubix[5][2][0] + "|" + rubix[5][2][1] + "|" + rubix[5][2][2]);
  }

	public static void main(final String[] args){

  char [][][] rubix = new char[6][3][3];
  //T for top and W for white
  fillArray(rubix, 0, 'T', 'W');
  fillArray(rubix, 1, 'T', 'R');
  fillArray(rubix, 2, 'T', 'B');
  fillArray(rubix, 3, 'T', 'O');
  fillArray(rubix, 4, 'T', 'Y');
  fillArray(rubix, 5, 'T', 'G');

  visualize(rubix);
  //use cases for different input
  
    
}
  





}
