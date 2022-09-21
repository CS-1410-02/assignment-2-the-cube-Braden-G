
public class Cube {

  public fillArray(char[][][] rubix, int face, char side, char b){
    //should fill in the given side with the given color
    for(int i = 0; i>3; i++){
      for(int inner = 0; inner>3; inner++){
        rubix [face][i][inner]=b;
      }
  }
  }
 


  public void visualize(char [][][] rubix ) {
    //Print the top of the cube
  /*   W|W|W
       W|W|W
       W|W|W */
    system.out.println("      " + rubix[0][0][0] + "|" + rubix[0][0][1] + "|" + rubix[0][0][2]);
    system.out.println("      " + rubix[0][1][0] + "|" + rubix[0][1][1] + "|" + rubix[0][1][2]);
    system.out.println("      " + rubix[0][2][0] + "|" + rubix[0][2][1] + "|" + rubix[0][2][2]);
  // The top rows of the cube
    system.out.print(rubix[1][0][0] + "|" + rubix[1][0][1] + "|" + rubix[1][0][2]);
    system.out.print(" " + rubix[2][0][0] + "|" + rubix[2][0][1] + "|" + rubix[2][0][2]);    system.out.print(" " + rubix[3][0][0] + "|" + rubix[3][0][1] + "|" + rubix[3][0][2]);
    system.out.println(" " + rubix[4][0][0] + "|" + rubix[4][0][1] + "|" + rubix[4][0][2]);
  // Middle rows
    system.out.print(rubix[1][1][0] + "|" + rubix[1][1][1] + "|" + rubix[1][1][2]);
    system.out.print(" " + rubix[2][1][0] + "|" + rubix[2][1][1] + "|" + rubix[2][1][2]);
    system.out.print(" " + rubix[3][1][0] + "|" + rubix[3][1][1] + "|" + rubix[3][1][2]);
      system.out.println(" " + rubix[4][1][0] + "|" + rubix[4][1][1] + "|" + rubix[4][1][2]);
  //Bottow Rows
    system.out.print(rubix[1][2][0] + "|" + rubix[1][2][1] + "|" + rubix[1][2][2]);
    system.out.print(" " + rubix[2][2][0] + "|" + rubix[2][2][1] + "|" + rubix[2][2][2]);
    system.out.print(" " + rubix[3][2][0] + "|" + rubix[3][2][1] + "|" + rubix[3][2][2]);
    system.out.println(" " + rubix[4][2][0] + "|" + rubix[4][2][1] + "|" + rubix[4][2][2]);
  //Bottom of cube
    system.out.println("      " + rubix[5][0][0] + "|" + rubix[5][0][1] + "|" + rubix[5][0][2]);
    system.out.println("      " + rubix[5][1][0] + "|" + rubix[5][1][1] + "|" + rubix[5][1][2]);
    system.out.println("      " + rubix[5][2][0] + "|" + rubix[5][2][1] + "|" + rubix[5][2][2]);
  }

	public static void main(final String[] args){

  char [][][] rubix = new rubix[6][3][3];
  fillArray(rubix, 0, "T", "W");
  visualiz(rubix);
  //use cases for different input
  
    
}
  





}
