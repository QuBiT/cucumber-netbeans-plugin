package qubit.cucumber.editor.threads;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.Action;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataObject;
import org.openide.util.Exceptions;
import org.openide.util.NbPreferences;
import org.openide.windows.OutputWriter;
import qubit.cucumber.editor.panels.CucumberFeaturesPanel;
import qubit.cucumber.editor.windows.CucumberOutputWindow;
import qubit.cucumber.editor.windows.actions.RerunAction;
import qubit.cucumber.editor.windows.actions.StopAction;

public abstract class ExecuteFeatureThread implements Runnable {

    private final DataObject dObj;
    private final String fileName;
    private final RerunAction rerun;
    private final StopAction stop;
    private List<String> commandList;

    public ExecuteFeatureThread(DataObject dObj) {
        this.dObj = dObj;
        File file = FileUtil.toFile(this.dObj.getPrimaryFile());
        fileName = file.getAbsolutePath();
        rerun = new RerunAction(dObj);
        stop = new StopAction();
        commandList = new ArrayList<String>();
    }

    public abstract List<String> getSystemSpecificHeader();

    public abstract List<String> getSystemSpecificIncludePath();

    public String getFileName() {
        return fileName;
    }

    public Action[] getActions() {
        Action[] actions = {rerun, stop};
        return actions;
    }

    public void run() {
        ProcessBuilder procBuilder;
        Process process;
        String line;
        OutputWriter outputWriter = CucumberOutputWindow.getOutputWriter(dObj.getPrimaryFile().getNameExt(), getActions());

        commandList.addAll(this.getSystemSpecificHeader());
        commandList.addAll(this.getRubySpecificHeader());
        commandList.add("cucumber");
        commandList.addAll(this.getRecursiveOption());
        commandList.add(fileName);
        commandList.addAll(this.getOptions());

        procBuilder = new ProcessBuilder(commandList);
        procBuilder.redirectErrorStream(true);
        try {
            process = procBuilder.start();
            stop.setProcess(process);
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            outputWriter.printf("Output of running %s is:\n", commandList.toString());
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

    private List<String> getRubySpecificHeader() {
        List<String> cmd = new ArrayList<String>();
        if (shouldUseJRuby()) {
            for (String head : getJRubyCommandHeader()) {
                cmd.add(head);
            }
        }
        return cmd;
    }

    private boolean shouldUseJRuby() {
        return NbPreferences.forModule(CucumberFeaturesPanel.class).getBoolean("jRubyRadioButton", false);
    }

    private String[] getJRubyCommandHeader() {
        return "jruby -S".split(" ");
    }

    private boolean useCustomExecutionOptions() {
        return NbPreferences.forModule(CucumberFeaturesPanel.class).getBoolean("customRadioButton", false);
    }

    private boolean useRecursiveOption() {
        return NbPreferences.forModule(CucumberFeaturesPanel.class).getBoolean("recursiveOption", true);
    }

    private List<String> getRecursiveOption() {
        if(useRecursiveOption()){
            return getSystemSpecificIncludePath();
        } else
            return new ArrayList<String>();
    }

    private List<String> getOptions() {
        List<String> options = new ArrayList<String>();
        for (String opt : buildOptions()) {
            options.add(opt);
        }
        return options;
    }

    private String[] buildOptions() {
        String options;
        if (useCustomExecutionOptions()) {
            options = NbPreferences.forModule(CucumberFeaturesPanel.class).get("customOptionsTextField", "");
        } else {
            options = "-s";
        }
        return options.split(" ");
    }
}
