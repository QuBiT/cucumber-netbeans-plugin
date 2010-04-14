package qubit.cucumber.editor.threads;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import javax.swing.Action;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataObject;
import org.openide.util.Exceptions;
import org.openide.windows.OutputWriter;
import qubit.cucumber.editor.windows.CucumberOutputWindow;
import qubit.cucumber.editor.windows.actions.RerunAction;
import qubit.cucumber.editor.windows.actions.StopAction;

public abstract class ExecuteFeatureThread implements Runnable {

    private final DataObject dObj;
    private final String fileName;
    private final RerunAction rerun;
    private final StopAction stop;

    public ExecuteFeatureThread(DataObject dObj) {
        this.dObj = dObj;
        File file = FileUtil.toFile(this.dObj.getPrimaryFile());
        fileName = file.getAbsolutePath();
        rerun = new RerunAction(dObj);
        stop = new StopAction();
    }

    public abstract List<String> getCommand();

    public String getFileName() {
        return fileName;
    }

    public Action[] getActions() {
        Action[] actions = { rerun , stop };
        return actions;
    }

    public void run() {
        ProcessBuilder procBuilder;
        Process process;
        String line;
        OutputWriter outputWriter = CucumberOutputWindow.getOutputWriter(dObj.getPrimaryFile().getNameExt(), getActions());
        List<String> cmd = this.getCommand();
        procBuilder = new ProcessBuilder(cmd);
        procBuilder.redirectErrorStream(true);
        try {
            process = procBuilder.start();
            stop.setProcess(process);
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            outputWriter.printf("Output of running %s is:\n", cmd.toString());
            outputWriter.printf("--- START ---\n\n");
            while ((line = br.readLine()) != null) {
                outputWriter.println(line);
            }
            outputWriter.printf("--- END ---\n\n");
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        } finally {
            outputWriter.close();
        }
    }
}
