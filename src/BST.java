import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class binarytreenode {
    Employee data;
    binarytreenode left;
    binarytreenode right;

    public binarytreenode(Employee data, binarytreenode leftn, binarytreenode rightn) {
        this.data = data;
        this.left = leftn;
        this.right = rightn;
    }

    public binarytreenode(Employee e) {
        this.data = e;
        this.left = null;
        this.right = null;
    }
}

class binary_search_tree {

    binarytreenode head;

    public binary_search_tree(Employee a) {
        head = new binarytreenode(a, null, null);
    }

    private void insertioninternal(binarytreenode b, Employee employee) {
        if (employee.salary < b.data.salary) {
            if (b.left == null) {
                b.left = new binarytreenode(employee);
                return;
            }
            insertioninternal(b.left, employee);
        }
        if (employee.salary > b.data.salary) {
            if (b.right == null) {
                b.right = new binarytreenode(employee);
                return;
            }
            insertioninternal(b.right, employee);
        }
    }

    public void insertion(Employee employee) {
        binarytreenode b = this.head;
        if (employee.salary < b.data.salary) {
            if (b.left == null) {
                b.left = new binarytreenode(employee);
                return;
            }
            insertioninternal(b.left, employee);
        }
        if (employee.salary > b.data.salary) {
            if (b.right == null) {
                b.right = new binarytreenode(employee);
                return;
            }
            insertioninternal(b.right, employee);
        }

    }

    public int levels(binarytreenode putheadhere) {
        // go to the left root after that go to its right and root and then just keep checking rhe hights
        binarytreenode b = putheadhere;
        int level;
        if (b.left == null && b.right == null) {
            level = 0;
        } else if (b.left == null) {
            level = -1 * levels(b.right);
        } else if (b.right == null) {
            level = -1 * levels(b.left);
        } else {
            level = levels(b.left) - levels(b.right);
        }

        return level;
    }

    // these find ones can easily be overriden for searching by first name lastname, position , salary , age
    public binarytreenode depthfind(int salary) {
        Stack<binarytreenode> stack = new Stack<>();
        binarytreenode node;
        stack.add(head);
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (salary ==(node.data.salary)) {
                return node;
            }
            stack.add(node.left);
            stack.add(node.right);

        }
        // not found
        return null;
    }

    public binarytreenode breadthfind(int salary) {
        // i cant find queue in java jdk hence i will use java stack as a queue
        Stack<binarytreenode> stack = new Stack<>();

        binarytreenode node;
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

    // these methods are for returning the father of the desired node which is to be removed
    private binarytreenode depthfindforremoval(Employee employee) {
        Stack<binarytreenode> stack = new Stack<>();
        binarytreenode node;
        stack.add(head);
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (employee.equals(node.left.data) || employee.equals(node.right.data)) {
                return node;
            }
            stack.add(node.left);
            stack.add(node.right);

        }
        // not found
        return null;
    }

    private binarytreenode breadthfindremoval(Employee employee) {
        // i cant find queue in java jdk hence i will use java stack as a queue
        Stack<binarytreenode> stack = new Stack<>();

        binarytreenode node;
        stack.add(head);
        while (!stack.isEmpty()) {
            node = stack.get(0);
            stack.removeElementAt(0);
            if (employee.equals(node.left.data) || employee.equals(node.right.data)) {
                return node;
            }
            stack.add(node.left);
            stack.add(node.right);
        }
        // not found
        return null;


    }

    // i have not dealt with removing the leaf nodes or removing the nodes with just one child
    public void depthremove(Employee employee) {
        binarytreenode b = depthfindforremoval(employee);
        if (b.left.data.equals(employee)) {
            // incompelete , the web has a different way for dealing with delete for my way go to the paint document named removeinbst
            binarytreenode c = b.left.right;
            b.left = b.left.left;
            binarytreenode d = b.left;
            while (d.right != null && d.right.right != null) {
                d = d.right;

            }
            d.right = c;
            // what i am doing here is placing the right tree of the removed node at the bottom of the tree, but this will make the tree higly
            // unbalanced hence i will have to use the method on the web , i will most probably just clear this mess up the next time
        }
        if (b.right.data.equals(employee)) ;
    }

    private void inordertraversal(binarytreenode b, Stack<binarytreenode> stack) {
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

    public ArrayList<binarytreenode> inordertraversal() {

        Stack<binarytreenode> stack = new Stack<>();
        inordertraversal(this.head, stack);
        ArrayList<binarytreenode> rstack = new ArrayList<>();
        while (!stack.isEmpty()) {
            binarytreenode e = stack.remove(0);
            // here by removing at from 0 , i am only using stack as a queue i need a queue in here
            System.out.print(e.data.firstname + "  ");
            rstack.add(e);
        }
        return rstack;
    }

    private void preordertraversal(binarytreenode b, Stack<Employee> stack) {

        if (b.left == null && b.right == null) {
            stack.add(b.data);
            return;
        }
        stack.add(b.data);
        if (b.left != null) {
            preordertraversal(b.left, stack);
        }


        if (b.right != null) {
            preordertraversal(b.right, stack);
        }
        return;

    }

    public ArrayList<Employee> preordertraversal() {
        Stack<Employee> stack = new Stack<>();
        preordertraversal(this.head, stack);
        ArrayList<Employee> rstack = new ArrayList<>();
        while (!stack.isEmpty()) {
            Employee e = stack.remove(0);
            System.out.print(e.firstname + "  ");
            rstack.add(e);

        }
        return rstack;

    }

    private void postordertraversal(binarytreenode b, Stack<Employee> stack) {

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

    public binarytreenode constructfrom_in_and_pre(ArrayList<Employee> inorder, ArrayList<Employee> preorder, int start , int end) {

        // return the head , for the other recursed finctions just return the head of the subtree so that we can attach that one as the left or right
        Employee e = preorder.get(0);
        preorder.remove(0);

        binarytreenode h = new binarytreenode(e, null, null);
        if (inorder.contains(e)) {
            //h.left = constructfrom_in_and_pre((ArrayList<Employee>) inorder.subList(0, inorder.indexOf(e) + 1), preorder);
           // h.right = constructfrom_in_and_pre((ArrayList<Employee>) inorder.subList(inorder.indexOf(e), inorder.size()), preorder);

// here first of all i have to put a while loop in place of the if statement , also i will have to make the base cases
            // wherin the sizee of the list is 1 and i will just make that element into a node with null left and right
            // also i have to take care of the cases wherein the node has only left or only right child
        }


        return null;
    }

    public void make_from_in_and_pre(ArrayList<Employee> inorder , ArrayList<Employee> preorder){

    }
    public void delete(int salary, String breadthordepth) {
        binarytreenode tobedel = null;
        if (breadthordepth.contains("breadth")) {
            tobedel = breadthfind(salary);
        }
        if (breadthordepth.contains("depth")) {
            tobedel = depthfind(salary);
        }
        // if node has no children
        if (tobedel.left == null && tobedel.right == null) {
            tobedel = null;
            return;
        }
        //if node has only left children
        if (tobedel.left != null && tobedel.right != null) {
            //with inorder predecessor
            if (tobedel.left.right == null) {
                tobedel = tobedel.left;
                return;
            }

            ArrayList<binarytreenode> al = inordertraversal();
            int i = al.indexOf(tobedel);
            i--;
            binarytreenode b = al.get(i);
            tobedel.data = b.data;
            b = null;

            return;


        }
        tobedel = (tobedel.left == null) ? tobedel.left : tobedel.right;


    }
}


