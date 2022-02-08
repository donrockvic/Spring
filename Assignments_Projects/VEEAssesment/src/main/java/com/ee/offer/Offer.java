package com.ee.offer;

import java.util. * ;

/**
 * Offer class
 */
public class Offer {
    private int index = -1;
    private final Map < String, Integer > offers = new HashMap < >();

    private final List < Integer > discounts = new ArrayList < >();
    private final List < Integer > minDist = new ArrayList < >();
    private final List < Integer > maxDist = new ArrayList < >();
    private final List < Integer > minWeights = new ArrayList < >();
    private final List < Integer > maxWeights = new ArrayList < >();


    /**
     *
     * Add an offer to the current list of the offers
     *
     * @param name Name of the offer.
     * @param discount given applicable discount.
     * @param minDis Minimum distance for the offer.
     * @param maxDis Maximum distance for the offer.
     * @param minWeight Minimum weight for this offer.
     * @param maxWeight Maximum weight for this offer.
     */
    public void add(
            String name, int discount, int minDis, int maxDis, int minWeight, int maxWeight
    ) {
        index++;
        offers.put(name, index);
        discounts.add(discount);
        minDist.add(minDis);
        maxDist.add(maxDis);
        minWeights.add(minWeight);
        maxWeights.add(maxWeight);
    }

    /**
     *
     * Calculate discount for given distance, wight and offerCode
     *
     * @param offerCode Current package offer code
     * @param distance Distance of the package
     * @param weight weight of the package
     * @return calculated discount.
     */
    public int getDiscount(String offerCode, int distance, int weight) {
        if (offers.containsKey(offerCode)) {
            int curr = offers.get(offerCode);
            if (minDist.get(curr) > distance || maxDist.get(curr) < distance) return 0;
            else if (minWeights.get(curr) > weight || maxWeights.get(curr) < weight) {
                return 0;
            } else {
                return discounts.get(curr);
            }
        }
        return 0;
    }
}