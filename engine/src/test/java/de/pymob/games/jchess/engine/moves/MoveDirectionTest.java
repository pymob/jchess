package de.pymob.games.jchess.engine.moves;

import org.junit.Assert;
import org.junit.Test;

import static de.pymob.games.jchess.engine.moves.MoveDirection.*;
import static org.junit.Assert.*;

/*
    N : f=0 & r=+
    NE: f=+ & r=+
    E : f=+ & r=0
    SE: f=+ & r=-
    S : f=0 & r=-
    SW: f=- & r=-
    W : f=- & r=0
    NW: f=- & r= +
*/
public class MoveDirectionTest {

    @Test
    public void getByDifference() throws Exception {
        Assert.assertEquals(N, get(0, 1));
        Assert.assertEquals(NE, get(1, 1));
        Assert.assertEquals(E, get(1, 0));
        Assert.assertEquals(SE, get(1, -1));
        Assert.assertEquals(S, get(0, -1));
        Assert.assertEquals(SW, get(-1, -1));
        Assert.assertEquals(W, get(-1, 0));
        Assert.assertEquals(NW, get(-1, 1));
    }

    private MoveDirection get(Integer diffFile, Integer diffRank) {
        return MoveDirection.getByDifference(diffFile, diffRank);
    }

}