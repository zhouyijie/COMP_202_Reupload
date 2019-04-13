public class StopWatch {
  private long startTime = 0;
  private long stopTime = 0;
  
  public static void main(String[] args) {
    StopWatch watch = new StopWatch();
    watch.start();
    for (int i = 0; i < 100; i++)
    {
      System.out.println("Im going to test how fast it is to print this 100 times");
    }
    watch.stop();
    System.out.println("It took " + watch.getTimeNano() +" nanoseconds to complete that task");
  }
  public void start() {
    this.startTime = System.nanoTime();
  }
  public void stop() {
    this.stopTime = System.nanoTime();
  }
  public long getTimeNano() {
    long elapsed;
    elapsed = stopTime - startTime;
    return elapsed;
  }
  public long getTimeMicro() {
    long elapsed;
    elapsed = (stopTime - startTime)/1000;
    return elapsed;
  }
  public long getTimeMilli() {
    long elapsed;
    elapsed = (stopTime - startTime)/1000000;
    return elapsed;
  }
  public long getTimeSecond() {
    long elapsed;
    elapsed = (stopTime - startTime)/1000000000;
    return elapsed;
  }
}
  