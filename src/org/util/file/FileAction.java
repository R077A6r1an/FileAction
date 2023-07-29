package org.util.file;

import java.io.File;

/**
 * This Interface discribes how a File handler must work.
 * You must implement this interface to be a FileAction handler.
 * @author R077A6r1an
 * @version 1.0.0
 * @since 1.0.0
 */
public interface FileAction {
  /**
   * In this function, a handler makes a action with the file.
   * @param file The file to proceed with this action
   * @author R077A6r1an
   * @version 1.0.0
   * @since 1.0.0
   */
  void action(File file);
  /**
   * This function says, if this file should be given to the handler.
   *<p> By default, it says that all files should be passed to the handler.
   * @param file The File to test if it should be given to the handler.
   * @return boolean If the file should be given to the handler.
   * @author R077A6r1an
   * @version 1.0.0
   * @since 1.0.0
   */
  default boolean filterForAction(File file) {
    return true;
  }
}
