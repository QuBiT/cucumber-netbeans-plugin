package info.cukes.feature.threads;

import gherkin.FixJava;
import gherkin.I18nLexer;
import gherkin.Lexer;
import gherkin.formatter.PrettyFormatter;
import gherkin.parser.Parser;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataObject;
import org.openide.util.Exceptions;
import org.openide.windows.IOProvider;
import org.openide.windows.InputOutput;
import org.openide.windows.OutputWriter;

public final class PrettyPrintThread implements Runnable {

    private DataObject dObj = null;
    private File file = null;
    private String fileName = null;
    private CharSequence inputString = null;

    public PrettyPrintThread(DataObject dObj) {
        // set DataObject and file name
        this.dObj = dObj;
        this.file = FileUtil.toFile(this.dObj.getPrimaryFile());
        this.fileName = file.getAbsolutePath();
    }

    public void run() {
        // get an output window tab
        InputOutput io;
        io = IOProvider.getDefault().getIO("Cucumber", false);
        io.select();
        OutputWriter outputWriter;
        outputWriter = io.getOut();
        outputWriter.printf("--- PRETTY FORMATTER : START ---\n\n");
        // READ FILE
        this.inputString = readInputFile();
        // OPEN FILE FOR WRITE
        OutputStream bout = prepareOutputFile();
        // PARSER (and set OUTPUT FILE)
        Parser p = new Parser(new PrettyFormatter(bout, true));
        // LEXER
        Lexer l = new I18nLexer(p);
        l.scan(this.inputString);
        outputWriter.printf("--- PRETTY FORMATTER : END ---\n\n");
    }

    private OutputStream prepareOutputFile() {
        OutputStream fout = null;
        try {
            fout = new FileOutputStream(file);
        } catch (FileNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        }
        OutputStream bout = new BufferedOutputStream(fout);
        //OutputStreamWriter out = new OutputStreamWriter(bout, "8859_1");
        return bout;
    }

    private CharSequence readInputFile() {
        CharSequence input = null;
        try {
            //input = FixJava.readResource(fileName);
            input = FixJava.readReader(new FileReader(file));
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        return input;
    }
}

