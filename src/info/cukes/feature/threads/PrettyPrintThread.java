package info.cukes.feature.threads;

import gherkin.I18nLexer;
import gherkin.Lexer;
import gherkin.formatter.PrettyFormatter;
import gherkin.parser.Parser;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;
import org.openide.windows.IOProvider;
import org.openide.windows.InputOutput;
import org.openide.windows.OutputWriter;

public final class PrettyPrintThread implements Runnable {

    private final FileObject fileObject;

    public PrettyPrintThread(DataObject dataObject) {
        fileObject = dataObject.getPrimaryFile();
    }

    public void run() {
        try {
            // We'll keep the reformatted source in memory in case something goes wrong,
            // so we don't get an empty file (for example on parse error).
            StringWriter reformattedSource = new StringWriter();
            Parser parser = new Parser(new PrettyFormatter(reformattedSource, true));
            Lexer lexer = new I18nLexer(parser);
            lexer.scan(fileObject.asText());

            // Everything went well, write it back to the disk.

            // Getting the output stream fails when the editor buffer isn't saved.
            // Not sure how to deal with that...
            //
            // I think the best would be to not deal with file IO at all, but instead
            // get the source code from the editor buffer and write it back to the editor
            // buffer. I'm not sure how to do this though.
            Writer output = new OutputStreamWriter(fileObject.getOutputStream(), "UTF-8");
            output.write(reformattedSource.getBuffer().toString());
            output.close();
        } catch (Exception e) {
            // get an output window tab
            InputOutput io = IOProvider.getDefault().getIO("Cucumber", false);
            io.select();
            OutputWriter outputWriter = io.getOut();
            outputWriter.println(e.getMessage());
            e.printStackTrace(outputWriter);
        }
    }
}

