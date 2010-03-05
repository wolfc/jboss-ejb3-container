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
import org.jboss.ejb3.container.spi.EJBInstanceManager;

/**
 *
 * <p>
 * An {@link EJBLifecycleHandler} is responsible for handling lifecycle events 
 * of the bean instance. 
 * </p>
 * <p>
 *  Typically, a {@link EJBInstanceManager} will invoke the lifecycle event callbacks
 *  on this interface (like the {@link #postConstruct(BeanContext)}). The implementations 
 *  of this interface are responsible for carrying out any appropriate actions (like invoking
 *  the @PostConstruct method on the bean instance).
 * </p>
 * @author Jaikiran Pai
 * @version $Revision: $
 */
public interface EJBLifecycleHandler
{

   /**
    * Will be called upon construction of a bean context.
    * <p>
    *  Typically, this lifecycle callback method is responsible for carrying out 
    *  any appropriate action on creation of the <code>beanContext</code>, like:
    *  <ul>
    *   <li>Dependency injection (if any) in the bean instance</li>
    *   <li> Invoking any @PostConstruct methods on the bean instance
    *   and any of the bean's interceptors.
    *   </li>
    *  </ul>
    * </p>
    * @param beanContext The {@link BeanContext}, upon whose construction, this
    *       lifecycle method was invoked 
    * @throws Exception If any exception occurs during processing the lifecycle event       
    */
   void postConstruct(BeanContext beanContext) throws Exception;

   /**
    * Will be called before destroying a bean context.
    * <p>
    *  This lifecycle callback method is responsible for carrying out 
    *  any appropriate action before the <code>beanContext</code> is destroyed, like:
    *  <ul>
    *   <li> Invoking any @PreDestroy methods on the bean instance
    *   and any of  it's interceptors</li>
    *   <li>
    *  </ul>
    * </p>
    * @param beanContext The {@link BeanContext}, before whose destruction, this
    *       lifecycle method was invoked 
    * @throws Exception If any exception occurs during processing the lifecycle event       
    */
   void preDestroy(BeanContext beanContext) throws Exception;
   
   
}
