package com.ee;

import com.ee.Cost.Cost;
import com.ee.DeliTime.DeliTime;
import com.ee.offer.Offer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Main class for the application.
 */
public class Courier {

    public static void main(String[] args) {
        Offer offer = new Offer();
        offer.add("OFR001", 10, 0, 200, 70, 200);
        offer.add("OFR002", 7, 50, 150, 100, 250);
        offer.add("OFR003", 5, 50, 250, 10, 150);

        InputStreamReader isr = new InputStreamReader(System. in );
        BufferedReader br = new BufferedReader(isr);

        List < String > pkgIds = new ArrayList < >();
        List < String > offerCodes = new ArrayList < >();
        List < Integer > pkgWeights = new ArrayList < >();
        List < Integer > distanceKms = new ArrayList < >();

        try {
            String line = br.readLine();
            String[] arr = line.split("\\s+");
            int baseDeliveryCost = Integer.parseInt(arr[0]);
            int noOfPackages = Integer.parseInt(arr[1]);

            for (int i = 0; i < noOfPackages; i++) {
                line = br.readLine();
                arr = line.split("\\s+");
                pkgIds.add(arr[0]);
                pkgWeights.add(Integer.parseInt(arr[1]));
                distanceKms.add(Integer.parseInt(arr[2]));
                offerCodes.add(arr[3]);
            }

            line = br.readLine();
            arr = line.split("\\s+");
            int noOfVehicles = Integer.parseInt(arr[0]);
            int maxSpeed = Integer.parseInt(arr[1]);
            int maxCartWeight = Integer.parseInt(arr[2]);

            Cost solution1 = new Cost(baseDeliveryCost, offer);
            Map < String,
                    List < Integer >> ans = solution1.solve(offerCodes, distanceKms, pkgWeights);
            List < Integer > discounts = ans.get("discounts");
            List < Integer > costs = ans.get("costs");

            DeliTime delDist = new DeliTime();
            double[] time = delDist.find(pkgWeights, distanceKms, noOfVehicles, maxSpeed, maxCartWeight);

            for (int i = 0; i < noOfPackages; i++) {
                System.out.println(pkgIds.get(i) + " " + discounts.get(i) + " " + costs.get(i) + " " + Math.floor(time[i] * 100) / 100);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}