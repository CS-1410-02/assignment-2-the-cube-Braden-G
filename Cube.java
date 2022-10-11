import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;


//Feedback: 
//  Looks Good, functions well, well commented. I would say that if I ran into this code in the real world I wouldn't have any issue jumping into it and adding to it.
//  It didn't really match the output from the assignment which was, more or less, picked to make people create a getFace type function on return but I understand 
//  why you didn't go that route and wouldn't penalize for it. I would also say it may be a hundred or so lines longer than it must be. It's possible that this might
//  actually speed up your code but for example on your visualize function: (continued on line 37)
// 
// 

public class Cube {

  static ArrayList<String> stack = new ArrayList<>();

  public static void fillArray(char[][][] rubix, int face, char side, char color){
    //should fill in the given side with the given color
    for(int i = 0; i<3; i++){
      for(int inner = 0; inner<3; inner++){
        rubix [face][i][inner]=color;
      }
    }
  }

  public static void visualize(char[][][] rubix) {
    // Print the top of the cube
    /*
     * W|W|W
     * W|W|W
     * W|W|W
     */

    //Moving this functionality into a for loop to cut down on redundent lines and even increase readability would be good. 
    //You could see how if you were specifically trying to understand what face you are adding when in this code block below 
    //it may take longer for someone new to this codebase than it needs to.
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
    // Bottow Rows
    System.out.print(rubix[1][2][0] + "|" + rubix[1][2][1] + "|" + rubix[1][2][2]);
    System.out.print(" " + rubix[2][2][0] + "|" + rubix[2][2][1] + "|" + rubix[2][2][2]);
    System.out.print(" " + rubix[3][2][0] + "|" + rubix[3][2][1] + "|" + rubix[3][2][2]);
    System.out.println(" " + rubix[4][2][0] + "|" + rubix[4][2][1] + "|" + rubix[4][2][2]);
    // Bottom of cube
    System.out.println("      " + rubix[5][0][0] + "|" + rubix[5][0][1] + "|" + rubix[5][0][2]);
    System.out.println("      " + rubix[5][1][0] + "|" + rubix[5][1][1] + "|" + rubix[5][1][2]);
    System.out.println("      " + rubix[5][2][0] + "|" + rubix[5][2][1] + "|" + rubix[5][2][2]);
  }

