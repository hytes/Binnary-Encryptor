/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binnaryencryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author HACKER
 */
public class FileUtils {
    
    public static void main(String[] args) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            File from = fileChooser.getSelectedFile();
            JFileChooser outFile = new JFileChooser();
            outFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            outFile.showSaveDialog(outFile);
            File to = outFile.getSelectedFile();
            copyFile(from, to);
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void copyFile(File from, File to) throws IOException {
        Files.copy(from.toPath(), to.toPath().resolve(from.toPath().getFileName()),StandardCopyOption.REPLACE_EXISTING);
    }
    
  
}
