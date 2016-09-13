import java.util.Iterator;

public class DecodeString {

    private class StringIterator implements Iterator<Character> {

        private String string;
        private int idx = 0;

        public StringIterator(String string) {
            this.string = string;
        }

        @Override
        public boolean hasNext() {
            return this.idx != this.string.length();
        }

        @Override
        public Character next() {
            return this.string.charAt(this.idx++);
        }

        @Override
        public void remove() {

        }
    }

    private StringBuilder decodeBrackets(Iterator<Character> it){
        StringBuilder sb = new StringBuilder();
        int val = 0;
        while(it.hasNext()){
            Character ch = it.next();
            if('0' <= ch && ch <= '9'){
                val *= 10;
                val += ch - '0';
            } else if(ch == '['){
                StringBuilder sb2 = decodeBrackets(it);
                while (val != 0){
                    sb.append(sb2);
                    val--;
                }
            } else if(ch == ']'){
                break;
            } else {
                sb.append(ch);
            }
        }
        return sb;
    }

    public String decodeString(String s) {
        Iterator<Character> it = new StringIterator(s);
        StringBuilder acc = decodeBrackets(it);
        return acc.toString();
    }
}
