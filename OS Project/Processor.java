public class Processor {
    public String name;
    public int runningTime;
    public int startingTime;
    public int timeCame;
    public int timeCompleted;


    public Processor(String name, int runningTime, int startingTime){
        this.name = name;
        this.runningTime = runningTime;
        this.startingTime = startingTime;

    }

    public int getStartingTime()
        {
            return startingTime;
        }
    public String getName()
        {
            return name;
        }
    public int getRunningTime()
        {
            return runningTime;
        }    
}
