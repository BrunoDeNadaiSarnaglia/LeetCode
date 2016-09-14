import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Bruno on 9/14/2016.
 */
public class EvaluateDivision {


    public static void main(String[] args){
        EvaluateDivision a = new EvaluateDivision();
        System.out.print(a.calcEquation(
                new String[][]{
                        new String[]{"a", "b"},
                        new String[]{"b", "c"}
                },
                new double[]{
                        2.0,
                        3.0
                },
                new String[][]{
                        new String[]{"a", "c"},
                        new String[]{"b", "c"},
                        new String[]{"a", "e"},
                        new String[]{"a", "a"},
                        new String[]{"x", "x"}
                }
        ));
    }

    private class Edge {

        private String from;
        private String to;
        private double value;

        public Edge(String from, String to, double value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        public double getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from='" + from + '\'' +
                    ", to='" + to + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, List<Edge>> map = new HashMap<String, List<Edge>>();
        for (int i = 0; i < equations.length; i++) {
            String from = equations[i][0];
            String to = equations[i][1];
            double val = values[i];
            List<Edge> list = map.getOrDefault(from, new ArrayList<Edge>());
            list.add(new Edge(from, to, val));
            map.put(from, list);
            list = map.getOrDefault(to, new ArrayList<Edge>());
            list.add(new Edge(to, from, 1.0 / val));
            map.put(to, list);
        }
        System.out.println(map);
        HashMap<String, HashMap<String, Double>> map2 = new HashMap<String, HashMap<String, Double>>();
        for (String key: map.keySet()) {
            System.out.println(key + val(key, map));
            map2.put(key, val(key, map));
        }
        System.out.println(map2);
        double[] array = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if(map2.containsKey(queries[i][0]) && map2.get(queries[i][0]).containsKey(queries[i][1])){
                array[i] = map2.get(queries[i][0]).get(queries[i][1]);
            } else {
                array[i] = 0;
            }
        }
        return array;
    }

    private HashMap<String, Double> val(String from, HashMap<String, List<Edge>> graph){
        return val(from, graph, new HashSet<String>());
    }

    private HashMap<String, Double> val(String from, HashMap<String, List<Edge>> graph, HashSet<String> set){
        HashMap<String, Double> map = new HashMap<String, Double>();
        if(set.contains(from))  return map;
        set.add(from);
        for (Edge edge: graph.get(from)) {
            String to = edge.to;
            double val = edge.value;
            HashMap<String, Double> nMap = val(to, graph, set);
            for (String key: nMap.keySet()) {
                map.put(key, nMap.get(key) * val);
            }
            map.put(to, val);
        }
        return map;
    }


}
