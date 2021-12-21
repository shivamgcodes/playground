
class node {
    Employee data;
    node next;

    node(Employee da, node ne) {
        data = da;
        next = ne;

    }

     @Override
     protected Object clone() throws CloneNotSupportedException {
         node copy = new node(this.data , this.next);
         return copy;
     }
 }
 class linkedlist{
    static node head;
    int size = 0;
    node latest;
    linkedlist(){
        head = new node(null , null);
        size = 0;
        latest = head;
    }
    void add(Employee data){
        head.next = new node(data , null);
        latest = latest.next;
        size++;
    }
    node retreivedata(String key){
        node start = this.head;
        start = start.next;
        while(start.next != null && start.next.data.firstname != key ){start = start.next;}
        return start;

    }
 }
public class listimpliment {
    // just impliment a full fledged linked lit in here
    // in java = (assignment operator only copies the references for objects, hence making a shllow copy)


    public static void main(String[] args) throws CloneNotSupportedException {

 Employee shivam = new Employee("shivam", "gupta" , "CEO,FOUNDER" , 24 , 9999);
 Employee wok = new Employee("hoga", "Koi" , "worker" , 259 , 21);
hashtable hashtable  = new hashtable(22 , 22);
hashtable.add(shivam);
hashtable.add(wok);
node cur = hashtable.retreive("shivam");
cur.data.print();

}}
