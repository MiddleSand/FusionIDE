package dev.middlesand.starbie.projects;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Project
{
    public String rootDirectory;
    public File projectFile;
    public String projectName;


    private final static String projectFileVersion = "0.1.0-beta";

    public Project(String root, String disc, String name) throws IOException {
        if (!(new File(root + "/.fusion").exists()))
        {
            // Create files

            /*
            .fusion
                fusion_project.json
            packaged
            open
             */
            new File(root + "/.fusion").mkdirs();
            new File(root + "/packaged").mkdirs();
            new File(root + "/open").mkdirs();
            try
            {
                // create a writer
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(root + "/.fusion/fusion_project.json"));

                Map<String, Object> project = new HashMap<>();

                project.put("version_dont_touch", projectFileVersion);
                project.put("disc", disc);
                project.put("project_version", "0.1.0");
                project.put("name", name);

                projectName = name;
                // write JSON to file
                Gson gson = new Gson();
                writer.write(gson.toJson(project));

                //close the writer
                writer.close();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        rootDirectory = root;
    }

    public String getName()
    {
        return projectName;
    }
}
