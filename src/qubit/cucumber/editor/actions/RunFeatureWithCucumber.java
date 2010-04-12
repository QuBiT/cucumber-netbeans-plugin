package qubit.cucumber.editor.actions;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.openide.loaders.DataObject;
import qubit.cucumber.editor.threads.LinuxFeatureThread;
import qubit.cucumber.editor.threads.WindowsFeatureThread;

// -> http://hulles.supersized.org/archives/11-GeeWhiz-Prolog-Part-Eight-Creating-An-NBM.html
// -> http://hulles.supersized.org/archives/7-GeeWhiz-Prolog-Part-Five-Adding-The-Compiler.html
public final class RunFeatureWithCucumber implements ActionListener {

    private final DataObject context;

    public RunFeatureWithCucumber(DataObject context) {
        this.context = context;
    }

    public void actionPerformed(ActionEvent ev) {
        this.executeRunnable(this.getRunnable());
    }

    private void executeRunnable(Runnable runnable) {
        if (runnable != null) {
            Thread thread = new Thread(runnable);
            thread.start();
        } else {
        }
    }

    private Runnable getRunnable() {
        String osName = System.getProperty("os.name");
        if (osName.contains("Windows")) {
            return new WindowsFeatureThread(context);
        } else {
            return new LinuxFeatureThread(context);
        }
    }
}
