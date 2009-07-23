package com.kesdip.designer.parts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractTreeEditPart;
import org.eclipse.swt.graphics.Image;

import com.kesdip.designer.editor.DesignerComponentEditPolicy;
import com.kesdip.designer.model.Layout;
import com.kesdip.designer.model.ModelElement;

public class OutlineLayoutPart extends AbstractTreeEditPart implements
		PropertyChangeListener {

	public OutlineLayoutPart(Layout model) {
		super(model);
	}

	@Override
	public void activate() {
		if (!isActive()) {
			super.activate();
			((ModelElement) getModel()).addPropertyChangeListener(this);
		}
	}

	@Override
	public void deactivate() {
		if (isActive()) {
			super.deactivate();
			((ModelElement) getModel()).removePropertyChangeListener(this);
		}
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new DesignerComponentEditPolicy());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List getModelChildren() {
		return ((Layout) getModel()).getChildren();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractTreeEditPart#getImage()
	 */
	protected Image getImage() {
		return ((Layout) getModel()).getIcon();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractTreeEditPart#getText()
	 */
	protected String getText() {
		return ((Layout) getModel()).toString();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String prop = evt.getPropertyName();
		if (Layout.REGION_ADDED_PROP.equals(prop) ||
				Layout.REGION_REMOVED_PROP.equals(prop) ||
				Layout.CHILD_MOVE_UP.equals(prop) ||
				Layout.CHILD_MOVE_DOWN.equals(prop)) {
			refreshChildren();
		} else {
			refreshVisuals();
		}
	}

}
