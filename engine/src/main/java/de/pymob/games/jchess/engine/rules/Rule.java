package de.pymob.games.jchess.engine.rules;

import de.pymob.games.jchess.engine.moves.Move;

public class Rule {
    private RuleType ruleType;
    private RuleCondition ruleCondition;
    private Move move;

    public Rule(RuleType ruleType, RuleCondition ruleCondition, Move move) {
        this.ruleType = ruleType;
        this.ruleCondition = ruleCondition;
        this.move = move;
    }

    public RuleType getRuleType() {
        return ruleType;
    }

    public RuleCondition getRuleCondition() {
        return ruleCondition;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public String toString() {
        return "Rule{" +
                ruleType + "=" +
                move.toString() +
                " (" + ruleCondition + ")" +
                '}';
    }
}
