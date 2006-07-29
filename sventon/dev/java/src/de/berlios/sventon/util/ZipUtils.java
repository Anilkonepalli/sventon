/*
 * ====================================================================
 * Copyright (c) 2005-2006 Sventon Project. All rights reserved.
 *
 * This software is licensed as described in the file LICENSE, which
 * you should have received as part of this distribution. The terms
 * are also available at http://sventon.berlios.de.
 * If newer versions of this license are posted there, you may use a
 * newer version instead, at your option.
 * ====================================================================
 */
package de.berlios.sventon.util;

import de.schlichtherle.io.ArchiveDetector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.IOException;

/**
 * Utility class for handling ZIP actions.
 * Uses the <a href="https://truezip.dev.java.net/">TrueZip</a> library.
 *
 * @author jesper@users.berlios.de
 */
public final class ZipUtils {

  /**
   * Logger for this class and subclasses.
   */
  protected final Log logger = LogFactory.getLog(getClass());

  /**
   * Zips the given directory recursively.
   *
   * @param zipFile   The ZIP file instance.
   * @param directory The directory to zip.
   * @throws IOException if IO error occurs.
   */
  public void zipDir(final File zipFile, final File directory) throws IOException {
    logger.debug("Zipping directory: " + directory.getAbsolutePath());
    final de.schlichtherle.io.File file = new de.schlichtherle.io.File(zipFile);
    file.archiveCopyAllFrom(new de.schlichtherle.io.File(directory), ArchiveDetector.NULL);
    de.schlichtherle.io.File.umount();  // TODO: Is this the way to do it? Why is the method static?
  }

}