package com.airbase.appdata.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Brands {
    BOAT("boat"),
    AMAZFIT("Amazfit"),
    NOISE("Noise");
    private final String brandName;
}
