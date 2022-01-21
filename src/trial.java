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

        bst.inordertraversal();
       // System.out.println(bst.head.data.firstname);
     //   System.out.println(bst.head.right.left.data.firstname);
      //  System.out.println(bst.head.right.right.data.firstname);
        System.out.println("\n");
        bst.preordertraversal();
        System.out.println("\n");
        bst.postordertraversal();
        System.out.println(" a = " + bst.levels(bst.head));

        System.out.println("//////////////////////////////////////////////////////////////////////////");

        AVL_Tree avl = new AVL_Tree(new Employee("a", "a", 100));
        avl.insertion(new Employee("b", "b", 80));
        avl.insertion(new Employee("c", "c ", 70));
        System.out.println(avl.head.data.firstname);
        System.out.println(avl.head.left.data.firstname);
        System.out.println(avl.head.right.data.firstname);
        avl.inordertraversal();


// i WAS JUST READING THE IMPplimentation of vector remove element at in java , ofc , i found out that whenever the method was done , everyelement w
        //would get shifted a position down, but instead if i am removing at the front how about i just change the memory address the
        //the array object points to , just forget the 0th index and point it to the first one
    }
}
// two problems are still there  - 1 - that my avl tree cannot go beyod the height of 3;
// 2 - inorder etc is not working with avl so all my attempts at inheritance have failed miserably