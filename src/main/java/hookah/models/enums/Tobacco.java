package hookah.models.enums;

public enum Tobacco {
    ADALYA("Adalya"),
    FUMARI("Fumari"),
    DARKSIDE("Dark side");

    private final String DISPLAY_NAME;

    private Tobacco(String displayName) {
        this.DISPLAY_NAME = displayName;
    }

    public String getDisplayName() {
        return DISPLAY_NAME;
    }
}
