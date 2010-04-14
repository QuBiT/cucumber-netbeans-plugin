package qubit.cucumber.editor.windows;

import javax.swing.Action;
import org.openide.windows.IOProvider;
import org.openide.windows.InputOutput;
import org.openide.windows.OutputWriter;

public class CucumberOutputWindow {

    public static OutputWriter getOutputWriter(String title, Action[] actions) {
        // get an output window tab
        //io = IOProvider.getDefault().getIO("Cucumber", false);
        InputOutput io = IOProvider.getDefault().getIO("Cucumber: " + title, actions);
        io.select();
        return io.getOut();
    }

}
