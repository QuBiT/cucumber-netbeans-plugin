package qubit.cucumber.editor.format;

import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.modules.editor.indent.spi.ReformatTask;

public class GherkinFormatTaskFactory implements ReformatTask.Factory {

    public ReformatTask createTask(Context context) {
        return new GherkinFormatTask(context);
    }

}
