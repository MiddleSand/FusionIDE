package dev.middlesand.starbie.configuration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ApplicationSettings
{
    /**
     * Validates the settings for the application.
     * @return True if Fusion's settings are workable, false if they are not
     */
    public boolean validSettings(String rootPath)
    {
        boolean valid = true;
        // If the flag is still true, check if we need to set it to false, otherwise keep its value
        valid = valid && new File(rootPath + "/repository").exists();
        valid = valid && new File(rootPath + "/templates").exists();
        valid = valid && new File(rootPath + "/bin").exists();
        valid = valid && new File(rootPath + "/projects").exists();
        valid = valid && new File(rootPath + "/configuration").exists();
        valid = valid && new File(rootPath + "/dolphin").exists();
        valid = valid && new File(rootPath + "/backup").exists();
        valid = valid && new File(rootPath + "/backup/README.txt").exists();

        return valid;
    }

    /**
     * Initialize directories for the program - this thing has no installer, you just run it, so it has to build itself XD
     * @param rootPath Root path - Where the executable currently is
     *
     *
     *
     *
     *
     *                 L
     */
    public void initializeDirectories(String rootPath) throws IllegalArgumentException, IOException
    {
        if(!new File(rootPath).isDirectory())
        {
            throw new IllegalArgumentException("Path '" + rootPath.toString() + "' is not a directory!");
        }

        /*

        Fusion.exe
        repository // files for loading tools
            tool0.yaml
            tool1.yaml
            tooln.yaml
        templates
            default
        bin // The tools themselves
            tool1
                tool1.exe
            tool2
                tool2.exe
                tool2bin
        projects // Project directory
        configuration // YAML settings
        dolphin // Dolphin install once it is downloaded, if the user asks
        backup // Backup
            README.txt
            smg1.iso
            smg2.iso

         */

        new File(rootPath + "/repository").mkdirs();
        new File(rootPath + "/templates").mkdirs();
        new File(rootPath + "/bin").mkdirs();
        new File(rootPath + "/projects").mkdirs();
        new File(rootPath + "/configuration").mkdirs();
        new File(rootPath + "/dolphin").mkdirs();
        new File(rootPath + "/backup").mkdirs();
        File backupReadme = new File(rootPath + "/backup/README.txt");
        backupReadme.createNewFile();

        String[] readmeLines = {
                "      ==!== BIG CHONKY CAUTION ==!==",
                "  If you alter the ISOs in this directory,",
                "you will lose your ability to revert things!",
                "",
                "        Proceed at your own risk..."
        };

        BufferedWriter writer = new BufferedWriter(new FileWriter(backupReadme));

        for(String str : readmeLines)
        {
            writer.write(str);

        }

        writer.close();
    }

    public void loadFromInitializedInstance(String rootPath)
    {

    }
}
