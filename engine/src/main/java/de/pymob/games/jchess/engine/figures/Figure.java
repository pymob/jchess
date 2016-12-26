package de.pymob.games.jchess.engine.figures;

import de.pymob.games.jchess.engine.rules.Rule;

public abstract class Figure {
    protected abstract Rule onStart();
    protected abstract Rule inGame();
    protected abstract Rule onCapture();
}
