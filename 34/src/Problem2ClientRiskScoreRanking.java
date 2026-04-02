import java.util.*;

class Client {
    String name;
    int riskScore;
    double balance;

    Client(String name, int riskScore, double balance) {
        this.name = name;
        this.riskScore = riskScore;
        this.balance = balance;
    }

    public String toString() {
        return name + ":" + riskScore;
    }
}

public class Problem2ClientRiskScoreRanking {

    public static void main(String[] args) {

        ArrayList<Client> clients = new ArrayList<>();

        // Sample Input
        clients.add(new Client("clientC", 80, 5000));
        clients.add(new Client("clientA", 20, 10000));
        clients.add(new Client("clientB", 50, 7000));

        ArrayList<Client> bubbleList = new ArrayList<>(clients);
        ArrayList<Client> insertionList = new ArrayList<>(clients);

        bubbleSort(bubbleList);
        insertionSort(insertionList);
        topRisks(insertionList);
    }

    // 🔹 Bubble Sort (ascending)
    static void bubbleSort(ArrayList<Client> list) {
        int swaps = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).riskScore > list.get(j + 1).riskScore) {
                    Client temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swaps++;
                }
            }
        }

        System.out.println("Bubble Sort (asc): " + list);
        System.out.println("Swaps: " + swaps);
    }

    // 🔹 Insertion Sort (descending)
    static void insertionSort(ArrayList<Client> list) {
        for (int i = 1; i < list.size(); i++) {
            Client key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).riskScore < key.riskScore) {
                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, key);
        }

        System.out.println("Insertion Sort (desc): " + list);
    }

    // 🔹 Top 3 highest risk
    static void topRisks(ArrayList<Client> list) {
        System.out.print("Top risks: ");

        for (int i = 0; i < Math.min(3, list.size()); i++) {
            Client c = list.get(i);
            System.out.print(c.name + "(" + c.riskScore + ") ");
        }

        System.out.println();
    }
}
