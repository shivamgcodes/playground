// i have full faith in me , i can certainly do this , also gfg also has only height as an extra
// field  ,as comapred to bst , so i can do this too ,
// main problem which i am facing is that i am imagining a tree where in insertion has to be done,
// i think i will have to write all the cases and then aonly it can be done
// as AVL tree being an AVL might cancel out a lot of cases

class AVL_Tree_Node extends binarytreenode{
    int height = 0;
    AVL_Tree_Node left;
    AVL_Tree_Node right;
    public AVL_Tree_Node(Employee data, AVL_Tree_Node leftn, AVL_Tree_Node rightn) {
        super(data, leftn, rightn);
        height = 0;
    }

    public AVL_Tree_Node(Employee e) {
        super(e);
        height = 0;
    }
    public AVL_Tree_Node clone(AVL_Tree_Node node){
        AVL_Tree_Node c = new AVL_Tree_Node(node.data , node.left , node.right);
        c.height = node.height;
        return c;
    }
}
public class AVL_Tree extends binary_search_tree{
   AVL_Tree_Node head;

    public AVL_Tree(Employee a) {
        super(a);
    }
    private boolean insertioninternal(AVL_Tree_Node b, Employee employee) {
        if (employee.salary < b.data.salary) {
            if (b.left == null) {
                b.left = new AVL_Tree_Node(employee);
                if(b.right != null){return false;} // false means height has not been increased
                else{b.height = b.height + 1;
                    return true;} // height will be increased
            }
            if(insertioninternal(b.left, employee)){b.height = b.height + 1 ;}
        }
        if (employee.salary > b.data.salary) {
            if (b.right == null) {
                b.right = new AVL_Tree_Node(employee);
                if(b.left != null){return false;} // false means height has not been increased
                else{b.height = b.height+1;
                    return true;} // height will be increased
            }
            if(insertioninternal(b.right, employee)){b.height = b.height + 1;}
        }
    return true;}
    public void insertion(Employee employee){

        insertioninternal(this.head , employee);
    }
    private void LL_rotation(AVL_Tree_Node node_which_is_unbalanced){

    }
    private void RR_rotation(AVL_Tree_Node node_which_is_unbalanced){
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
    }
    private void LR_rotation(AVL_Tree_Node node_which_is_unbalanced){}
    private void RL_rotation(AVL_Tree_Node node_which_is_unbalanced){}



}