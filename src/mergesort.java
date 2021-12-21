import java.lang.reflect.Array;
import java.util.Arrays;

public class mergesort {


    public static int[] merge(int[] arr, int start) {
        if(arr.length == 1){return  arr;}

        int[] leftarr = merge(Arrays.copyOfRange(arr , 0  , (arr.length)/2 ) , 0 );
        int[] rightarr = merge(Arrays.copyOfRange(arr, arr.length/2 , arr.length ) , arr.length/2);
        int[] temp = new int[arr.length];
            int li = 0;
            int ri = 0;
            for(int ab = 0 ; ab < arr.length; ab++){
                if(li == leftarr.length){
                    while (ab < arr.length){
                    temp[ab] = rightarr[ri];
                    ri++;
                    ab++;
                }
                break;
                }
                if(ri == rightarr.length){
                    while (ab < arr.length){
                        temp[ab] = leftarr[li];
                        li++;
                        ab++;
                    }
                    break;
                }
                if(leftarr[li] <= rightarr[ri]){temp[ab] = leftarr[li];
                li++;}
                else{temp[ab] = rightarr[ri];
                ri++;}
            }




        return temp;
    }

    public static void main(String[] args){
        int start = 0;
        int end = 5;
        int mid = (start + end )/2;
        System.out.println(mid);
        int[] arr = new int[9];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 85;
        arr[5] = 6;
        arr[6] = -7;
        arr[7] = 8;
        arr[8] = 9;
        int [] sortedarr = merge(arr , 0 );
        for(int k = 0 ; k < sortedarr.length ; k++){
            System.out.print(sortedarr[k] + " , ");
        }

    }

}
