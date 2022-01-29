// i have full faith in me , i can certainly do this , also gfg also has only height as an extra
// field  ,as comapred to bst , so i can do this too ,
// main problem which i am facing is that i am imagining a tree where in insertion has to be done,
// i think i will have to write all the cases and then aonly it can be done
// as AVL tree being an AVL might cancel out a lot of cases
// it took me freaking months to figure out the problem with the avl it was somewhere with the inheritance
// idk where it was , so now i will focus on learning it a bit
// i cannot pinpoint the exact problem with the inheritnce but it was the problem
// iwill have to learn inheritance, or maybe just plan my projects better
//maybe what i needed was to make generic methods for making the same method for bst and avl but what i ended
// up doing was inheritance i want t know where i went wrong but it is hard to point out without
// knowing oops that good

import java.util.ArrayList;
import java.util.Stack;

class AVL_Tree_Node {
    int height = 0;
    AVL_Tree_Node left;
    AVL_Tree_Node right;
    Employee data;

    // the height here is calculated as the number of max nodes below that particular
    // node and not as the level of the tree from the bottom
    public AVL_Tree_Node(Employee data, AVL_Tree_Node leftn, AVL_Tree_Node rightn) {
        this.data = data;
        this.left = leftn;
        this.right = rightn;
        height = 0;
    }

    public AVL_Tree_Node(Employee e) {
        this.data = e;
        this.left = null;
        this.right = null;
        height = 0;
    }

    public AVL_Tree_Node clone() {
        AVL_Tree_Node c = new AVL_Tree_Node(this.data, this.left, this.right);
        c.height = this.height;
        return c;
    }
}


public class AVL_Tree {
   // deletion of avl is suspended indefinitely
    AVL_Tree_Node head;
    int bf;

    public AVL_Tree(Employee a) {


        head = new AVL_Tree_Node(a, null, null);
        head.height = 0;
    }
    public AVL_Tree(AVL_Tree_Node a ){
        head = a;
    }

    private boolean insertioninternal(AVL_Tree_Node b, Employee employee) {
        if (employee.salary < b.data.salary) {
            if (b.left == null) {
                b.left = new AVL_Tree_Node(employee);
                if (b.right != null) {
                    return false;
                } // false means height has not been increased
                else {
                    b.height = b.height + 1;
                    return true;
                } // height will be increased
            }
            if (insertioninternal(b.left, employee)) {
                b.height = b.height + 1;
            }
            //}
            if (b.left == null && b.right != null) {
                bf = -1 - b.right.height;
            }
            if (b.left != null && b.right == null) {
                bf = b.left.height + 1;
            }
            if (b.left != null && b.right != null) {
                bf = b.left.height - b.right.height;
            }

            if (bf == 2 || bf == -2) {
                applyrotations(bf, b);
                System.out.println("head = " + this.head.data.firstname +
                        this.head.height + this.head.left.data.firstname + this.head.left.height +
                        this.head.right.data.firstname + this.head.right.height);
            }


        }
        if (employee.salary > b.data.salary) {
            if (b.right == null) {
                b.right = new AVL_Tree_Node(employee);
                if (b.left != null) {
                    return false;
                } // false means height has not been increased
                else {
                    b.height = b.height + 1;
                    return true;
                } // height will be increased
            }
            if (insertioninternal(b.right, employee)) {
                b.height = b.height + 1;
            }
            if (b.left == null && b.right != null) {
                bf = -1 - b.right.height;
            }
            if (b.left != null && b.right == null) {
                bf = b.left.height + 1;
            }
            if (b.left != null && b.right != null) {
                bf = b.left.height - b.right.height;
            }
            if (bf == 2 || bf == -2) {
                applyrotations(bf, b);
            }

        }
        return true;
    }

    public void insertion(Employee employee) {

        insertioninternal(this.head, employee);
    }

    private void LL_rotation(AVL_Tree_Node node_which_is_unbalanced) {
        AVL_Tree_Node a = node_which_is_unbalanced;
        AVL_Tree_Node c = a.left;
        AVL_Tree_Node f = a.clone();
        a.data = c.data;
        a.left = c.left;
        a.right = f;
        f.left = c.right;
        settleheights(f);
        settleheights(a);

    }

    private void RR_rotation(AVL_Tree_Node node_which_is_unbalanced) {
          /*
                       a
                      / \
                     b   c
                        / \
                       d   e
                            \
                             g
            here a is the node with not a good balance factor and for that ,
            i will first make a clone of a , then put c's data in a
            then will just manage and d will be on the right of a's clone
           */
        // in these rotations the node is an object which by the method gets manipluated and hence i don not have to return anything
        AVL_Tree_Node a = node_which_is_unbalanced;
        AVL_Tree_Node c = a.right;
        AVL_Tree_Node f = a.clone();
        a.data = c.data;
        a.right = c.right;
        a.left = f;
        f.right = c.left;
        // after all this i expect the garbage collector to collect c
        settleheights(f);
        settleheights(a);

    }


    private void LR_rotation(AVL_Tree_Node node_which_is_unbalanced) {
        RR_rotation(node_which_is_unbalanced.left);
        LL_rotation(node_which_is_unbalanced);
    }

    private void RL_rotation(AVL_Tree_Node node_which_is_unbalanced) {
        LL_rotation(node_which_is_unbalanced.right);
        RR_rotation(node_which_is_unbalanced);
    }

    private void settleheights(AVL_Tree_Node f) {
        if (f.left != null && f.right != null) {
            if (f.left.height > f.right.height) {
                f.height = f.left.height + 1;
            } else {
                f.height = f.right.height + 1;
            }

        } else if (f.left != null && f.right == null) {
            f.height = f.left.height + 1;
        } else if (f.left == null && f.right != null) {
            f.height = f.right.height + 1;
        } else if (f.left == null && f.right == null) {
            f.height = 0;
        }
    }

