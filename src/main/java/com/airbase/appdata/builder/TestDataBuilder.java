package com.airbase.appdata.builder;

import com.airbase.appdata.constants.Brands;
import com.airbase.appdata.constants.SortFilter;
import com.airbase.appdata.model.TestData;

public class TestDataBuilder {

    public static final String EXPECTED_PAGE_TITLE = "Amazon.in";
    public static final String PRODUCT_TYPE = "smartwatches";
    public static final String FROM_PRICE = "1000";
    public static final String TO_PRICE = "5000";
    public static final String EXPECTED_ITEM_COUNT = "1";

    private TestDataBuilder() {}

    public static TestData tcID001() {
        return TestData.builder()
                .expectedPageTitle(EXPECTED_PAGE_TITLE)
                .productType(PRODUCT_TYPE)
                .brandFilter(Brands.NOISE.getBrandName())
                .fromPrice(FROM_PRICE)
                .toPrice(TO_PRICE)
                .sortFilter(SortFilter.HIGH_TO_LOW)
                .expectedItemCount(EXPECTED_ITEM_COUNT)
                .build();
    }

    public static TestData tcID002() {
        return TestData.builder()
                .expectedPageTitle(EXPECTED_PAGE_TITLE)
                .productType(PRODUCT_TYPE)
                .brandFilter(Brands.BOAT.getBrandName())
                .fromPrice(FROM_PRICE)
                .toPrice(TO_PRICE)
                .sortFilter(SortFilter.HIGH_TO_LOW)
                .expectedItemCount(EXPECTED_ITEM_COUNT)
                .build();
    }

    public static TestData tcID003() {
        return TestData.builder()
                .expectedPageTitle(EXPECTED_PAGE_TITLE)
                .productType(PRODUCT_TYPE)
                .brandFilter(Brands.AMAZFIT.getBrandName())
                .fromPrice(FROM_PRICE)
                .toPrice(TO_PRICE)
                .sortFilter(SortFilter.HIGH_TO_LOW)
                .expectedItemCount(EXPECTED_ITEM_COUNT)
                .build();
    }
}
