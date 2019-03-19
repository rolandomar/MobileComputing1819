package pt.up.fc.dcc.pdm.core;

import com.google.inject.Inject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

class DocumentManagerImpl implements DocumentManager {
    private HashMap<Integer, File> resources = new HashMap<Integer, File>();

    @Inject
    public DocumentManagerImpl() {
        for(int i=1;i<=3; i++) {
            File file = new File(UUID.randomUUID().toString() + ".txt");
            writeToFile(file, "UUID: " + UUID.randomUUID().toString());
            resources.put(i, file);
        }
    }

    public synchronized HashMap<Integer, File> getResources() {
        return resources;
    }

    public synchronized void setResources(HashMap<Integer, File> resources) {
        this.resources = resources;
    }

    public synchronized void createResource(String content) {
        File file = new File(UUID.randomUUID().toString());
        writeToFile(file, content);
        this.resources.put(resources.size()+1, file);
    }

    private void writeToFile(File file, String content) {
        try {
            FileWriter fw = new FileWriter(file.getPath());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
