import java.util.Iterator;

/**
 * Created by Bruno on 10/5/2016.
 */
public class WordCount {

 interface OutputCollector<K, V> {
     void collect(K key, V value);
         // Adds a key/value pair to the output buffer
 }


    public static class Map {
        public void map(String key, String value, OutputCollector<String, Integer> output) {
            for (String s: value.split(" ")) {
                output.collect(key, Integer.parseInt(value));
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, Integer> output) {
            int sum = 0;
            while (values.hasNext()){
                sum += values.next();
            }
            output.collect(key, sum);
        }
    }
}
