package org.util.file;

import java.io.File;

/**
 * This class is responsible to run the Directory tree recursive and give to an
 * handler this file.
 * @author R077A6r1an
 * @version 1.0.0
 * @since 1.0.0
 */
public class FileRunner {
  /**
   * The handler that handles the File.
   * @author R077A6r1an
   * @version 1.0.0
   * @since 1.0.0
   */
  private FileAction handler;
  
  /**
   * The root file from where to start.
   * @author R077A6r1an
   * @version 1.0.0
   * @since 1.0.0
   */
  private File root;
  
  /**
   * Constructor for the FileActions Class.
   * @param handler The handler YOU have implemented, implementing the FileAction API.
   * @param root The root File from where to start the recursive File searching
   * @author R077A6r1an
   * @version 1.0.0
   * @since 1.0.0
   */
  public FileRunner(FileAction handler, File root) {
    this.handler = handler;
    if(!root.isDirectory()) {
      throw new IllegalArgumentException("A directory has been expected");
    }
    this.root = root;
  }
  
  /**
   * By calling this function, the FileAction searches at the root directory for Files and Directories
   * and passes all Files that the handler filter want's to the handler action function.
   * @author R077A6r1an
   * @since 1.0.0
   * @version 1.0.0
   */
  public void start() {
    this.search(this.root);  
  }
  
  /**
   * Just a private helper for searching.
   * Just hidden things for the API user.
   * @param root The File to check now
   * @author R077A6r1an
   * @version 1.0.0
   * @since 1.0.0
   */
  private void search(File root) {
    if(handler.filterForAction(root)) {
      handler.action(root);
    }
    if(root.isDirectory()) {
      File[] fs = root.listFiles();
      for(File i: fs) {
        search(i);
      }
    }
  }
  
  /**
   * Setter for the root directory to search recursive from.
   * @param root The root File from where to search for files and directories
   * @author R077A6r1an
   * @version 1.0.0
   * @since 1.0.0
   */
  public void setRoot(File root) {
    if(!root.isDirectory()) {
      throw new IllegalArgumentException("A directory has been expected");
    }
    this.root = root;
  }
  
  /**
   * This method is the getter for the root directory for recursive search for files and directories.
   * @return File The current File setted as root to search
   * @author R077A6r1an
   * @version 1.0.0
   * @since 1.0.0
   */
  public File getRoot() {
    return this.root;
  }
}
