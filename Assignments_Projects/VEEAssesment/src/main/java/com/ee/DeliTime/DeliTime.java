package com.ee.DeliTime;

import java.util. * ;

/**
 * Calculate the Delivery time
 */
public class DeliTime {
    private final List < List < Integer >> container = new ArrayList < >();

    private void solve(
            List < Integer > arr, List < Integer > temp, int start, int k, int sum, boolean[] visited
    ) {
        if (temp.size() == k && sum >= 0) {
            container.add(new ArrayList < >(temp));
            return;
        }
        for (int i = start; i < arr.size(); i++) {
            if (!visited[i]) {
                temp.add(i);
                solve(arr, temp, i + 1, k, sum - arr.get(i), visited);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private int findMaxIndex(List < Integer > arr) {
        int index = 0,
                curr_sum = 0,
                max_sum = 0,
                i = 0;
        for (List < Integer > curr: container) {
            for (Integer one: curr) {
                curr_sum += arr.get(one);
            }
            if (max_sum < curr_sum) {
                max_sum = curr_sum;
                index = i;
            }
            curr_sum = 0;
            i++;
        }
        return index;
    }

    private int findMaxWeightIndex(List < Integer > weights, boolean[] visited, List< Integer > distance) {
        int index = -1;
        int min = -999;
        for (int i = 0; i < weights.size(); i++) {
            if (!visited[i] && min < weights.get(i)) {
                index = i;
                min = weights.get(i);
            }
            if (!visited[i] && min == weights.get(i) && distance.get(index) > distance.get(i) ) {
                index = i;
                min = weights.get(i);
            }
        }
        return index;
    }

    private int findCarAvailabilityIndex(double[] arr) {
        int index = -1;
        double time = 99999999.0;
        for (int i = 0; i < arr.length; i++) {
            if (time > arr[i]) {
                index = i;
                time = arr[i];
            }
        }
        return index;
    }

    /**
     * Calculate the time of all list of packages
     * @param weights Weights List.
     * @param distances Distances List.
     * @param noOfPackages Number of package applied.
     * @param speed Maximum speed a diver can reach.
     * @param weightOfPackages Maximum weight allowed
     * @return double array of time
     */
    public double[] find(
            List < Integer > weights, List < Integer > distances, int noOfPackages, int speed, int weightOfPackages
    ) {
        List < Integer > temp = new ArrayList < >();
        int length = weights.size();
        boolean[] visited = new boolean[length];
        double[] result = new double[length];
        double[] cars = new double[noOfPackages];
        while (true) {
            solve(weights, temp, 0, noOfPackages, weightOfPackages, visited);
            if (container.size() > 0) {
                int carIndex = findCarAvailabilityIndex(cars);
                double curr = cars[carIndex];
                List < Integer > indices = new ArrayList < >(container.get(findMaxIndex(weights)));
                double ct = 0;
                for (Integer index: indices) {
                    double time = (double)(distances.get(index)) / speed;
                    result[index] = curr + time;
                    ct = Math.max(ct, time);
                    visited[index] = true;
                }
                cars[carIndex] += 2 * ct;
                container.clear();
            } else break;
        }
        while (true) {
            int index = findMaxWeightIndex(weights, visited, distances);
            int carIndex = findCarAvailabilityIndex(cars);
            double curr = cars[carIndex];
            if (index != -1) {
                double time = (double)(distances.get(index)) / speed;
                result[index] = curr + time;
                cars[carIndex] += 2 * time;
                visited[index] = true;
            } else {
                break;
            }
        }
        return result;
    }
}