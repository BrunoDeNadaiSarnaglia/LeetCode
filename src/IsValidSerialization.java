/**
 * Created by Bruno on 5/5/2016.
 */
public class IsValidSerialization {

    public static void main(String[] args){
        IsValidSerialization is = new IsValidSerialization();
        System.out.print(is.isValidSerialization("9,#,#"));
        System.out.print(is.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }

    int i = 0;

    public boolean isValidSerialization(String preorder) {
        String[] list = preorder.split(",");
        return isValidSerialization2(list) && i == list.length - 1;
    }

    private boolean isValidSerialization2(String[] preorder) {
        if(i >= preorder.length){
            return false;
        }
        if(preorder[i].equals("#")){
            return true;
        }
        i++;
        if(!isValidSerialization2(preorder)){
            return false;
        }
        i++;
        if(!isValidSerialization2(preorder)){
            return false;
        }
        return true;
    }
}
