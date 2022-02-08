package com.ee.Cost;

import com.ee.offer.Offer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CostTest {
    @Test
    void testSolve(){
        Offer offer = new Offer();
        offer.add("OFR003", 5, 50, 250, 10, 150);

        List<String > offerCodes = new ArrayList<>();
        offerCodes.add("OFR003");

        List<Integer> pkgWeights = new ArrayList<>();
        pkgWeights.add(10);

        List<Integer> distanceKms = new ArrayList<>();
        distanceKms.add(100);

        Cost cost = new Cost(100, offer);
        Map<String, List<Integer>> result = cost.solve(offerCodes, distanceKms, pkgWeights);
        assertEquals(result.get("discounts").size(), 1);
        assertEquals(result.get("discounts").get(0), 35);

        assertEquals(result.get("costs").size(), 1);
        assertEquals(result.get("costs").get(0), 665);
    }
}
