import java.util.Comparator;
import java.util.Arrays;

public class Activity_Selection_Problem {
    static class Activity{
        int start;
        int finish;

        public Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    public static void main(String[] args) {
        Activity[] activities = {
                new Activity(1, 3),
                new Activity(2, 4),
                new Activity(3, 5),
                new Activity(0, 6),
                new Activity(5, 7),
                new Activity(8, 9)
        };
        Arrays.sort(activities, Comparator.comparingInt(a -> a.finish));

        int count = 1;
        int lastFinish = activities[0].finish;
        for (int i = 1; i < activities.length ; i++) {
            if(activities[i].start >= lastFinish){
                count++;
                lastFinish = activities[i].finish;
            }
        }
        System.out.println(count);
    }
}
