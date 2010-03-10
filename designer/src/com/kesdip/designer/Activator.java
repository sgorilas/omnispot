package com.kesdip.designer;

import java.io.File;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.kesdip.designer.preferences.PreferenceConstants;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.kesdip.designer";

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		// make sure the MPlayer path corresponds to a valid value
		checkMPlayerPath();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	/**
	 * Check the path of MPlayer and make sure it exists. If not, set it
	 * properly, relatively to the current directory. The current directory is
	 * "c:/OmniSpot/AdminServer".
	 */
	private final void checkMPlayerPath() {
		String mPlayerPath = this.getPreferenceStore().getString(
				PreferenceConstants.P_MPLAYER_FILE);
		File mPlayerFile = new File(mPlayerPath);
		if (!mPlayerFile.isFile()) {
			mPlayerFile = new File(System.getProperty("user.dir"), "mplayer/mplayer.exe");
			this.getPreferenceStore().setValue(
					PreferenceConstants.P_MPLAYER_FILE,
					mPlayerFile.getAbsolutePath());
		}

	}
}
