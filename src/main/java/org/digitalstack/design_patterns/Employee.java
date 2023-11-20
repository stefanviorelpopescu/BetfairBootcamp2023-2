package org.digitalstack.design_patterns;

public class Employee {

    private final String name;
    private final int age;
    private final boolean hasDrivingLicence;
    private final Long driversLicenceExpirationDate;
    private final boolean isMarried;
    private final boolean hasChildren;

    private Employee(String name, int age, boolean hasDrivingLicence, Long driversLicenceExpirationDate, boolean isMarried, boolean hasChildren) {
        this.name = name;
        this.age = age;
        this.hasDrivingLicence = hasDrivingLicence;
        this.driversLicenceExpirationDate = driversLicenceExpirationDate;
        this.isMarried = isMarried;
        this.hasChildren = hasChildren;
    }

    public static class EmployeeBuilder {
        private String name;
        private int age;
        private boolean hasDrivingLicence;
        private Long driversLicenceExpirationDate;
        private boolean isMarried;
        private boolean hasChildren;

        public EmployeeBuilder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public EmployeeBuilder withDrivingLicense(boolean hasDrivingLicence) {
            this.hasDrivingLicence = hasDrivingLicence;
            return this;
        }

        public EmployeeBuilder withDriversLicenseExpirationDate(Long driversLicenceExpirationDate) {
            this.driversLicenceExpirationDate = driversLicenceExpirationDate;
            return this;
        }

        public EmployeeBuilder withIsMarried(boolean isMarried) {
            this.isMarried = isMarried;
            return this;
        }

        public EmployeeBuilder withHasChildren(boolean hasChildren) {
            this.hasChildren = hasChildren;
            return this;
        }

        public Employee build() {
            return new Employee(name, age, hasDrivingLicence, driversLicenceExpirationDate, isMarried, hasChildren);
        }

    }

}
