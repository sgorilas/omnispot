/*
 * Disclaimer:
 * Copyright 2008 - KESDIP E.P.E & Stelios Gerogiannakis - All rights reserved.
 * eof Disclaimer
 * 
 * Date: Dec 8, 2008
 * @author <a href="mailto:sgerogia@gmail.com">Stelios Gerogiannakis</a>
 */

package com.kesdip.business.logic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.kesdip.common.util.BeanUtils;

/**
 * Factory class for all {@link BaseLogicAction} descendants. Logic classes are
 * keyed on their class names.
 * 
 * @author gerogias
 */
public final class LogicFactory {

	/**
	 * The bean map.
	 */
	private Map<String, BaseLogicAction> beans = null;

	/**
	 * The singleton instance.
	 */
	private static LogicFactory instance = null;

	/**
	 * Default constructor. Private, to avoid instantiation.
	 */
	private LogicFactory() {
		beans = new HashMap<String, BaseLogicAction>();
	}

	/**
	 * @return LogicFactory the singleton instance
	 */
	public static LogicFactory getInstance() {
		if (instance == null) {
			instance = new LogicFactory();
		}
		return instance;
	}

	/**
	 * Add all beans to the map.
	 * 
	 * @param actionsBeans
	 *            the beans to process
	 */
	public void setActionBeans(Collection<BaseLogicAction> actionsBeans) {
		for (BaseLogicAction action : actionsBeans) {
			beans.put(BeanUtils.getCleanClassName(action.getClass()), action);
		}
	}

	/**
	 * @return UserLogic the instance
	 */
	public UserLogic getUserLogic() {
		return (UserLogic) beans.get(BeanUtils
				.getClassName(UserLogic.class));
	}

	/**
	 * @return CustomerLogic the instance
	 */
	public CustomerLogic getCustomerLogic() {
		return (CustomerLogic) beans.get(BeanUtils
				.getClassName(CustomerLogic.class));
	}

	/**
	 * @return AntennaLogic the instance
	 */
	public SearchLogic getSearchLogic() {
		return (SearchLogic) beans.get(BeanUtils
				.getClassName(SearchLogic.class));
	}

}
