import java.util.HashMap;
import java.util.Map;

public class UseCase6TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("===========================================");
        System.out.println("   UC6 - Map Bogie to Capacity (HashMap)   ");
        System.out.println("===========================================\n");

        // Create HashMap (Key = Bogie, Value = Capacity)
        Map<String, Integer> capacityMap = new HashMap<>();

        // 🔹 Insert bogie capacities
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 60);
        capacityMap.put("First Class", 40);

        // Display all bogies with capacities
        System.out.println("Bogie Capacity Details:\n");

        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() +
                               " | Capacity: " + entry.getValue());
        }

        System.out.println("\nTotal Bogie Types: " + capacityMap.size());

        System.out.println("\nUC6 operations completed successfully...");
    }
}