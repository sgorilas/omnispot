package com.kesdip.designer.properties;

import java.util.List;

import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.kesdip.designer.model.Resource;

public class ResourceListCellEditor extends DialogCellEditor {
	private Composite parent;
	private ResourceListDialog dialog;
	
	public ResourceListCellEditor(Composite parent, int style) {
		super(parent, style);
		
		this.parent = parent;
	}

	private CLabel label;

	@Override
	protected Control createContents(Composite cell) {
		label = new CLabel(cell, SWT.CENTER);
		return label;
	}
	
	@Override
	protected void updateContents(Object value) {
		label.setText(value != null ? value.toString() : "");
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Object openDialogBox(Control cellEditorWindow) {
		dialog = new ResourceListDialog(parent.getShell());
		dialog.setValues((List<Resource>) getValue());
		int retVal = dialog.open();
		return retVal == Window.OK ? dialog.getValues() : null;
	}

}
