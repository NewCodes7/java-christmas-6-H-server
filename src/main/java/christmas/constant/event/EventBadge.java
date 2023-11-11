package christmas.constant.event;

public enum EventBadge {
    NON("없음", 0),
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final String badge;
    private final int minTotalDiscount;

    EventBadge(String badge, int minTotalDiscount) {
        this.badge = badge;
        this.minTotalDiscount = minTotalDiscount;
    }

    public String getBadge() {
        return badge;
    }
    public int getMinTotalDiscount() {
        return minTotalDiscount;
    }
}
