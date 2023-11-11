package christmas.constant;

public enum EventBadge {
    NON("없음"),
    STAR("별"),
    TREE("트리"),
    SANTA("산타");

    private final String badge;

    EventBadge(String badge) {
        this.badge = badge;
    }
}
