import java.util.Stack;

/**
 * Created by Bruno on 10/5/2016.
 */
public class Tower {

    private Stack<Integer> disks;
    // create three towers (i from 0 to 2)
    public Tower(int i) {
        disks = new Stack<Integer>();
    }

    // Add a disk into this tower
    public void add(int d) {
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }

    // @param t a tower
    // Move the top disk of this tower to the top of t.
    public void moveTopTo(Tower t) {
        if(!disks.isEmpty()){
            t.add(this.disks.pop());
        }
    }

    // @param n an integer
    // @param destination a tower
    // @param buffer a tower
    // Move n Disks from this tower to destination by buffer tower
    public void moveDisks(int n, Tower destination, Tower buffer) {
        if(n == 0)  return;
        moveDisks(n - 1, buffer, destination);
        this.moveTopTo(destination);
        buffer.moveDisks(n-1, destination, this);
    }

    public Stack<Integer> getDisks() {
        return disks;
    }
}
