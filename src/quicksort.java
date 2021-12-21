public class quicksort {
    // it has been a lot of time since i has started the project but have failes and hence i am now watching the solution
    // - the mistakes i made are - 1 -my traverse function focused on manipulating the array wehreas her's only focuses on getting the right position of pivot element
    //++i -> incerment first then assign
    // i++ - > assign first then increment
    // got it - what i focused on was that i merely made every element as the pivot element whereas i was supposed to do partitions -
    // find the correct position of pivot element - divide the array into two parts - then choose a pivot elemnt
    //so basically all of thi code is wrong
 public static int[] quicksortmeth(int[] arr , int pno){

     if(arr.length == pno){
         return arr ;
     }

     int pivotel = arr[pno];
     arr = traverse(arr , 0 , arr.length -1, pivotel , true);
     for(int k = 0 ; k< arr.length ; k++){
         System.out.print(arr[k] + " ,");

     }  System.out.println(" ");
   return   quicksortmeth(arr, pno+1);

 }

  public static int[] traverse( int[] arr, int i , int j , int pivotel, boolean bool){
    while(true){
     if(bool){
         while (bool)
         {
             if(i == j){arr[i] = pivotel;
             return arr;}

             if(arr[i] > pivotel){
                 arr[j] = arr[i];
                 --j;
                 bool = false;
             }
             else {++i;}

         }
         while(!bool){
             if(i == j){arr[i] = pivotel;
             return arr;}
             if(arr[j]  < pivotel){
                 arr[i] = arr[j];
                 ++i;
                 bool = true;
             }
             else {--j ;}
         }
     }}

 }
    public static void main(String[] args){
     int[] arr = {15,5,74,855,4,6,3,6,4,3,2,5,8,9,5,3,2};
     System.out.println(arr.length);
    arr = quicksortmeth(arr , 0);
  for(int i  = 0 ; i < arr.length ;i ++){System.out.print(arr[i] +", ");}
    }
}
