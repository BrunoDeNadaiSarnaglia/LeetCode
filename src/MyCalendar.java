public class MyCalendarThree {

  private TreeSet<Interval> intervals;

  public MyCalendar() {
      intervals = new TreeSet<Interval> ();
  }

  public boolean book(int start, int end) {
      Interval newBookRequest = new Interval(start, end);
      Inteval ceiling = intervals.ceiling(newBookRequest); //instead of going through the array
      Inteval floor = intervals.ceiling(newBookRequest); // do a log(n) look up in a TreeSet
      if(ceiling.hasOverlap(newBookRequest) || floor.hasOverlap(newBookRequest)) {
        return false;
      }
      intervals.add(newBookRequest);
      return true;
  }

  private class Interval implements Comparable<Interval> {
    private int start;
    private int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

    public boolean hasOverlap(Interval interval) {
        if(interval.end <= this.start || interval.start >= this.end) {
            return false;
        }
        return true;
    }
    @Override
    public int compare(Interval interval) {
      return this.start - interval.start;
    }
  }
}
