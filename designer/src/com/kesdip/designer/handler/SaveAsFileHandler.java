package com.kesdip.designer.handler;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import com.kesdip.designer.model.Deployment;
import com.kesdip.designer.utils.DesignerLog;
import com.kesdip.designer.view.DeploymentView;

public class SaveAsFileHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			DeploymentView dv = (DeploymentView) PlatformUI.getWorkbench().
				getActiveWorkbenchWindow().getActivePage().
				showView("com.kesdip.designer.DeploymentView");
			Deployment deployment = dv.getDeployment();
			
			FileDialog dialog = new FileDialog(
					HandlerUtil.getActiveShell(event), SWT.SAVE | SWT.APPLICATION_MODAL);
			dialog.setFilterNames(new String[] { "Koutra Designer Files", "All files (*.*)" });
			dialog.setFilterExtensions(new String[] { "*.des.xml", "*.*" });
			String path = dialog.open();
			DesignerLog.logInfo("User entered path: " + path);

			OutputStream os = new BufferedOutputStream(new FileOutputStream(path));
			deployment.serialize(os);
			os.close();
		} catch (Exception e) {
			DesignerLog.logError("Unable to save file", e);
		}
		return null;
	}

}