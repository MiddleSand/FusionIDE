package dev.middlesand.starbie.projects.updater;

import dev.middlesand.starbie.projects.Project;

import java.util.LinkedHashMap;

public class ProjectUpdater
{
    LinkedHashMap<String, UpdaterBase> chain = new LinkedHashMap<>();

    public ProjectUpdater(String projectRoot, String currentVersion)
    {
        // Next time we have a version to update from, put construction of chain here
    }
}
