import java.util.*;

public class MoodEnergyTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> logs = new ArrayList<>();

        System.out.println("Smart Mood + Energy Tracker");

        while (true) {

            System.out.println("\n------ MENU ------");
            System.out.println("1. Add Entry");
            System.out.println("2. Show Entries");
            System.out.println("3. Analyze Day");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            String input = sc.nextLine();

            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Enter valid number");
                continue;
            }

            // 1. ADD ENTRY
            if (choice == 1) {

                System.out.print("Enter Mood (Happy/Sad/Neutral): ");
                String mood = sc.nextLine().toLowerCase();

                System.out.print("Enter Energy Level (1-10): ");
                int energy = Integer.parseInt(sc.nextLine());

                System.out.print("Enter Note: ");
                String note = sc.nextLine();

                logs.add(mood + "|" + energy + "|" + note);

                System.out.println("Entry Saved!");
            }

            // 2. SHOW ENTRIES
            else if (choice == 2) {

                System.out.println("\n All Entries:");

                if (logs.isEmpty()) {
                    System.out.println("No data yet");
                } else {
                    int i = 1;
                    for (String log : logs) {
                        System.out.println(i + ". " + log);
                        i++;
                    }
                }
            }

            // 3. ANALYZE DAY (BRAIN PART)
            else if (choice == 3) {

                int highEnergy = 0;
                int lowEnergy = 0;
                int total = logs.size();

                for (String log : logs) {

                    String[] parts = log.split("\\|");

                    int energy = Integer.parseInt(parts[1]);

                    if (energy >= 7) {
                        highEnergy++;
                    } else {
                        lowEnergy++;
                    }
                }

                System.out.println("\n DAY ANALYSIS:");

                System.out.println("Total Entries: " + total);

                if (total == 0) {
                    System.out.println("No data to analyze");
                } 
                else if (highEnergy > lowEnergy) {

                    System.out.println("You had a PRODUCTIVE DAY");
                    System.out.println("Suggestion: Keep this energy going!");
                } 
                else {

                    System.out.println("You had a LOW ENERGY DAY");
                    System.out.println("Suggestion: Take rest and recharge.");
                }
            }

            // 4. EXIT
            else if (choice == 4) {
                System.out.println("Bye! Stay consistent");
                break;
            }

            else {
                System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}