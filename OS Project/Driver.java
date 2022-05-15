import java.util.ArrayList;
import java.util.Random;
public class Driver{
  
    public static void main (String[] args) throws InterruptedException{
    int CHANCE_OF_ARRIVAL = 1;
    int MIN_TIME = 1;
    int MAX_TIME = 3;
    int END_TIME = 30;
    int processorJobCount = 0;
    String nameProcessor;
    int processorRunningTime;
    ArrayList<Processor> l1 = new ArrayList<>();
    ArrayList<Processor> l2 = new ArrayList<>();
    ArrayList<Processor> l3 = new ArrayList<>();
    Random r = new Random();
    int simulationStartingTime = 0;
        for (int i = 0; i < END_TIME; i++){
            System.out.println("Second " + i);
        if(r.nextInt(2) == CHANCE_OF_ARRIVAL){
            nameProcessor = "Job #" + processorJobCount;
            processorRunningTime = r.nextInt(MAX_TIME - MIN_TIME) + MIN_TIME;
            Processor p = new Processor(nameProcessor, processorRunningTime, simulationStartingTime);
            l1.add(p);
            processorJobCount++;
            p.timeCame = simulationStartingTime;
            System.out.println(nameProcessor + " arrives, requiring " + processorRunningTime + " seconds to complete.");
        }
            Processor p1;
            if(l2.isEmpty() && !l1.isEmpty()){
                l2.add(l1.remove(0)); 
                p1 = (Processor) l2.get(0);
                p1.startingTime = simulationStartingTime;
            }

            Processor p2;
            if(!l2.isEmpty()){
            p2 =  l2.get(0);
            if (simulationStartingTime == p2.startingTime + p2.runningTime){
                p2.timeCompleted = simulationStartingTime;
                l3.add(l2.remove(0));
                
            }
            System.out.println(p2.name + " is running on the CPU, with " + ((p2.startingTime + p2.runningTime) - simulationStartingTime) + " seconds left.");
        }
            if(!l1.isEmpty()){
              for (int k = 0; k < l1.size(); k++){
                System.out.print(l1.get(k).name + ", ");
            }
            System.out.print("are waiting.");
            System.out.println();
        }

            Thread.sleep(1000);
            simulationStartingTime++;
           
            
        }
    Processor p3;
    for (int i = 0; i < l3.size(); i++){
        p3 = l3.get(i);
        System.out.println(p3.name + " arrived at time " + p3.timeCame + " and finished at time " + p3.timeCompleted);
        System.out.println("It's turnaround time was " + (p3.timeCompleted - p3.timeCame) + " and response time was " + (p3.startingTime - p3.timeCame));
    }
}
}
