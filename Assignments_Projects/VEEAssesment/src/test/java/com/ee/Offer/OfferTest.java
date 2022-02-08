package com.ee.Offer;

import com.ee.offer.Offer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class OfferTest {
    @Test
    void testGetDiscount(){
        Offer offer = new Offer();
        offer.add("OFR003", 5, 50, 250, 10, 150);
        int res = offer.getDiscount("OFR003",100, 10);
        assertEquals(res, 5);
    }
}
