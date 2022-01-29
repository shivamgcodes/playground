import java.util.ArrayList;
import java.util.Stack;

public class trial {
    public static void main(String[] args) {

        AVL_Tree bst = new AVL_Tree(new Employee("a", "a", 100));
        Employee b = new Employee("b", "b", 80);
        Employee c = new Employee("c", "c", 120);
        Employee d = new Employee("d", "d", 90);
        Employee e = new Employee("e", "e", 110);
        Employee f = new Employee("f", "f", 130);
        Employee g = new Employee("g", "g", 105);
        Employee h = new Employee("h", "h", 125);
        Employee i = new Employee("i", "i", 140);

        bst.insertion(b);
        bst.insertion(d);
        bst.insertion(c);
        bst.insertion(e);
        bst.insertion(g);
        bst.insertion(f);
        bst.insertion(h);
        bst.insertion(i);
        //System.out.print("inorder traversal :- ");
        ArrayList<AVL_Tree_Node> in = bst.inordertraversal();
        ArrayList<AVL_Tree_Node> pre = bst.preordertraversal();
        AVL_Tree bs = new AVL_Tree(AVL_Tree.mfrominandpre(in , pre , 0 , in.size() - 1));
        ArrayList<AVL_Tree_Node> in2 = bs.inordertraversal();
        ArrayList<AVL_Tree_Node> pre2 = bs.preordertraversal();
        System.out.println("\ninorder1: -");
        for(int kl = 0 ; kl < in.size() -1 ; kl++){System.out.print(in.get(kl).data.firstname +" ");}

        System.out.println("\ninorder2: -");
        for(int kl = 0 ; kl < in2.size() -1 ; kl++){System.out.print(in2.get(kl).data.firstname+" ");}

        System.out.println("\npre1: -");
        for(int kl = 0 ; kl < pre.size() -1 ; kl++){System.out.print(pre.get(kl).data.firstname+" ");}

        System.out.println("\npre2: -");
        for(int kl = 0 ; kl < pre2.size() -1 ; kl++){System.out.print(pre2.get(kl).data.firstname+" ");}

       // ArrayList<Employee> in = bst.inordertraversal();

       // System.out.println(bst.head.data.firstname);
     //   System.out.println(bst.head.right.left.data.firstname);
      //  System.out.println(bst.head.right.right.data.firstname);

        //System.out.println(" a = " + bst.levels(bst.head));
       // bst.constructfrom_in_and_pre(in , pre);




// i WAS JUST READING THE IMPplimentation of vector remove element at in java , ofc , i found out that whenever the method was done , everyelement w
        //would get shifted a position down, but instead if i am removing at the front how about i just change the memory address the
        //the array object points to , just forget the 0th index and point it to the first one
    }
}
// two problems are still there  - 1 - that my avl tree cannot go beyod the height of 3;
// 2 - inorder etc is not working with avl so all my attempts at inheritance have failed miserably