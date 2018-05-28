import java.util.List;

public class ExclusiveTimeOfFunctions {
  public int[] exclusiveTime(int n, List<String> logs) {
    Stack<Integer> stkExecution = new Stack<Integer>();
    int[] executionTimePerFunctionID = new int[n];
    int previousFid = getFunctionId(logs.get(0));
    boolean previousIsStarting = isStarting(logs.get(0));
    int previousTimeStamp = getTimestamp(logs.get(0));
    stkExecution.push(previousFid);
    for (int i = 1; i < logs.size(); i++) {
      int fid = getFunctionId(logs.get(0));
      boolean isStarting = isStarting(logs.get(0));
      int timeStamp = getTimestamp(logs.get(0));
      if(isStarting) {
        executionTimePerFunctionID[previousFid] += timeStamp - previousTimeStamp;
        stkExecution.push(fid);
      } else {
        executionTimePerFunctionID[fid] += timeStamp - previousTimeStamp;
        stkExecution.pop();
      }
      previousFid = fid;
      previousIsStarting = isStarting;
      previousTimeStamp = timeStamp;
    }
  }


  private int getFunctionId(String log) {
    return Integer.parseInt(log.split(":")[0]);
  }

  private boolean isStarting(String log) {
    return log.split(":")[0].equals("start");
  }

  private int getTimestamp(String log) {
    return Integer.parseInt(log.split(":")[2]);
  }
}
