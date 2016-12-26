package de.pymob.games.jchess.engine.moves;

public enum MoveDirection {
    N(0, 1, false), NE(1, 1, true), E(1, 0, false), SE(1, -1, true),
    S(0, -1, false), SW(-1, -1, true), W(-1, 0, false), NW(-1, 1, true);

    private final Integer signFile;
    private final Integer signRank;
    private final boolean diagonal;

    MoveDirection(Integer signFile, Integer signRank, boolean diagonal) {
        this.signFile = signFile;
        this.signRank = signRank;
        this.diagonal = diagonal;
    }

    public Integer getSignFile() {
        return signFile;
    }

    public Integer getSignRank() {
        return signRank;
    }

    public boolean isDiagonal() {
        return diagonal;
    }

    public static MoveDirection getByDifference(Integer diffFile, Integer diffRank) {
        for (MoveDirection moveDirection : MoveDirection.values()) {
            if (isMultipleOf(diffFile, moveDirection.getSignFile()) &&
                    isMultipleOf(diffRank, moveDirection.getSignRank())) {
                return moveDirection;
            }
        }
        throw new IllegalStateException(String.format(
                "No such move direction for %d and %d.",
                diffFile, diffRank));
    }

    /**
     * Checks if the {@code value} is a multiple of the other value.
     * @param value the number to check
     * @param of parameter to check with - has to be 1, 0 or -1
     * @return true, if {@code value} is a multiple of {@code of}.
     */
    private static boolean isMultipleOf(Integer value, Integer of) {
         return Math.signum(value) == of.doubleValue();
    }
}
