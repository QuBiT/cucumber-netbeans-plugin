package qubit.cucumber.editor.windows.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import org.openide.util.ImageUtilities;

public class StopAction extends AbstractAction {

    private Process process;

    public StopAction() {
        putValue(SHORT_DESCRIPTION, "Stop");
        putValue(SMALL_ICON, new ImageIcon(ImageUtilities.loadImage("qubit/cucumber/editor/resources/icons/stop_button_icon.png", true)));
    }

    public void actionPerformed(ActionEvent e) {
        if (process != null) {
            process.destroy();
            //process = null;
        }
    }

    public void setProcess(Process process) {
        this.process = process;
    }

}
