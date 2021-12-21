import java.util.Random;
//what is a circular array, impliment deque, impliment circular arrayand i could not understand the priority queue X heap collab
class nodesl {
    nodesl next;
    nodesl prev;
    nodesl down;
    nodesl up;
    int data;

    public nodesl(nodesl n, nodesl p, nodesl d, nodesl u, int da) {
        next = n;
        prev = p;
        up = u;
        down = d;
        data = da;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        nodesl copy = new nodesl(this.next, this.prev, this.down, this.up, this.data);
        return copy;
    }


}

class skiplist {

    int maxlevels;
    nodesl start;

    public skiplist(int ma) throws CloneNotSupportedException {
        maxlevels = ma;
        nodesl cur = new nodesl(null, null, null, null, -2147483648);
        for (int i = 0; i < maxlevels; i++) {
            System.out.println(cur.toString());
            cur.up = (nodesl) cur.clone();
            cur.up.down = cur;
            cur = cur.up;
        }
        this.start = cur;
    }

    public nodesl searchelement(int da) {
        nodesl cur = start;
        while (true) {
            if (cur.data == da) {
                while (cur.down != null) {
                    cur = cur.down;
                }
                return cur;
            }
            else if (cur.data < da && cur.next != null && cur.next.data <= da) {
                cur = cur.next;
            }
            else if (cur.data < da && cur.next != null && cur.next.data > da && cur.down != null) {
                cur = cur.down;
            }
            else if(cur.data < da && cur.next == null && cur.down != null){      cur = cur.down;      }

            else if (cur.data < da && cur.next == null && cur.down == null) {
                return null;
            }
            else if(cur.data < da && cur.next.data > da && cur.down == null){
                return null;
            }
        }
    }

    public void addelement(int da) throws CloneNotSupportedException {
        nodesl cur = start;
        while (true) {
            if (cur.data == da) {

                System.out.println("already there");
                return;
            }
            else if (cur.data < da && cur.next != null && cur.next.data <= da) {
                cur = cur.next;
            }
            else if (cur.data < da && cur.next != null && cur.next.data > da && cur.down != null) {
                cur = cur.down;}
            else if(cur.data < da && cur.next == null && cur.down != null){
                cur  = cur.down;
            }
            else if (cur.data < da && cur.next != null && cur.next.data > da && cur.down == null) {
                findpos(da, cur);
                return;
            }
            else if (cur.data < da && cur.next == null && cur.down == null){
                    findpos(da, cur);
                    return;
                }
             else if (cur.data < da && cur.next != null && cur.next.data > da && cur.down == null) {
                 findpos(da, cur);
                 return;
            }

        }
    }

    private void findpos(int da, nodesl cur) throws CloneNotSupportedException {

        nodesl tobadded = new nodesl(null, cur, null, null, da);

        cur.next = tobadded;
        Random rand = new Random();
        int currentlayerofcurrentelement = 0;
        coinflip:
        while (true && currentlayerofcurrentelement <= maxlevels) {
            int cflip = rand.nextInt(2);// 0 - > tails, 1-> heads
            if (cflip == 0) {
                break coinflip;
            }
            if (cflip == 1) {
                tobadded.up = (nodesl) tobadded.clone();
                tobadded.up.down = tobadded;

                tobadded = tobadded.up;
                if (cur.up != null) {
                    cur = cur.up;

                    cur.next = tobadded;
                    currentlayerofcurrentelement++;

                } else {
                    while (cur.up == null) {
                        cur = cur.prev;

                    }
                    cur = cur.up;

                    cur.next = tobadded;
                    currentlayerofcurrentelement++;
                }
            }
        }
        return;
    }

    public void deleteelement(int da){
        nodesl cur = start;
        while (true) {
            if (cur.data == da) {
                while (cur.down != null) {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                    cur = cur.down;
                }
                return ;
            } else if (cur.data < da && cur.next != null && cur.next.data <= da) {
                cur = cur.next;
            } else if (cur.data < da && cur.next != null && cur.next.data > da) {
                cur = cur.down;
            } else if (cur.data < da && cur.next.data > da && cur.down == null) {
                System.out.println("already not in the list");
                return;
            }
        }
    }
}

public class skiplisttry {
    public static void main(String[] args) throws CloneNotSupportedException {
        skiplist sl = new skiplist(5);
        sl.addelement(23);
        System.out.println("frist one");
        sl.addelement(34);
        System.out.println("frist one");
        sl.addelement(69);
        System.out.println("frist one");
        sl.addelement(38);
        System.out.println("frist one");
        nodesl ab = sl.searchelement(38);
        System.out.println(ab.data + " " + ab.down);
System.out.println(sl.searchelement(6969));

    }

}
