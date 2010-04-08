package qubit.cucumber.editor.format;

import gherkin.I18nLexer;
import gherkin.Lexer;
import gherkin.LexingError;
import gherkin.formatter.PrettyFormatter;
import gherkin.parser.ParseError;
import gherkin.parser.Parser;
import java.io.StringWriter;
import javax.swing.text.BadLocationException;
import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.modules.editor.indent.spi.ExtraLock;
import org.netbeans.modules.editor.indent.spi.ReformatTask;

class GherkinFormatTask implements ReformatTask {

    private final Context context;

    public GherkinFormatTask(Context context) {
        this.context = context;
    }

    public void reformat() throws BadLocationException {
        try {
            String source = context.document().getText(0, context.document().getLength());
            StringWriter reformattedWriter = new StringWriter();
            Parser parser = new Parser(new PrettyFormatter(reformattedWriter, true));
            Lexer lexer = new I18nLexer(parser);
            lexer.scan(source);

            writeSource(reformattedWriter.getBuffer().toString());
        } catch(ParseError e) {
            showError(e);
        } catch(LexingError e) {
            showError(e);
        }
    }

    private void writeSource(String reformattedSource) throws BadLocationException {
        context.document().remove(0, context.document().getLength());
        context.document().insertString(0, reformattedSource, null);
    }

    public ExtraLock reformatLock() {
        return null;
    }

    private void showError(Exception e) {
        e.printStackTrace();
        // This seems to block the IDE
        // JOptionPane.showMessageDialog(null, e, e.getMessage(), JOptionPane.ERROR_MESSAGE);
    }
}
