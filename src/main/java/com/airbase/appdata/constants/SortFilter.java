package com.airbase.appdata.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SortFilter {
    HIGH_TO_LOW("Price: High to Low");
    private final String sortBy;
}
