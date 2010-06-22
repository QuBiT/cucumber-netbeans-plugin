package qubit.cucumber.editor.threads;

import java.util.ArrayList;
import java.util.List;
import org.openide.loaders.DataObject;

public class LinuxFeatureThread extends ExecuteFeatureThread {

    public LinuxFeatureThread(DataObject dObj) {
        super(dObj);
    }

    @Override
    public List<String> getSystemSpecificHeader() {
        return new ArrayList<String>();
    }

    @Override
    public List<String> getSystemSpecificIncludePath() {
         List<String> cmd = new ArrayList<String>();
         String fileName = getFileName();
        // allows you to use direcotries for your feature files.
        String[] split_file_name = fileName.split("/features");
        String requiredDirectory = null;
        if (!split_file_name[0].equals(fileName)) {
            requiredDirectory = split_file_name[0] + "/features";
        }
        if (requiredDirectory != null) {
            cmd.add("-r");
            cmd.add(requiredDirectory);
        }
        return cmd;
    }

    @Override
    public String getSystemSpecificChainingSymbol() {
        return ";";
    }
}

