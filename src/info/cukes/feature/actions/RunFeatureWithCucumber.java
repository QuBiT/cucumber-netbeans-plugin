package info.cukes.feature.actions;

import info.cukes.feature.threads.FeatureThread;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.openide.loaders.DataObject;

// -> http://hulles.supersized.org/archives/11-GeeWhiz-Prolog-Part-Eight-Creating-An-NBM.html
// -> http://hulles.supersized.org/archives/7-GeeWhiz-Prolog-Part-Five-Adding-The-Compiler.html

public final class RunFeatureWithCucumber implements ActionListener {

    private final DataObject context;

    public RunFeatureWithCucumber(DataObject context) {
        this.context = context;
    }

    public void actionPerformed(ActionEvent ev) {
        Runnable runnable = new FeatureThread(context);
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
