package info.cukes.feature.threads;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataObject;
import org.openide.util.Exceptions;
import org.openide.windows.IOProvider;
import org.openide.windows.InputOutput;
import org.openide.windows.OutputWriter;

public class FeatureThread implements Runnable {

    private DataObject dObj = null;
    private String fileName = "";

    public FeatureThread(DataObject dObj) {
        // set DataObject and file name
        this.dObj = dObj;
        File file = FileUtil.toFile(this.dObj.getPrimaryFile());
        fileName = file.getAbsolutePath();
    }

    public void run() {
        ProcessBuilder procBuilder;
        Process process;
        Map<String, String> env;
//        File currDir;
        List<String> cmd;
        String line;
        InputOutput io;
        OutputWriter outputWriter;

        // TODO: should save file first if it's been modified

        // allows you to use direcotries for your feature files.
        String[] split_file_name = fileName.split("\\\\features");
        String requiredDirectory = null;
        if (!split_file_name[0].equals(fileName)) {
            requiredDirectory = split_file_name[0] + "\\features";
        }

        // get an output window tab
        io = IOProvider.getDefault().getIO("Cucumber", false);
        io.select();
        outputWriter = io.getOut();

        // construct the cucumber process command
        cmd = new ArrayList<String>();
        cmd.add("cmd");
        cmd.add("/C");
        cmd.add("cucumber");
        if (requiredDirectory != null) {
            cmd.add("-r");
            cmd.add(requiredDirectory);
        }
        cmd.add(fileName);
        cmd.add("-s");

        procBuilder = new ProcessBuilder(cmd);
        procBuilder.redirectErrorStream(true);
        // also s/b able to merge it into OutputWriter
//        env = procBuilder.environment();
//        env.put("VAR1", "myValue");
//        env.remove("OTHERVAR");
//        env.put("VAR2", env.get("VAR1") + "suffix");
//        currDir = procBuilder.directory();
//        if (currDir != null) {
//            System.out.printf("Current directory is %s.", currDir.toString());
//        }
//        procBuilder.directory(new File("myDir"));
        try {
            process = procBuilder.start();
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            // TODO: might want to clear the output window first...
            outputWriter.printf("--- START ---\n\n");
            outputWriter.printf("Output of running %s is:\n\n", cmd.toString());
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

