package hookah.models.enums;

public enum Filler {
    WATER("Вода"),
    VINE("Вино"),
    MILK("Молоко"),
    RUM("Ром");

    private final String DISPLAY_NAME;

    private Filler(String displayName) {
        this.DISPLAY_NAME = displayName;
    }

    public String getDisplayName() {
        return DISPLAY_NAME;
    }
}
