import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RecognizerTest {
    @Test
    public void RecognizedByBoth() {
        ArrayList<String> sequences = new ArrayList<>();
        //recognized by automate and regular expression
        sequences.add("b");
        sequences.add("aac");
        sequences.add("aabac");
        sequences.add("aabaccb");
        for (String sequence : sequences) {
            Recognizer recognizer = new Recognizer();
            int got_state = recognizer.nextState(sequence.length(), 0, sequence, 1);
            Assert.assertEquals("Exception occurred: " + sequence + " got state: " + got_state, 1, got_state);
        }
    }

    @Test
    public void RecognizedByOnlyAutomate() {
        ArrayList<String> sequences = new ArrayList<>();
        //recognized by automate and NOT regular expression
        sequences.add("aabaccbcb");
        sequences.add("aaccb");
        for (String sequence : sequences) {
            Recognizer recognizer = new Recognizer();
            int got_state = recognizer.nextState(sequence.length(), 0, sequence, 1);
            Assert.assertEquals("Exception occurred: " + sequence + " got state: " + got_state, 0, got_state);
        }
    }

    @Test
    public void NotRecognizedByBoth() {
        ArrayList<String> sequences = new ArrayList<>();
        //NOT recognized by automate and regular expression
        sequences.add("bbb");
        sequences.add("cca");
        for (String sequence : sequences) {
            Recognizer recognizer = new Recognizer();
            int got_state = recognizer.nextState(sequence.length(), 0, sequence, 1);
            Assert.assertEquals("Exception occurred: " + sequence + " got state: " + got_state, 0, got_state);
        }
    }

    @Test
    public void RecognizerTestRecognizedNotAlphChar() {
        ArrayList<String> sequences = new ArrayList<>();
        //NOT recognized symbols
        sequences.add("223");
        sequences.add("aa2ccb");
        sequences.add("daaccb");
        sequences.add("aaccb1");
        for (String sequence : sequences) {
            Recognizer recognizer = new Recognizer();
            int got_state = recognizer.nextState(sequence.length(), 0, sequence, 1);
            Assert.assertEquals("Exception occurred: " + sequence + " got state: " + got_state, -1, got_state);
        }
    }
}
