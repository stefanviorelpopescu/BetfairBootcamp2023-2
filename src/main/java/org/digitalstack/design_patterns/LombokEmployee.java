package org.digitalstack.design_patterns;

import lombok.Builder;
import lombok.NonNull;

@Builder(setterPrefix = "with")
public class LombokEmployee {

    @NonNull
    private final String name;
    @NonNull
    private final int age;
    private final boolean hasDrivingLicence;
    private final Long driversLicenceExpirationDate;
    private final boolean isMarried;
    private final boolean hasChildren;

}
