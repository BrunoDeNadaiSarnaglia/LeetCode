public class StringCompression {
  public int compress(char[] chars) {
    int i = 0;
    int j = 0;
    int count = 1;
    while(j <= chars.length) {
      if(j < chars.length && chars[i] == chars[j]) {
        count++;
      } else if (count != 1) {
        int k = i;
        while(count != 0) {
          chars[++k] = count % 10 + '0';
          count /= 10;
        }
        int l = i + 1;
        i = k + 1;
        if(j < chars.length) {
          chars[i] = chars[j];
        }
        while(l < k) {
          int aux = chars[l];
          chars[l++] = chars[k];
          chars[k--] = aux;
        }
        count = 1;
      } else {
        chars[++i] = chars[j];
        count = 1;
      }
      j++;
    }
    return i + 1;
  }
}
