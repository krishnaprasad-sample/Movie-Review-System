package Entity;

public enum Role {
    VIEWER(1), CRITIC(2), EXPERT(3), ADMIN(4);

    private final int weightage;

    Role(int weightage) {
        this.weightage = weightage;
    }

    public int getWeightage() {
        return weightage;
    }

}
