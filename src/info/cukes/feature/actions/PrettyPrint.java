package info.cukes.feature.actions;

import info.cukes.feature.threads.PrettyPrintThread;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.openide.loaders.DataObject;

public final class PrettyPrint implements ActionListener {

    private final DataObject context;

    public PrettyPrint(DataObject context) {
        this.context = context;
    }

    public void actionPerformed(ActionEvent ev) {
        Runnable runnable = new PrettyPrintThread(context);
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
