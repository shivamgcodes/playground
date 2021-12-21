import java.util.Scanner;
// float[rows][columns]


public class raydiagrams {

    public static float[][] findinverseoftwobytwo(float[][] original){
        float[][] inverse = new float[2][2];
        float commonfactor = 1/(original[1][1]*original[0][0] - original[1][0]*original[0][1]);
        inverse[0][0] = commonfactor*(original[1][1]);
        inverse[1][1] = commonfactor*(original[0][0]);
        inverse[0][1] = commonfactor*(original[0][1]);
        inverse[1][0] = commonfactor*(original[1][0]);


     return  inverse;
    }
    public static float[][] multiplication(float[][] firstm , float[][] secondm){
 float[][] product = new float[firstm.length][secondm[0].length];
 int con = secondm.length;
   for(int i =0 ; i < product.length ; i++){
       for (int j = 0 ; j< product[i].length ; j++){
           float cur = 0;
            for(int k = 0 ; k < secondm.length ; k++){
               cur = cur +( firstm[i][k] *secondm[k][j]);
           }
            product[i][j] = cur;
       }
   }


 return product;
    }
    public static void printmatrix(float[][] matrix){
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[i].length ; j++){
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args){
 float[][] arr = new float[3][3];
 float[][] arr2 = new float[3][2];

        Scanner sc = new Scanner(System.in);


    printmatrix(arr);
    printmatrix(arr2);
    printmatrix(findinverseoftwobytwo(arr));
    printmatrix(multiplication(arr , arr2));

    }
 }
