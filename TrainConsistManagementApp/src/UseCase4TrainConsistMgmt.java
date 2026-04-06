import java.util.LinkedList;
import java.util.List;

public class UseCase4TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("===========================================");
        System.out.println("   UC4 - Maintain Ordered Bogie Consist   ");
        System.out.println("===========================================\n");

        // Create LinkedList for ordered train consist
        List<String> trainConsist = new LinkedList<>();

        // 🔹 Add bogies in sequence
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist);

        // 🔹 Insert Pantry Car at position 2
        trainConsist.add(2, "Pantry");

        System.out.println("\nAfter Adding Pantry at position 2:");
        System.out.println(trainConsist);

        // 🔹 Remove first and last bogie
        ((LinkedList<String>) trainConsist).removeFirst();
        ((LinkedList<String>) trainConsist).removeLast();

        System.out.println("\nAfter Removing First and Last Bogie:");
        System.out.println(trainConsist);

        System.out.println("\nFinal Ordered Train Consist:");
        System.out.println(trainConsist);

        System.out.println("\nUC4 operations completed successfully...");
    }
}