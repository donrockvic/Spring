package com.ee.Cost;

import com.ee.offer.Offer;

import java.util.*;

/**
 * Calculate the final cost
 */
public class Cost {
    private final int baseDeliveryCost;
    private final Offer offer;

    public Cost(int baseDeliveryCost, Offer offer) {
        this.baseDeliveryCost = baseDeliveryCost;
        this.offer = offer;
    }

    private int[] calc(String offerCode, int weight, int distance){
        int currentDiscount = offer.getDiscount(offerCode, distance, weight);
        int currentPrice = baseDeliveryCost + (weight*10) + (distance*5) ;
        currentDiscount =  (int) ( currentPrice*(currentDiscount*0.01) );
        return new int[]{currentDiscount, (currentPrice - currentDiscount)};
    }

    /**
     * Create the final cost for all the packages
     * @param offerCodes  List of offer codes.
     * @param distanceKms List of package distance.
     * @param pkgWeights List of package weights.
     * @return a Map for Lists with discounts and costs
     */
    public Map<String, List<Integer>> solve(
            List<String> offerCodes,
            List<Integer> distanceKms,
            List<Integer> pkgWeights
    ){
        Map<String, List<Integer>> ans = new HashMap<>();
        int len = offerCodes.size();
        ans.put("discounts", new ArrayList<>());
        ans.put("costs", new ArrayList<>());
        for(int i=0; i<len; i++){
            int[] curr = calc(offerCodes.get(i), pkgWeights.get(i), distanceKms.get(i));
            ans.get("discounts").add(curr[0]);
            ans.get("costs").add(curr[1]);
        }
        return ans;
    }
}
