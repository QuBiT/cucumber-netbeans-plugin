package qubit.cucumber.editor.threads;

import java.util.ArrayList;
import java.util.List;
import org.openide.loaders.DataObject;

public class LinuxFeatureThread extends ExecuteFeatureThread {

    public LinuxFeatureThread(DataObject dObj) {
        super(dObj);
    }

    @Override
    public List<String> getCommand() {
        String fileName = getFileName();
        // allows you to use direcotries for your feature files.
        String[] split_file_name = fileName.split("/features");
        String requiredDirectory = null;
        if (!split_file_name[0].equals(fileName)) {
            requiredDirectory = split_file_name[0] + "/features";
        }
        // construct the cucumber process command
        List<String> cmd = new ArrayList<String>();
        cmd.add("cucumber");
        if (requiredDirectory != null) {
            cmd.add("-r");
            cmd.add(requiredDirectory);
        }
        cmd.add(fileName);
        cmd.add("-s");
        return cmd;
    }
}

