interface shivam<Integer, String> {}
// in this implimentation instead of saving the key differently from the employee ,
// i will just check for the last name in every employee object in the list
//for doing it the other way i think  all i will have to do i s add a key field to the node
public class hashtable {
   private int lf;
   private int size;
   private linkedlist[] mainarray;
hashtable(int lf , int size){
    this.lf = lf;
    this.size = size;
    mainarray = new linkedlist[size];
    for(int i = 0 ; i  < size ; i++){
        mainarray[i] = new linkedlist();
    }
}
private int hashing(String key){
    System.out.println((key.length()*key.charAt(0))% size);
    return (key.length()*key.charAt(0)) % size;
}
public void add(Employee employee){
    mainarray[hashing(employee.firstname)].add(employee);
    // i am not implimenting the load factor thing

}
public node retreive(String firstname){
    linkedlist list = mainarray[hashing(firstname)];
    return(list.retreivedata(firstname));

}

}
