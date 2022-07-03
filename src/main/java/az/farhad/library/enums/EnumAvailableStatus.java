package az.farhad.library.enums;

public enum EnumAvailableStatus {
    ACTIVE(1) , DEACTIVE(0);


    private int value;

    private EnumAvailableStatus(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
