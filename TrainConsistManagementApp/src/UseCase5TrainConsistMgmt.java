import java.util.LinkedHashSet;
import java.util.Set;

public class UseCase5TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("===========================================");
        System.out.println("   UC5 - Preserve Insertion Order of Bogies   ");
        System.out.println("===========================================\n");

        // Create LinkedHashSet (maintains order + uniqueness)
        Set<String> formation = new LinkedHashSet<>();

        // 🔹 Add bogies
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // 🔹 Add duplicate (will be ignored)
        formation.add("Sleeper");

        // Display final formation
        System.out.println("Final Train Formation:");
        System.out.println(formation);

        System.out.println("\nTotal Bogies: " + formation.size());

        System.out.println("\nUC5 operations completed successfully...");
    }
}