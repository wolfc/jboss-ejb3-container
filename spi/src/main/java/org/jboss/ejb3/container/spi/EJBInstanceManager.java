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

/**
 * EJBInstanceManager
 * <p>
 *  An {@link EJBInstanceManager} is responsible for creating/destroying bean
 *  instances.
 * </p>
 * 
 * @author Jaikiran Pai
 * @version $Revision: $
 */
public interface EJBInstanceManager
{

   /**
    * @return Creates and returns new {@link BeanContext}
    * 
    */
   BeanContext create();

   /**
    * Destroys an already created {@link BeanContext}
    * @param beanContext The {@link BeanContext} to be destroyed
    * @throws IllegalArgumentException If the <code>beanContext</code> doesn't exist
    */
   void destroy(BeanContext beanContext) throws IllegalArgumentException;

   /**
    * @return Returns the {@link EJBContainer} to which this
    * instance manager belongs
    */
   EJBContainer getEJBContainer();
}
