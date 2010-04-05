package info.cukes.feature.threads;

import info.cukes.feature.formatter.FixJava;
import info.cukes.feature.formatter.I18nLexer;
import info.cukes.feature.formatter.Lexer;
import info.cukes.feature.formatter.PrettyFormatter;
import info.cukes.feature.formatter.parser.Parser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataObject;
import org.openide.util.Exceptions;
import org.openide.windows.IOProvider;
import org.openide.windows.InputOutput;
import org.openide.windows.OutputWriter;

public class PrettyPrintThread implements Runnable {

    private DataObject dObj = null;
    private String fileName = "";

    public PrettyPrintThread(DataObject dObj) {
        // set DataObject and file name
        this.dObj = dObj;
        File file = FileUtil.toFile(this.dObj.getPrimaryFile());
        fileName = file.getAbsolutePath();
    }

    public void run() {

        // get an output window tab
        InputOutput io;
        io = IOProvider.getDefault().getIO("Cucumber", false);
        io.select();
        OutputWriter outputWriter;
        outputWriter = io.getOut();

        // TODO -> The "MAIN" function
        // OutputStream should be new file (same file) not System.out, currently output window
        Parser p = new Parser(new PrettyFormatter(outputWriter, true));
        Lexer l = new I18nLexer(p);

        // args[0] -> fileName
        CharSequence input = null;
        try {
            input = FixJava.readReader(new FileReader(fileName));
        } catch (FileNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        l.scan(input);
    }
}