    private void applyrotations(int bf, AVL_Tree_Node node) {// bf is balance factor = left.height - right.height
        System.out.println("unabalanced node = " + node.data.firstname + node.height + "_" + bf);
        //  if(node.data.firstname.equals("a") && node.height == 2){System.out.println(node.left.data.firstname);}

        if (bf == -2) {
            if (node.right.left == null) {
                RR_rotation(node);
            } else {
                RL_rotation(node);
            }
        }
        if (bf == 2) {
            if (node.left.right == null) {
                LL_rotation(node);
            } else {
                LR_rotation(node);
            }
        }


    }

    private void inordertraversal(AVL_Tree_Node b, Stack<AVL_Tree_Node> stack) {
        if (b.left == null && b.right == null) {
            stack.add(b);
            return;
        }
        if (b.left != null) {
            inordertraversal(b.left, stack);
        }

        stack.add(b);
        if (b.right != null) {
            inordertraversal(b.right, stack);
        }
        return;
    }

    public AVL_Tree_Node depthfind(int salary) {
        Stack<AVL_Tree_Node> stack = new Stack<>();
        AVL_Tree_Node node;
        stack.add(head);
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (salary == (node.data.salary)) {
                return node;
            }
            stack.add(node.left);
            stack.add(node.right);

        }
        // not found
        return null;
    }

    public AVL_Tree_Node breadthfind(int salary) {
        // i cant find queue in java jdk hence i will use java stack as a queue
        Stack<AVL_Tree_Node> stack = new Stack<>();

        AVL_Tree_Node node;
        stack.add(head);
        while (!stack.isEmpty()) {
            node = stack.get(0);
            stack.removeElementAt(0);
            if (salary == (node.data.salary)) {
                return node;
            }
            stack.add(node.left);
            stack.add(node.right);
        }
        // not found
        return null;

    }

    public ArrayList<AVL_Tree_Node> inordertraversal() {

        Stack<AVL_Tree_Node> stack = new Stack<>();
        inordertraversal(this.head, stack);
        ArrayList<AVL_Tree_Node> rstack = new ArrayList<>();
        while (!stack.isEmpty()) {
            AVL_Tree_Node e = stack.remove(0);
            // here by removing at from 0 , i am only using stack as a queue i need a queue in here
            System.out.print(e.data.firstname + "  ");
            rstack.add(e);
        }
        return rstack;
    }

    private void preordertraversal(AVL_Tree_Node b, Stack<AVL_Tree_Node> stack) {

        if (b.left == null && b.right == null) {
            stack.add(b);
            return;
        }
        stack.add(b);
        if (b.left != null) {
            preordertraversal(b.left, stack);
        }


        if (b.right != null) {
            preordertraversal(b.right, stack);
        }
        return;

    }

    public ArrayList<AVL_Tree_Node> preordertraversal() {
        Stack<AVL_Tree_Node> stack = new Stack<>();
        preordertraversal(this.head, stack);
        ArrayList<AVL_Tree_Node> rstack = new ArrayList<>();
        while (!stack.isEmpty()) {
            AVL_Tree_Node e = stack.remove(0);
            System.out.print(e.data.firstname + "  ");
            rstack.add(e);

        }
        return rstack;

    }

    private void postordertraversal(AVL_Tree_Node b, Stack<Employee> stack) {

        if (b.left == null && b.right == null) {
            stack.add(b.data);
            return;
        }

        if (b.left != null) {
            postordertraversal(b.left, stack);
        }


        if (b.right != null) {
            postordertraversal(b.right, stack);
        }
        stack.add(b.data);
        return;

    }

    public ArrayList<Employee> postordertraversal() {
        Stack<Employee> stack = new Stack<>();
        postordertraversal(this.head, stack);
        ArrayList<Employee> rstack = new ArrayList<>();

        while (!stack.isEmpty()) {
            Employee e = stack.remove(0);
            System.out.print(e.firstname + "  ");
            rstack.add(e);
        }
        return rstack;
    }



    public void printtree(){
        // find max number of left nodes , the breadth
        AVL_Tree_Node a = this.head;
        int left = 0;
        while(a.left!= null || a.right != null){
            if(a.left != null){a = a.left;
            left++;
            continue;}
            else{
                a = a.right;
                left--;

            }
        }
        int right = 0;
        a = this.head;
        while(a.left!= null || a.right != null){
            if(a.right != null){a = a.right;
                right++;
                continue;}
            else{
                a = a.left;
                right--;

            }
        }

    }
    // start -> 0 and end -> ar.size()-1 , ar = inorder
    public static AVL_Tree_Node mfrominandpre(ArrayList<AVL_Tree_Node> in, ArrayList<AVL_Tree_Node> pre, int start , int end){

      /* if(end == start){
           AVL_Tree_Node a = pre.get(start);
           a.left = null;
           a.right = null;

           return a;}
           i thouht this was supposed to be here , but it works without this so good enough*/
        //if(end == start+1){System.out.print("brrrrrrrrrrrrrrr");}
        for(int i = 0; i < pre.size() ; i++){AVL_Tree_Node root;
            root = pre.get(i);
            if(in.contains(root)&& in.indexOf(root) <= end && in.indexOf(root) >= start){
            int st = start;

            int en  = in.indexOf(root) - 1;
            root.left = mfrominandpre(in , pre , st , en);
            st = in.indexOf(root) +1;
            en = end;
            root.right = mfrominandpre(in , pre , st, en);
                return root;}
        }

        return null;
    }
}
