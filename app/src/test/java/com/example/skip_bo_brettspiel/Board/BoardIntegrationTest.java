package com.example.skip_bo_brettspiel.Board;

import com.example.skip_bo_brettspiel.Board.Field.BlueField;
import com.example.skip_bo_brettspiel.Board.Field.NumberedField;
import com.example.skip_bo_brettspiel.Board.Field.OrangeField;
import com.example.skip_bo_brettspiel.Board.Field.PinkField;
import com.example.skip_bo_brettspiel.Board.Field.PurpleField;
import com.example.skip_bo_brettspiel.Board.Field.RedField;
import com.example.skip_bo_brettspiel.Board.Field.SkipBoField;
import com.example.skip_bo_brettspiel.Board.Field.SwitchCardField;

import org.junit.jupiter.api.Test;

class BoardIntegrationTest {

    Board b = new Board(24);

    void init() {
        b.addField(new BlueField("First Blue Field", 1));
        b.addField(new BlueField("Second Blue Field", 2));
        b.addField(new NumberedField("8-5 Field", 3, 5, 8));
        b.addField(new PinkField("First Pink Field", 4));
        b.addField(new NumberedField("9-12 Field", 5, 9, 12));
        b.addField(new OrangeField("First Orange Field", 6));
        b.addField(new OrangeField("Second Orange Field", 7));
        b.addField(new OrangeField("Third Orange Field", 8));
        b.addField(new SkipBoField("First SkipBo Field", 9));
        b.addField(new SwitchCardField("First Switch Card Field", 10));
        b.addField(new NumberedField("1-4 Field", 11, 1, 4));
        b.addField(new PurpleField("First Purple Field", 12));
        b.addField(new PurpleField("Second Purple Field", 13));
        b.addField(new PurpleField("Third Purple Field", 14));
        b.addField(new NumberedField("8-5 Field", 15, 5, 8));
        b.addField(new PinkField("Second Pink Field", 16));
        b.addField(new NumberedField("9-12 Field", 17, 9, 12));
        b.addField(new RedField("First Red Field", 18));
        b.addField(new RedField("Second Red Field", 19));
        b.addField(new RedField("Third Red Field", 20));
        b.addField(new SkipBoField("Second SkipBo Field", 21));
        b.addField(new SwitchCardField("Second Switch Card Field", 22));
        b.addField(new NumberedField("1-4 Field", 23, 1, 4));
        b.addField(new BlueField("Third Blue Field", 24));
    }

    // FIXME this test is not testing anything
    @Test
    void printBoard() {
        init();
        for (int i = 0; i < 24; i++) {
            System.out.println(b.getField(i).description());
        }

    }
}



