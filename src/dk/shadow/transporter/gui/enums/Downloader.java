package dk.shadow.transporter.gui.enums;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public enum Downloader {
    LABY4("https://github.com/TFSMads/transporter/releases/download/v2.0/transporter-laby4.jar", "\\AppData\\Roaming\\.minecraft\\labymod-neo\\addons", "transporter-laby4.jar"),
    LABY3_V1_16_5("https://github.com/TFSMads/transporter/releases/download/v2.0/transporter-laby3_v1_16_5.jar", "\\AppData\\Roaming\\.minecraft\\LabyMod\\addons-1.16", "transporter-laby3_v1_16_5.jar"),
    LABY3_V1_12_2("https://github.com/TFSMads/transporter/releases/download/v2.0/transporter-laby3_v1_12_2.jar", "\\AppData\\Roaming\\.minecraft\\LabyMod\\addons-1.12", "transporter-laby3_v1_12_2.jar"),
    LABY3_V1_8_9("https://github.com/TFSMads/transporter/releases/download/v2.0/transporter-laby3_v1_8_9.jar", "\\AppData\\Roaming\\.minecraft\\LabyMod\\addons-1.8", "transporter-laby3_v1_8_9.jar");

    private final String url;
    private final String path;
    private final String fileName;

    Downloader(String url, String path, String fileName) {
        this.url = url;
        this.path = path;
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public String getFileName() {
        return fileName;
    }

    public String getPath() {
        String separator = System.getProperty("file.separator");
        String userHome = System.getProperty("user.home");
        String normalizedPath = path.replace("\\", separator);
        return userHome + normalizedPath;
    }

    public boolean fileExists() {
        Path path = Paths.get(getPath() + getFileName());
        return Files.exists(path);
    }

    public boolean pathExists() {
        String fullPath = getPath();
        Path path = Paths.get(fullPath);
        return Files.exists(path);
    }

    public void download() throws IOException {
        File folder = new File(getPath());

        URL url = new URL(getUrl());
        Path path = Paths.get(getPath());

        try {

            /**

             I attempted to grant access to the folder by overriding the permissions, but it didn't work.
             To resolve this issue, I need to find an alternative solution.
             Steps to address the issue:
             Verify the folder location and ensure it exists.
             Check the user's permissions to modify folder permissions.
             Try an alternative approach, such as creating a new folder with desired permissions and moving the files.
             Consider using platform-specific commands or APIs for modifying folder permissions.
             Consult system documentation or seek assistance from relevant resources.
             
             */
            grantWritePermissions(folder);

            downloadAndExtractFile(url, getFileName(), path);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void downloadAndExtractFile(URL url, String fileName, Path outputFile) throws IOException {
        try (InputStream in = new BufferedInputStream(url.openStream());
             OutputStream out = Files.newOutputStream(outputFile)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }

    private void grantWritePermissions(File folder) throws IOException {
        if (folder.exists()) {
            boolean setWritableSuccess = folder.setWritable(true);
            boolean setExecutableSuccess = folder.setExecutable(true);
            if (!setWritableSuccess || !setExecutableSuccess) {
                throw new IOException("Failed to grant write and executable permissions to the folder.");
            }
        }
    }
}



