
class pair {
    public int i, j;
    public pair(){
        i=0;
        j=0;
    }
    public pair (pair p){
        i=p.i;
        j=p.j;
    }

    public boolean equal(pair p, int val) {
        if (val == 1) {
            if (i == p.i && j == p.j + 1) {
                return true;
            }
        } else if (val == 2) {
            if (i == p.i && j == p.j - 1) {
                return true;
            }
        } else if (val == 3) {
            if (i == p.i - 1 && j == p.j) {
                return true;
            }
        } else if (val == 4) {
            if (i == p.i + 1 && j == p.j) {
                return true;
            }
        }
        return false;
    }
}
class solver {



     int n = 9; //n x n board
     int k = 1;
     int[][] board =

            {
                    {
                            0, 0, 0, 0, 0, 0, 0, 0, 0
                    },
                    {
                            0, 1, 6, 3, 0, 0, 0, 0, 0
                    },
                    {
                            0, 0, 0, 6, 5, 0, 5, 3, 0
                    },
                    {
                            0, 0, 0, 0, 0, 0, 0, 7, 0
                    },
                    {
                            0, 2, 0, 2, 1, 0, 0, 0, 0
                    },
                    {
                            4, 7, 0, 0, 0, 0, 0, 8, 9
                    },
                    {
                            0, 9, 4, 0, 0, 0, 0, 0, 0
                    },
                    {
                            0, 8, 0, 0, 0, 0, 0, 0, 0
                    },
                    {
                            0, 0, 0, 0, 0, 0, 0, 0, 0
                    }


            };

     pair[] labels1 = new pair[n + 1];// labels arra


    pair[] labels = new pair[n + 1];

     boolean present(int num) {




        for (int i = 1; i < k; i++) {
            if (board[labels1[i].i][labels1[i].j] == num && num != 0) {
                return true;
            }
        }
        return false;
    }

     void initializeLabel() {
        //printSol();
        //initializing lablel1
         for(int i=0;i<n+1;i++){
             labels1[i]=new pair();
         }
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) {
                    if (k >= n + 1) {
                        i = n + 1;
                        break;
                    }
                    //check if already num not present in labels pair
                    if (!present(board[i][j])) {
                        //labels1 = new pair[n + 1];
                        labels1[k].i = i;
                        labels1[k].j = j;
                        k++;
                    }
                    //else no label inserted


                }
            }

        }
         //initializing lablel
         for(int i=0;i<n+1;i++){
             labels[i]=new pair();
         }


         //copy labels1 to labels
        for (int i = 1; i < k; i++) {
            labels[i].i = labels1[i].i;
            labels[i].j = labels1[i].j;
        }


        //print lables
         //or printing numbers that had to match to solve puzzle
         System.out.print("Labels are: ");
        for (int j = 1; j < k; j++) {
            System.out.print(board[labels[j].i][labels[j].j] + ",");
        }
        System.out.println();
    }

    public  void printSol() {
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] >= 10) {
                    System.out.print(board[i][j] / 10 + ",");
                } else
                    System.out.print(board[i][j] + ",");

            }
            System.out.println();
        }


    }


     boolean findPaths(pair start, pair current, int lIndex) {
       printSol();

        if (lIndex >= labels.length) {
            return true;//path found returning true.......
        }
        if (lIndex == k) {
            System.out.print("");
            return true;//path found returning true.......
        }


        // right path check
        if (current.j + 1 < n && board[current.i][current.j + 1] == 0)//path present toward right
        {

            current.j++;
            board[current.i][current.j] = board[start.i][start.j] * 10;
            //printSol();
            if (findPaths(new pair(start), new pair(current), lIndex))
                return true;
            //else , backtrack
            board[current.i][current.j] = 0;
           // printSol();
            current.j--;
        }

        //checking if right had matched
        else if (current.j + 1 < n && !start.equal(current, 1) && board[current.i][current.j + 1] ==
                board[start.i][start.j]) {
            if (lIndex + 1 >= labels.length) {
                return true;// all paths found returning true.......
            }
            //again recurse with +1 lindex
            if (findPaths(new pair(labels[lIndex + 1]),new pair( labels[lIndex + 1]), lIndex + 1))
                return true;
            //else go to belwo conditions

        }


        // left path check
        if (current.j - 1 >= 0 && board[current.i][current.j - 1] == 0)//path present toward right
        {

            current.j--;
            board[current.i][current.j] = board[start.i][start.j] * 10;

            if (findPaths(new pair(start), new pair(current), lIndex))
                return true;
            //else , backtrack
            board[current.i][current.j] = 0;
             //printSol();
            current.j++;
        }

        //checking if left had matched
        else if (current.j - 1 >= 0 && !start.equal(current, 2) && board[current.i][current.j - 1] ==
                board[start.i][start.j]) {
            if (lIndex + 1 >= labels.length) {
                return true;// all paths found returning true.......
            }
            //again recurse with +1 lindex
            if (findPaths(new pair(labels[lIndex + 1]),new pair( labels[lIndex + 1]), lIndex + 1))
                return true;
            //else go to below conditions

        }


        // upward path check
        if (current.i - 1 >= 0 && board[current.i - 1][current.j] == 0)//path present upward
        {

            current.i--;
            board[current.i][current.j] = board[start.i][start.j] * 10;
            if (findPaths(new pair(start), new pair(current), lIndex))
                return true;
            //else backtrack
            board[current.i][current.j] = 0;
            //printSol();
            current.i++;
        }

        //checking if up had matched
        else if (current.i - 1 >= 0 && !start.equal(current, 3) && board[current.i - 1][current.j] ==
                board[start.i][start.j]) {
            //block matched ,
            //recurse further
            if (lIndex + 1 >= labels.length) {
                return true;// all paths found returning true.......
            }
            if (findPaths(new pair(labels[lIndex + 1]),new pair( labels[lIndex + 1]), lIndex + 1))
                return true;
            //else go to belwo conditions

        }


        // downward path check
        if (current.i + 1 < n && board[current.i + 1][current.j] == 0)//path present upward
        {

            current.i++;
            board[current.i][current.j] = board[start.i][start.j] * 10;
            if (findPaths(new pair(start), new pair(current), lIndex))
                return true;
            //else backtrack
            board[current.i][current.j] = 0;
            //printSol();
            current.i--;
        }

        //checking if up had matched
        else if (current.i + 1 < n && !start.equal(current, 4) && board[current.i + 1][current.j] ==
                board[start.i][start.j]) {
            //block matched ,
            //recurse further
            if (lIndex + 1 >= labels.length) {
                return true;// all paths found returning true.......
            }
            if (findPaths(new pair(labels[lIndex + 1]),new pair( labels[lIndex + 1]), lIndex + 1))
                return true;
            //else go to belwo conditions

        }

        //else returning False
        return false;

    }

    public  void findSolution() {
        initializeLabel();

        System.out.println("\nFinding Solotion, Please Wait . . ...");
        if (findPaths(new pair(labels1[1]), new pair(labels1[1]), 1)) {
            System.out.print("Solution is : ");
            printSol();

        } else {
            System.out.print("/n/nSol not possible");
        }
    }



}
class puzzleSolver{
    public static void main(String arg[]){
        solver obj=new solver();
        obj.findSolution();
    }
}









