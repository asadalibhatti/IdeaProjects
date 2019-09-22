//Print a given matrix in spiral form

class HelloWorld
{
    static int n = 0;
    static int round = 0;


    static void spiralPrint(int[][] arr,int rowSize,int colSize)
    {
        int i = 0, j = 0, end = rowSize * colSize;
        while (true)
        {
            if (end <= 0)
                break;
            switch (n)
            {
                case 0://right ---->
                    //i = 0;
                    for ( ; j < colSize-round; j++)
                    {
                        System.out.print(arr[i][j]+" , ");


                        end--;
                    }
                    n = 1;
                    break;

                case 1://down |
                    j--;i++;
                    for ( ; i < rowSize-round; i++)
                    {
                        System.out.print(arr[i][j]+" , ");
                        end--;
                    }
                    n = 2;
                    break;

                case 2:// <----left
                    j--; i--;
                    for (; j >=0+round; j--)
                    {
                        System.out.print(arr[i][j]+" , ");
                        end--;
                    }
                    n = 3;
                    round ++;
                    break;

                case 3://up   |
                    j++; i--;
                    for (; i >= 0+round; i--)
                    {
                        System.out.print(arr[i][j]+" , ");
                        end--;
                    }
                    n = 0;
                    i++;j++;

                    break;

                default:
                    break;
            }
        }
    }
    public static void main(String[] args)
    {
        int[][] a = { {1, 2, 3, 4, 5, 6},
            {7, 8, 9, 10, 11, 12},
            {13, 14, 15, 16, 17, 18}};

        spiralPrint(a,3,6);
    }



}



