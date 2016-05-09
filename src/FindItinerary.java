
import java.util.*;

/**
 * Created by Bruno on 5/9/2016.
 */
public class FindItinerary {

    private class Airport implements Comparable<Airport>{
        private String code;

        public Airport(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Airport)) return false;

            Airport airport = (Airport) o;

            if (!code.equals(airport.code)) return false;
            return true;
        }

        @Override
        public int hashCode() {
            return code.hashCode();
        }

        @Override
        public int compareTo(Airport o) {
            return this.code.compareTo(o.code);
        }

        @Override
        public String toString() {
            return this.code;
        }
    }

    private class Pair<K, T>{
        private K k;
        private T t;
        public Pair(K k, T t){
            this.k = k;
            this.t = t;
        }

        public void setFirst(K k) {
            this.k = k;
        }

        public void setSecond(T t) {
            this.t = t;
        }

        public K getFirst(){
            return this.k;
        }


        public T getSecond(){
            return this.t;
        }
    }

    public static void main(String[] args){
        FindItinerary fi = new FindItinerary();
        System.out.println(fi.findItinerary(new String[][]{
                new String[] {"MUC", "LHR"},
                new String[] {"JFK", "MUC"},
                new String[] {"SFO", "SJC"},
                new String[] {"LHR", "SFO"},
        }));

        System.out.println(fi.findItinerary(new String[][]{
                new String[] {"JFK", "SFO"},
                new String[] {"JFK", "ATL"},
                new String[] {"SFO", "ATL"},
                new String[] {"ATL", "JFK"},
                new String[] {"ATL", "SFO"},
        }));


        System.out.println(fi.findItinerary(new String[][]{
                new String[] {"JFK", "KUL"},
                new String[] {"JFK", "NRT"},
                new String[] {"NRT", "JFK"},
        }));
    }

    public List<String> findItinerary(String[][] tickets) {
        HashMap<Airport, List<Pair<Boolean, Airport>>> graph = new HashMap<Airport, List<Pair<Boolean, Airport>>>();
        for (int i = 0; i < tickets.length; i++) {
            Airport from = new Airport(tickets[i][0]);
            Airport to = new Airport(tickets[i][1]);
            List<Pair<Boolean, Airport>> destinations = graph.getOrDefault(from, new ArrayList<Pair<Boolean, Airport>>());
            destinations.add(new Pair<Boolean, Airport>(false, to));
            graph.put(from, destinations);
        }
        int numTrips = 0;
        for(List<Pair<Boolean, Airport>> destinations : graph.values()){
            Collections.sort(destinations, new Comparator<Pair<Boolean, Airport>>() {
                @Override
                public int compare(Pair<Boolean, Airport> o1, Pair<Boolean, Airport> o2) {
                    return o1.getSecond().compareTo(o2.getSecond());
                }
            });
            numTrips += destinations.size();
        }
        List<Airport> itinerary = dfs(graph, numTrips);

        List<String> IATACodeItinerary = new ArrayList<String>();
        for(Airport airport : itinerary){
            IATACodeItinerary.add(airport.getCode());
        }
        return IATACodeItinerary;
    }

    private LinkedList<Airport> dfs(HashMap<Airport, List<Pair<Boolean, Airport>>> graph, int numTrips){
        LinkedList<Airport> itinerary = dfs(graph, new Airport("JFK"), new LinkedList<Airport>(), numTrips);
        itinerary.addFirst(new Airport("JFK"));
        return itinerary;
    }

    private LinkedList<Airport> dfs(HashMap<Airport, List<Pair<Boolean, Airport>>> graph, Airport airport, LinkedList<Airport> itinerary, int numTrips){
        if(itinerary.size() == numTrips)    return itinerary;
        List<Pair<Boolean, Airport>> destinations = graph.get(airport);
        if(destinations == null) return itinerary;
        for(Pair<Boolean, Airport> pair : destinations){
            if(pair.getFirst()) continue;
            Airport to = pair.getSecond();
            itinerary.add(to);
            pair.setFirst(true);
            if(dfs(graph, to, itinerary, numTrips).size() == numTrips)  return itinerary;
            pair.setFirst(false);
            itinerary.removeLast();
        }
        return itinerary;
    }
}
