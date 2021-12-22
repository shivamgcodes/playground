class pair{
    int[] arr;
    int a;
    pair(int a , int[] arr){
        this.a = a;
        this.arr = arr;

    }
}
public class quicksort {
    // it has been a lot of time since i has started the project but have failes and hence i am now watching the solution
    // - the mistakes i made are - 1 -my traverse function focused on manipulating the array wehreas her's only focuses on getting the right position of pivot element
    //++i -> incerment first then assign
    // i++ - > assign first then increment
    // got it - what i focused on was that i merely made every element as the pivot element whereas i was supposed to do partitions -
    // find the correct position of pivot element - divide the array into two parts - then choose a pivot elemnt
    //so basically all of thi code is wrong


 // the method below is the initializer
 public static int[] quick(int[] arr  , int start , int end){


     if(start >= end ){
         return arr;
     }
     pair p = traverse(arr, start , end);
     arr = p.arr;
     int div = p.a;

     arr = quick(arr  , start , div-1);
     arr = quick(arr , div+1 ,end );
     return  arr;

 }

// this traverse function is putting the pivotelement in its right place and thats it
  public static pair traverse( int[] arr, int i , int j ){

    int pivotel = arr[i];
     boolean bool = false;
      while(true){

         while (bool)
         {

             if(i == j){arr[i] = pivotel;

             return new pair(i , arr);}

             if(arr[i] > pivotel){
                 arr[j] = arr[i];
                 j = j-1;
                 bool = false;
             }
             else {i = i+1;}

         }
         while(!bool){
             if(i == j){arr[i] = pivotel;

             return new pair(i , arr);}

             if(arr[j]  < pivotel){
                 arr[i] = arr[j];
                 i = i+1;
                 bool = true;
             }
             else {j = j-1 ;}
         }
     }

 }


    public static void main(String[] args){
     int[] arr = {15,5,74,855,6,4,2,8,9,3, 34 , 3 ,855, 2};
     System.out.println(arr.length);
    arr = quick(arr , 0, arr.length -1);
        for (int j : arr) {
            System.out.print(j + ", ");
        }
    }
}
