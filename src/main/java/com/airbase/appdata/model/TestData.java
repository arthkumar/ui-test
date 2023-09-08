package com.airbase.appdata.model;

import com.airbase.appdata.constants.SortFilter;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TestData {
    private String expectedPageTitle;
    private String productType;
    private String brandFilter;
    private SortFilter sortFilter;
    private String fromPrice;
    private String toPrice;
    private String expectedItemCount;
}
