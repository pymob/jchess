package de.pymob.games.jchess.engine.moves;

import de.pymob.games.jchess.engine.Position;

public class Move {
    private final Position from;
    private final Position to;
    private MoveDirection moveDirection;
    private Integer moveDistance;

    public Move(Position from, Position to) {
        this.from = from;
        this.to = to;
        calculateMembers();
    }

    public MoveDirection getMoveDirection() {
        return moveDirection;
    }

    public Integer getMoveDistance() {
        return moveDistance;
    }

    private void calculateMembers() {
        Integer diffFile = to.getFile() - from.getFile(); // column A-H as 1-8
        Integer diffRank = to.getRank() - from.getRank(); // row 1-8
        this.moveDirection = MoveDirection.getByDifference(diffFile, diffRank);
        if (moveDirection.isDiagonal()) {
            this.moveDistance = Math.abs(diffFile);
        } else {
            this.moveDistance = Math.abs(diffFile.equals(0) ? diffRank : diffFile);
        }
    }

}
