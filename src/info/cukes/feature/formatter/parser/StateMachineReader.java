package info.cukes.feature.formatter.parser;

import info.cukes.feature.formatter.FixJava;
import info.cukes.feature.formatter.Lexer;
import info.cukes.feature.formatter.Listener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateMachineReader implements Listener {
    private final String machinePath;
    private List<List<String>> transitionTable;

    public StateMachineReader(String name) {
        // TODO -> where should I store those files and how are they generated?
        machinePath = "/formatter/parser/" + name + ".txt";
    }

    public List<List<String>> transitionTable() {
transitionTable = new ArrayList<List<String>>();
        // TODO -> GENERATE LEXER for all Languages.
        Lexer lexer = new En(this);
        try {
            lexer.scan(FixJava.readResource(machinePath));
        } catch (IOException e) {
            throw new RuntimeException("Fatal error. Couldn't read " + machinePath);
        }
        return transitionTable;
    }

    public void tag(String name, int line) {
    }

    public void comment(String content, int line) {
    }

    public void feature(String keyword, String name, int line) {
    }

    public void background(String keyword, String name, int line) {
    }

    public void scenario(String keyword, String name, int line) {
    }

    public void scenario_outline(String keyword, String name, int line) {
    }

    public void examples(String keyword, String name, int line) {
    }

    public void step(String keyword, String name, int line) {
    }

    public void py_string(String string, int line) {
    }

    public void eof() {
    }

    public void syntax_error(String name, String event, List<String> strings, int line) {
    }

    public void row(List<String> row, int line) {
        transitionTable.add(row);
    }
}