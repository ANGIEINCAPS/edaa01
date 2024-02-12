public abstract class Player {
    private String userId;

    protected Player(String userId) {
        this.userId = userId;
        System.out.println("Created user with id: " + userId);
    }

    public String getUserId() {
        return userId;
    }

    public abstract int takePins(Board board);
}
