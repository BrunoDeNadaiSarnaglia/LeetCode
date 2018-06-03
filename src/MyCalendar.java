public class MyCalendarThree {

  private List<Interval> intervals;

  public MyCalendar() {
      intervals = new ArrayList<Interval> ();
  }

  public boolean book(int start, int end) {
      Interval newBookRequest = new Interval(start, end);
      for(Interval interval : intervals) {
          if(interval.hasOverlap(newBookRequest)) {
              return false;
          }
      }
      intervals.add(newBookRequest);
      return true;
  }

  private class Interval {
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
  }
}
