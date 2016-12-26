package de.pymob.games.jchess.engine.rules;

import de.pymob.games.jchess.engine.moves.Move;

import java.util.Collection;

public class RuleSet {
    private final RuleType ruleType;
    private final RuleCondition ruleCondition;
    private final Collection<Move> moves;

    public RuleSet(final RuleType ruleType, final RuleCondition ruleCondition,
                   final Collection<Move> moves) {
        this.ruleType = ruleType;
        this.ruleCondition = ruleCondition;
        this.moves = moves;
    }

    public RuleType getRuleType() {
        return ruleType;
    }

    public RuleCondition getRuleCondition() {
        return ruleCondition;
    }

    public boolean containsMove(Move move) {
        for (Move m : moves) {
            if (m.getMoveDirection().equals(move.getMoveDirection()) &&
                    m.getMoveDistance().equals(move.getMoveDistance())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "RuleSet{" +
                "ruleType=" + ruleType +
                ", ruleCondition=" + ruleCondition +
                ", moves=" + moves +
                '}';
    }
}
