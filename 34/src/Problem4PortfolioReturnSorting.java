import java.util.*;

class Asset {
    String name;
    double returnRate;
    double volatility;

    Asset(String name, double returnRate, double volatility) {
        this.name = name;
        this.returnRate = returnRate;
        this.volatility = volatility;
    }

    public String toString() {
        return name + ":" + returnRate + "%";
    }
}

public class Problem4PortfolioReturnSorting {

    public static void main(String[] args) {

        ArrayList<Asset> assets = new ArrayList<>();

        // Sample Input
        assets.add(new Asset("AAPL", 12, 5));
        assets.add(new Asset("TSLA", 8, 7));
        assets.add(new Asset("GOOG", 15, 4));

        ArrayList<Asset> mergeList = new ArrayList<>(assets);
        ArrayList<Asset> quickList = new ArrayList<>(assets);

        mergeSort(mergeList, 0, mergeList.size() - 1);
        System.out.println("Merge Sort (asc): " + mergeList);

        quickSort(quickList, 0, quickList.size() - 1);
        System.out.println("Quick Sort (desc): " + quickList);
    }

    // 🔹 Merge Sort (ascending by returnRate)
    static void mergeSort(ArrayList<Asset> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);

            merge(list, left, mid, right);
        }
    }

    static void merge(ArrayList<Asset> list, int left, int mid, int right) {
        ArrayList<Asset> temp = new ArrayList<>();

        int i = left, j = mid + 1;

        while (i <= mid && j <= right) {
            if (list.get(i).returnRate <= list.get(j).returnRate) {
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

    // 🔹 Quick Sort (desc returnRate, asc volatility)
    static void quickSort(ArrayList<Asset> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);

            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    static int partition(ArrayList<Asset> list, int low, int high) {
        Asset pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j).returnRate > pivot.returnRate ||
                    (list.get(j).returnRate == pivot.returnRate &&
                            list.get(j).volatility < pivot.volatility)) {

                i++;
                Asset temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        Asset temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1;
    }
}