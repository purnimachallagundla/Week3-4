import java.util.*;

class Trade {
    String id;
    int volume;

    Trade(String id, int volume) {
        this.id = id;
        this.volume = volume;
    }

    public String toString() {
        return id + ":" + volume;
    }
}

public class Problem3HistoricalTradeVolumeAnalysis {

    public static void main(String[] args) {

        ArrayList<Trade> trades = new ArrayList<>();

        // Sample Input
        trades.add(new Trade("trade3", 500));
        trades.add(new Trade("trade1", 100));
        trades.add(new Trade("trade2", 300));

        ArrayList<Trade> mergeList = new ArrayList<>(trades);
        ArrayList<Trade> quickList = new ArrayList<>(trades);

        mergeSort(mergeList, 0, mergeList.size() - 1);
        System.out.println("Merge Sort (asc): " + mergeList);

        quickSort(quickList, 0, quickList.size() - 1);
        System.out.println("Quick Sort (desc): " + quickList);

        // Merge two sorted lists (example: same list twice)
        ArrayList<Trade> merged = mergeTwoLists(mergeList, mergeList);
        System.out.println("Merged List: " + merged);

        // Total volume
        int total = totalVolume(merged);
        System.out.println("Total Volume: " + total);
    }

    // 🔹 Merge Sort (ascending)
    static void mergeSort(ArrayList<Trade> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);

            merge(list, left, mid, right);
        }
    }

    static void merge(ArrayList<Trade> list, int left, int mid, int right) {
        ArrayList<Trade> temp = new ArrayList<>();

        int i = left, j = mid + 1;

        while (i <= mid && j <= right) {
            if (list.get(i).volume <= list.get(j).volume) {
                temp.add(list.get(i++));
            } else {
                temp.add(list.get(j++));
            }
        }

        while (i <= mid) temp.add(list.get(i++));
        while (j <= right) temp.add(list.get(j++));

        for (int k = 0; k < temp.size(); k++) {
            list.set(left + k, temp.get(k));
        }
    }

    // 🔹 Quick Sort (descending)
    static void quickSort(ArrayList<Trade> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);

            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    static int partition(ArrayList<Trade> list, int low, int high) {
        int pivot = list.get(high).volume;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j).volume > pivot) { // DESCENDING
                i++;
                Trade temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        Trade temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1;
    }

    // 🔹 Merge two sorted lists
    static ArrayList<Trade> mergeTwoLists(ArrayList<Trade> a, ArrayList<Trade> b) {
        ArrayList<Trade> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i).volume <= b.get(j).volume) {
                result.add(a.get(i++));
            } else {
                result.add(b.get(j++));
            }
        }

        while (i < a.size()) result.add(a.get(i++));
        while (j < b.size()) result.add(b.get(j++));

        return result;
    }

    // 🔹 Total volume
    static int totalVolume(ArrayList<Trade> list) {
        int sum = 0;
        for (Trade t : list) {
            sum += t.volume;
        }
        return sum;
    }
}
