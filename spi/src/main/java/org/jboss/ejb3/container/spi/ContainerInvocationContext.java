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

import java.lang.reflect.Method;

/**
 * ContainerInvocationContext
 * <p>
 * A {@link ContainerInvocationContext} represents an invocation to be processed by the {@link EJBContainer#invoke(ContainerInvocationContext)}
 * method. The {@link ContainerInvocationContext} holds the information about the method being invoked (on the bean proxy) and the
 * arguments being passed to the method. It also has other contextual information about the invocation.
 * </p>
 * @author Jaikiran Pai
 * @version $Revision: $
 */
public interface ContainerInvocationContext
{

   /**
    * @return Returns the method being invoked
    * 
    */
   Method getMethod();
   
   /**
    * 
    * @return Returns the arguments to be passed to the method being invoked
    */
   Object[] getArgs();
   
}
