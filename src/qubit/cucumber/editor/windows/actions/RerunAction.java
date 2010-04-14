package qubit.cucumber.editor.windows.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import org.openide.loaders.DataObject;
import org.openide.util.ImageUtilities;
import qubit.cucumber.editor.actions.RunFeatureWithCucumber;

public class RerunAction extends AbstractAction {
    private final DataObject context;

    public RerunAction(DataObject context) {
        this.context = context;
        putValue(SHORT_DESCRIPTION, "Re-run");
        putValue(SMALL_ICON, new ImageIcon(ImageUtilities.loadImage("qubit/cucumber/editor/resources/icons/rerun_button_icon.png", true)));
    }

    public void actionPerformed(ActionEvent e) {
        new RunFeatureWithCucumber(context).actionPerformed(e);
    }

    // TODO enable/remove, when action defined.
    @Override
    public boolean isEnabled() {
        return true;
    }
}
