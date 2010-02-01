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
package org.jboss.ejb3.container.spi;

import java.io.Serializable;

/**
 * StatefulEJBInstanceManager
 *
 * <p>
 * A {@link StatefulEJBInstanceManager} is responsible for creating/destroying 
 * stateful bean instances
 * </p>
 * @see EJBInstanceManager
 * @author Jaikiran Pai
 * @version $Revision: $
 */
public interface StatefulEJBInstanceManager extends EJBInstanceManager
{
   /**
    * Creates and returns a {@link BeanContext} corresponding to a 
    * stateful session bean
    * 
    * @param initTypes The Class types of any init method corresponding to the stateful bean 
    * @param initValues The params values to be passed to the init method corresponding to the
    *                   stateful bean
    * @return
    */
   BeanContext create(Class<?>[] initTypes, Object initValues[]);

   /**
    * Returns the {@link BeanContext} corresponding to the passed <code>sessionId</code>
    * @param sessionId The session id of the bean context being requested for
    * @return
    * @throws IllegalArgumentException If no bean context corresponding to the passed <code>sessionId</code>
    *                               was found
    */
   // TODO: Better (custom) exception to throw instead of IllegalArgumentException?
   BeanContext get(Serializable sessionId) throws IllegalArgumentException;
   
}
