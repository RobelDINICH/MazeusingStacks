/*
File or Class name: Main
Program author(s): Robel Tadele
Course number and title: COSC2203, Data Structures Section 1
Assignment number and name: Amazing Life (Assignment 2B)
Due date: Sep 16 2020
Brief description of the purpose of the program: Finding a path through a Maze

 */

package com.Robel;

public class Main extends Life{

    public static void main(String[] args) throws Exception {

        //Trying to simulate a 3X3 maze
        int[][] Grid = {{ 1,1,1,1,1},
                         {1,0,0,1,1},
                         {1,1,0,1,1},
                         {1,0,0,0,1},
                         {1,1,1,1,1}
        };

        //Custom Stack Declaration
        RobelStack<Object> stacker = new RobelStack<>();

        //Current Postition of Character in the maze
        Location cp = new Location();

        //End of Maze Location
        int x_end = Grid[3][3];
        int y_end = Grid[3][3];

        //While not target (end) location, loop iterates
        while(!(x_end == cp.x && y_end == cp.y)){

            //Checking cell to the North
            if(Grid[cp.x - 1][cp.y] == 0) {
                stacker.push(new Location(cp.x, cp.y));
                Grid[cp.x][cp.y] = 1;
                cp.x--;
            }
            //Checking cell to the South
            if(Grid[cp.x + 1][cp.y] == 0) {
                stacker.push(new Location(cp.x, cp.y));
                Grid[cp.x][cp.y] = 1;
                cp.x++;
            }
            //Checking cell to the West
            if(Grid[cp.x][cp.y - 1] == 0) {
                stacker.push(new Location(cp.x, cp.y));
                Grid[cp.x][cp.y] = 1;
                cp.y--;
            }
            //Checking cell to the East
            if(Grid[cp.x][cp.y + 1] == 0) {
                stacker.push(new Location(cp.x, cp.y));
                Grid[cp.x][cp.y] = 1;
                 cp.y++;
            }

            //If Stack isn't empty we backtrace when encountering dead ends

            if (!stacker.isEmpty()) {
                cp = (Location) stacker.pop();
            }

            else {
                System.out.println("No path Found");
                break;
            }
        }
    }
}