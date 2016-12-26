package de.pymob.games.jchess.engine.figures;

import de.pymob.games.jchess.engine.Position;
import de.pymob.games.jchess.engine.moves.Move;
import de.pymob.games.jchess.engine.rules.Rule;
import de.pymob.games.jchess.engine.rules.RuleCondition;
import de.pymob.games.jchess.engine.rules.RuleSet;
import de.pymob.games.jchess.engine.rules.RuleType;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class Pawn {
    private final Collection<RuleSet> rules;

    public Pawn() {
        rules = new HashSet<>();
        rules.add(new RuleSet(RuleType.ON_START, RuleCondition.IF_EMPTY,
                Arrays.asList(new Move(Position.A1, Position.A2),
                        new Move(Position.A1, Position.A3))));
        rules.add(new RuleSet(RuleType.IN_GAME, RuleCondition.IF_EMPTY,
                Collections.singletonList(new Move(Position.A1, Position.A2))));
        rules.add(new RuleSet(RuleType.ON_CAPTURE, RuleCondition.IF_OCCUPIED,
                Arrays.asList(new Move(Position.B1, Position.A2),
                        new Move(Position.A1, Position.B2))));
    }

    public boolean applyRule(Rule rule) {
        return rules.stream().anyMatch(r ->
                r.getRuleType().equals(rule.getRuleType()) &&
                r.getRuleCondition().equals(rule.getRuleCondition()) &&
                r.containsMove(rule.getMove())
        );
    }

}
