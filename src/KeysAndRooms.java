import java.util.HashSet;

public class KeysAndRooms {
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    HashSet<Integer> setRooms = new HashSet<>();
    canVisitAllRooms(rooms, 0, setRooms);
    return setRooms.size() == rooms.size();
  }

  public void canVisitAllRooms(List<List<Integer>> rooms, int room, HashSet<Integer> roomsVisited) {
    if(roomsVisited.contains(room)) return;
    roomsVisited.add(room);
    for (Integer visit : rooms.get(room)) {
      canVisitAllRooms(rooms, visit, roomsVisited);
    }
  }
}