  public static void main(final String[] args)
      throws IOException {

    boolean run = true;
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    String input;
    // array that reprsents the 6 sides and 3 rows and 3 columns of rubix cube
    char[][][] rubix = new char[6][3][3];
    int argsRunIndex = 0;
    boolean argscheck = false;
    if (args.length > 0) {
      argscheck = true;
    }
    char[][] temp = new char[3][3];

    fillArray(rubix, 0, 'T', 'Y');
    fillArray(rubix, 1, 'L', 'R');
    fillArray(rubix, 2, 'C', 'G');
    fillArray(rubix, 3, 'R', 'O');
    fillArray(rubix, 4, 'B', 'B');
    fillArray(rubix, 5, 'U', 'W');

    while (run) {
      visualize(rubix);
      System.out.print("Possible moves: u, d, r, l, f, b and u', d', r', l', f', b' or s to see solution \nPress q to quit\n");

      if (!argscheck) {
        input = reader.readLine();
      } else {
        if (argsRunIndex == args.length) {
          argscheck = false;
          input = "e";
        } else {
          input = args[argsRunIndex];
          argsRunIndex++;
        }
      }

      if((input != "e") && (input != "s"))
        stack.add((input.contains("'") ? input : input+"'"));

      switch (input) {
        case "u":
          // works
          // set top row to temp
          temp[0][0] = rubix[0][0][0];
          temp[0][1] = rubix[0][0][1];
          temp[0][2] = rubix[0][0][2];
          // turn top clockwise
          rubix[0][0][2] = rubix[0][0][0];
          rubix[0][0][1] = rubix[0][1][0];
          rubix[0][0][0] = rubix[0][2][0];

          rubix[0][1][0] = rubix[0][2][1];
          rubix[0][2][0] = rubix[0][2][2];

          rubix[0][2][1] = rubix[0][1][2];
          rubix[0][2][2] = temp[0][2];

          rubix[0][1][2] = temp[0][1];

          // adjusted faces connected to top
          temp[0][0] = rubix[1][0][0];
          temp[0][1] = rubix[1][0][0];
          temp[0][2] = rubix[1][0][0];

          rubix[1][0][0] = rubix[2][0][0];
          rubix[1][0][1] = rubix[2][0][1];
          rubix[1][0][2] = rubix[2][0][2];

          rubix[2][0][0] = rubix[3][0][0];
          rubix[2][0][1] = rubix[3][0][1];
          rubix[2][0][2] = rubix[3][0][2];

          rubix[3][0][0] = rubix[4][0][0];
          rubix[3][0][1] = rubix[4][0][1];
          rubix[3][0][2] = rubix[4][0][2];

          rubix[4][0][0] = temp[0][0];
          rubix[4][0][1] = temp[0][1];
          rubix[4][0][2] = temp[0][2];

          break;

        case "u'":
          // works//set top row to temp
          temp[0][0] = rubix[0][0][0];
          temp[0][1] = rubix[0][0][1];
          temp[0][2] = rubix[0][0][2];
          // turn top counterclockwise
          rubix[0][0][0] = rubix[0][0][2];
          rubix[0][0][1] = rubix[0][1][2];
          rubix[0][0][2] = rubix[0][2][2];

          rubix[0][1][2] = rubix[0][2][1];
          rubix[0][2][2] = rubix[0][2][0];

          rubix[0][2][1] = rubix[0][1][0];
          rubix[0][2][0] = temp[0][0];

          rubix[0][1][0] = temp[0][1];

          // adjusted faces connected to top
          temp[0][0] = rubix[1][0][0];
          temp[0][1] = rubix[1][0][0];
          temp[0][2] = rubix[1][0][0];

          rubix[1][0][0] = rubix[4][0][0];
          rubix[1][0][1] = rubix[4][0][1];
          rubix[1][0][2] = rubix[4][0][2];

          rubix[4][0][0] = rubix[3][0][0];
          rubix[4][0][1] = rubix[3][0][1];
          rubix[4][0][2] = rubix[3][0][2];

          rubix[3][0][0] = rubix[2][0][0];
          rubix[3][0][1] = rubix[2][0][1];
          rubix[3][0][2] = rubix[2][0][2];

          rubix[2][0][0] = temp[0][0];
          rubix[2][0][1] = temp[0][1];
          rubix[2][0][2] = temp[0][2];

          break;

        case "d":
          // done
          // set top row to temp
          temp[0][0] = rubix[5][0][0];
          temp[0][1] = rubix[5][0][1];
          temp[0][2] = rubix[5][0][2];
          // turn bottom clockwise
          rubix[5][0][2] = rubix[5][0][0];
          rubix[5][0][1] = rubix[5][1][0];
          rubix[5][0][0] = rubix[5][2][0];

          rubix[5][1][0] = rubix[5][2][1];
          rubix[5][2][0] = rubix[5][2][2];

          rubix[5][2][1] = rubix[5][1][2];
          rubix[5][2][2] = temp[0][2];

          rubix[5][1][2] = temp[0][1];

          // adjusted faces connected to top
          temp[2][0] = rubix[1][2][0];
          temp[2][1] = rubix[1][2][0];
          temp[2][2] = rubix[1][2][0];

          rubix[1][2][0] = rubix[4][2][0];
          rubix[1][2][1] = rubix[4][2][1];
          rubix[1][2][2] = rubix[4][2][2];

          rubix[4][2][0] = rubix[3][2][0];
          rubix[4][2][1] = rubix[3][2][1];
          rubix[4][2][2] = rubix[3][2][2];

          rubix[3][2][0] = rubix[2][2][0];
          rubix[3][2][1] = rubix[2][2][1];
          rubix[3][2][2] = rubix[2][2][2];

          rubix[2][2][0] = temp[2][0];
          rubix[2][2][1] = temp[2][1];
          rubix[2][2][2] = temp[2][2];

          break;

        case "d'":
          // done
          temp[0][0] = rubix[5][0][0];
          temp[0][1] = rubix[5][0][1];
          temp[0][2] = rubix[5][0][2];
          // turn bottom clockwise
          rubix[5][0][0] = rubix[5][0][2];
          rubix[5][0][1] = rubix[5][1][2];
          rubix[5][0][2] = rubix[5][2][2];

          rubix[5][1][2] = rubix[5][2][1];
          rubix[5][2][2] = rubix[5][2][0];

          rubix[5][2][1] = rubix[5][1][0];
          rubix[5][2][0] = temp[0][0];

          rubix[5][1][0] = temp[0][1];

          // adjusted faces connected to bottom
          temp[2][0] = rubix[1][2][0];
          temp[2][1] = rubix[1][2][1];
          temp[2][2] = rubix[1][2][2];

          rubix[1][2][0] = rubix[2][2][0];
          rubix[1][2][1] = rubix[2][2][1];
          rubix[1][2][2] = rubix[2][2][2];

          rubix[2][2][0] = rubix[3][2][0];
          rubix[2][2][1] = rubix[3][2][1];
          rubix[2][2][2] = rubix[3][2][2];

          rubix[3][2][0] = rubix[4][2][0];
          rubix[3][2][1] = rubix[4][2][1];
          rubix[3][2][2] = rubix[4][2][2];

          rubix[4][2][0] = temp[2][0];
          rubix[4][2][1] = temp[2][1];
          rubix[4][2][2] = temp[2][2];
          break;

        case "r":
        //done
          // rotates right side of cube up
          temp[0][0] = rubix[3][0][0];
          temp[0][1] = rubix[3][0][1];
          temp[0][2] = rubix[3][0][2];
          // turn face clockwise
          rubix[3][0][2] = rubix[3][0][0];
          rubix[3][0][1] = rubix[3][1][0];
          rubix[3][0][0] = rubix[3][2][0];

          rubix[3][1][0] = rubix[3][2][1];
          rubix[3][2][0] = rubix[3][2][2];

          rubix[3][2][1] = rubix[3][1][2];
          rubix[3][2][2] = temp[0][2];
          rubix[3][1][2] = temp[0][1];

                  //adjusted attatched faces
          temp[0][2] = rubix[2][0][2];        
          temp[1][2] = rubix[2][1][2];        
          temp[2][2] = rubix[2][2][2];

         rubix[2][0][2] = rubix[5][0][2];
         rubix[2][1][2] = rubix[5][1][2];
         rubix[2][2][2] = rubix[5][2][2];
       
         rubix[5][0][2] = rubix[4][2][0];
         rubix[5][1][2] = rubix[4][1][0];
         rubix[5][2][2] = rubix[4][0][0];

        rubix[4][2][0] = rubix[0][0][2];
        rubix[4][1][0] = rubix[0][1][2];
        rubix[4][0][0] = rubix[0][2][2];

        rubix[0][2][2] = temp[2][2];
        rubix[0][1][2] = temp[1][2];
        rubix[0][0][2] = temp[0][2];
          break;

        case "f'":
          // done
          temp[0][0] = rubix[2][0][0];
          temp[0][1] = rubix[2][0][1];
          temp[0][2] = rubix[2][0][2];
          // turn face counterclockwise
          rubix[2][0][0] = rubix[2][0][2];
          rubix[2][0][1] = rubix[2][1][2];
          rubix[2][0][2] = rubix[2][2][2];

          rubix[2][1][2] = rubix[2][2][1];
          rubix[2][2][2] = rubix[2][2][0];

          rubix[2][2][1] = rubix[2][1][0];
          rubix[2][2][0] = temp[0][0];

          rubix[2][1][0] = temp[0][1];

          // turns attatched sides
          temp[2][0] = rubix[0][2][0];
          temp[2][1] = rubix[0][2][1];
          temp[2][2] = rubix[0][2][2];

          rubix[0][2][2] = rubix[3][2][0];
          rubix[0][2][1] = rubix[3][1][0];
          rubix[0][2][0] = rubix[3][0][0];

          rubix[3][2][0] = rubix[5][0][0];
          rubix[3][1][0] = rubix[5][0][1];
          rubix[3][0][0] = rubix[5][0][2];

          rubix[5][0][2] = rubix[1][2][2];
          rubix[5][0][1] = rubix[1][1][2];
          rubix[5][0][0] = rubix[1][0][2];

          rubix[1][0][2] = temp[2][2];
          rubix[1][1][2] = temp[2][1];
          rubix[1][2][2] = temp[2][0];

          break;

        case "f":
        //done
          temp[0][0] = rubix[2][0][0];
          temp[0][1] = rubix[2][0][1];
          temp[0][2] = rubix[2][0][2];
          // turn face clockwise
          rubix[2][0][2] = rubix[2][0][0];
          rubix[2][0][1] = rubix[2][1][0];
          rubix[2][0][0] = rubix[2][2][0];

          rubix[2][1][0] = rubix[2][2][1];
          rubix[2][2][0] = rubix[2][2][2];

          rubix[2][2][1] = rubix[2][1][2];
          rubix[2][2][2] = temp[0][2];
          rubix[2][1][2] = temp[0][1];

          // turns attatched sides
          temp[2][0] = rubix[0][2][0];
          temp[2][1] = rubix[0][2][1];
          temp[2][2] = rubix[0][2][2];

          rubix[0][2][2] = rubix[1][0][2];
          rubix[0][2][1] = rubix[1][1][2];
          rubix[0][2][0] = rubix[1][2][2];

          rubix[1][0][2] = rubix[5][0][0];
          rubix[1][1][2] = rubix[5][0][1];
          rubix[1][2][2] = rubix[5][0][2];

          rubix[5][0][0] = rubix[3][2][0];
          rubix[5][0][1] = rubix[3][1][0];
          rubix[5][0][2] = rubix[3][0][0];

          rubix[3][0][0] = temp[2][0];
          rubix[3][1][0] = temp[2][1];
          rubix[3][2][0] = temp[2][2];

          break;

          case "b":
          temp[0][0] = rubix[4][0][0];
          temp[0][1] = rubix[4][0][1];
          temp[0][2] = rubix[4][0][2];
          // turn face clockwise
          rubix[4][0][2] = rubix[4][0][0];
          rubix[4][0][1] = rubix[4][1][0];
          rubix[4][0][0] = rubix[4][2][0];

          rubix[4][1][0] = rubix[4][2][1];
          rubix[4][2][0] = rubix[4][2][2];

          rubix[4][2][1] = rubix[4][1][2];
          rubix[4][2][2] = temp[0][2];
          rubix[4][1][2] = temp[0][1];
          
          // rotate attatched faces
          temp[0][2] = rubix[3][0][2];
          temp[1][2] = rubix[3][1][2];
          temp[2][2] = rubix[3][2][2];

          rubix[3][0][2] = rubix[0][0][0];
          rubix[3][1][2] = rubix[0][0][1];
          rubix[3][2][2] = rubix[0][0][2];

          rubix[0][0][0] = rubix[1][2][0];
          rubix[0][0][1] = rubix[1][1][0];
          rubix[0][0][2] = rubix[1][0][0];

          rubix[1][2][0] = rubix[5][2][2];
          rubix[1][1][0] = rubix[5][2][1];
          rubix[1][0][0] = rubix[5][2][0];

          rubix[5][2][2] = temp[0][2];
          rubix[5][2][1] = temp[1][2];
          rubix[5][2][0] = temp[2][2];
          break;

          case "b'":
          temp[0][0] = rubix[4][0][0];
          temp[0][1] = rubix[4][0][1];
          temp[0][2] = rubix[4][0][2];
          // turn face counterclockwise
          rubix[4][0][0] = rubix[4][0][2];
          rubix[4][0][1] = rubix[4][1][2];
          rubix[4][0][2] = rubix[4][2][2];

          rubix[4][1][2] = rubix[4][2][1];
          rubix[4][2][2] = rubix[4][2][0];

          rubix[4][2][1] = rubix[4][1][0];
          rubix[4][2][0] = temp[0][0];

          rubix[4][1][0] = temp[0][1];

          //attatched sides
          temp[0][2] = rubix[3][0][2];
          temp[1][2] = rubix[3][1][2];
          temp[2][2] = rubix[3][2][2];

          rubix[3][0][2] = rubix[5][2][2];
          rubix[3][1][2] = rubix[5][2][1];
          rubix[3][2][2] = rubix[5][2][0];

          rubix[5][2][2] = rubix[1][2][0];
          rubix[5][2][1] = rubix[1][1][0];
          rubix[5][2][0] = rubix[1][0][0];

          rubix[1][2][0] = rubix[0][0][0];
          rubix[1][1][0] = rubix[0][0][1];
          rubix[1][0][0] = rubix[0][0][2];

          rubix[0][0][0] = temp[0][2];
          rubix[0][0][1] = temp[1][2];
          rubix[0][0][2] = temp[2][2];          
          break;

          case "l'":
          //works
          temp[0][0] = rubix[1][0][0];
          temp[0][1] = rubix[1][0][1];
          temp[0][2] = rubix[1][0][2];
          // turn face counterclockwise
          rubix[1][0][0] = rubix[1][0][2];
          rubix[1][0][1] = rubix[1][1][2];
          rubix[1][0][2] = rubix[1][2][2];

          rubix[1][1][2] = rubix[1][2][1];
          rubix[1][2][2] = rubix[1][2][0];

          rubix[1][2][1] = rubix[1][1][0];
          rubix[1][2][0] = temp[0][0];

          rubix[1][1][0] = temp[0][1];

          //rotate attatched faces
          temp[0][0] = rubix[2][0][0];
          temp[1][0] = rubix[2][1][0];
          temp[2][0] = rubix[2][2][0];

          rubix[2][0][0] = rubix[5][0][0];
          rubix[2][1][0] = rubix[5][1][0];
          rubix[2][2][0] = rubix[5][2][0];

          rubix[5][0][0] = rubix[4][2][2];
          rubix[5][1][0] = rubix[4][1][2];
          rubix[5][2][0] = rubix[4][0][2];

          rubix[4][2][2] = rubix[0][0][0];
          rubix[4][1][2] = rubix[0][1][0];
          rubix[4][0][2] = rubix[0][2][0];

          rubix[0][0][0] = temp[0][0];
          rubix[0][1][0] = temp[1][0];
          rubix[0][2][0] = temp[2][0];
                  
          
          break;

          case "l":
          //works 
          temp[0][0] = rubix[1][0][0];
          temp[0][1] = rubix[1][0][1];
          temp[0][2] = rubix[1][0][2];
          // turn face clockwise
          rubix[1][0][2] = rubix[1][0][0];
          rubix[1][0][1] = rubix[1][1][0];
          rubix[1][0][0] = rubix[1][2][0];

          rubix[1][1][0] = rubix[1][2][1];
          rubix[1][2][0] = rubix[1][2][2];

          rubix[1][2][1] = rubix[1][1][2];
          rubix[1][2][2] = temp[0][2];
          rubix[1][1][2] = temp[0][1];

           //rotate attatched faces
           temp[0][0] = rubix[2][0][0];
           temp[1][0] = rubix[2][1][0];
           temp[2][0] = rubix[2][2][0];
 
           rubix[2][0][0] = rubix[0][0][0];
           rubix[2][1][0] = rubix[0][1][0];
           rubix[2][2][0] = rubix[0][2][0];
 
           rubix[0][0][0]  = rubix[4][2][2];
           rubix[0][1][0]  = rubix[4][1][2];
           rubix[0][2][0]  = rubix[4][2][2];
 
           rubix[4][2][2] = rubix[5][0][0];
           rubix[4][1][2] = rubix[5][1][0];
           rubix[4][0][2] = rubix[5][2][0];
 
           rubix[5][0][0] = temp[0][0];
           rubix[5][1][0] = temp[1][0];
           rubix[5][2][0] = temp[2][0];
          
          break;

        case "r'":
        //works?
        //rotates right side of cube down
        temp[0][0] = rubix[3][0][0];
        temp[0][1] = rubix[3][0][1];
        temp[0][2] = rubix[3][0][2];
        // turn face counterclockwise
        rubix[3][0][0] = rubix[3][0][2];
        rubix[3][0][1] = rubix[3][1][2];
        rubix[3][0][2] = rubix[3][2][2];

        rubix[3][1][2] = rubix[3][2][1];
        rubix[3][2][2] = rubix[3][2][0];

        rubix[3][2][1] = rubix[3][1][0];
        rubix[3][2][0] = temp[0][0];

        rubix[3][1][0] = temp[0][1];
        //rotate attatched faces

        temp[0][2] = rubix[2][0][2];        
        temp[1][2] = rubix[2][1][2];        
        temp[2][2] = rubix[2][2][2];

        rubix[2][0][2] = rubix[0][0][2];
        rubix[2][1][2] = rubix[0][1][2];
        rubix[2][2][2] = rubix[0][2][2];
       
        rubix[0][0][2]= rubix[4][2][0];
        rubix[0][1][2]= rubix[4][1][0];
        rubix[0][2][2]= rubix[4][0][0];

        rubix[4][2][0] = rubix[5][0][2];
        rubix[4][1][0] = rubix[5][1][2];
        rubix[4][0][0] = rubix[5][2][2];

         rubix[5][0][2] = temp[0][2];
         rubix[5][1][2] = temp[1][2];
         rubix[5][2][2] = temp[2][2];


          break;
        case "q":
          run = false;
          break;
        case "s":
        System.out.println("To solve: ");
          for(int i=stack.size()-1; i>0; i--){
            System.out.print(stack.get(i-1)+" ");
          }
          System.out.println();

      }

    }

  }

}
