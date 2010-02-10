/*
* JBoss, Home of Professional Open Source
* Copyright 2005, JBoss Inc., and individual contributors as indicated
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
*
* This is free software; you can redistribute it and/or modify it
* under the terms of the GNU Lesser General Public License as
* published by the Free Software Foundation; either version 2.1 of
* the License, or (at your option) any later version.
*
* This software is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this software; if not, write to the Free
* Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
* 02110-1301 USA, or see the FSF site: http://www.fsf.org.
*/
package org.jboss.ejb3.container.spi.lifecycle;

import org.jboss.ejb3.container.spi.BeanContext;

/**
 * StatefulEJBLifecycleHandler
 * <p>
 *  A {@link StatefulEJBLifecycleHandler} is responsible for handling lifecycle events
 *  of a stateful bean instance.
 * </p>
 * 
 * @author Jaikiran Pai
 * @version $Revision: $
 */
public interface StatefulEJBLifecycleHandler extends EJBLifecycleHandler
{

   /**
    * Will be called before a stateful {@link BeanContext} is passivated
    * <p>
    *  Typically, this lifecycle callback method is responsible for carrying out
    *  any appropriate actions, like:
    *  <ul>
    *   <li>Invoking any @PrePassivate method on the bean instance</li>
    *  </ul>
    * </p>
    * @param beanContext The {@link BeanContext} which is being passivated
    */
   void prePassivate(BeanContext beanContext);
   
   /**
    * Will be called after a stateful {@link BeanContext} is activated.
    * <p>
    * Typically, this lifecycle callback method is responsible for carrying out
    *  any appropriate actions, like:
    *  <ul>
    *   <li>Invoking any @PostActivate method on the bean instance</li>
    *  </ul>
    * </p>
    * @param beanContext The {@link BeanContext} which was activated
    */
   void postActivate(BeanContext beanContext);
}
