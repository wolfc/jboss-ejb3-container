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
 * InterceptorRegistry
 *
 * <p>
 * An {@link InterceptorRegistry} for a {@link EJBContainer} is responsible 
 * for applying any applicable interceptors to a target EJB instance during a 
 * {@link ContainerInvocationContext}. It's upto the implementations of the {@link InterceptorRegistry}
 * to get hold of the correct set of interceptors that need to be applied during the
 * invocation. 
 * </p>
 * <p>
 * The {@link InterceptorRegistry} does *not* enforce usage of any particular interceptor framework.
 * It upto the underlying implementation of this interface to use any suitable interceptor framework.
 * </p>
 * TODO: Better name for this class?
 * 
 * @author Jaikiran Pai
 * @version $Revision: $
 */
public interface InterceptorRegistry
{

   /**
    * Returns the {@link EJBContainer} to which this interceptor registry belongs
    * @return
    */
   EJBContainer getEJBContainer();
   
   /**
    * Intercepts a {@link ContainerInvocationContext}.
    * <p>
    *   This method is responsible to applying any interceptors applicable for the 
    *   <code>targetBeanContext</code> object. The <code>targetBeanContext</code> holds the EJB instance
    *   on which the {@link ContainerInvocationContext} is being done.    
    * </p>
    * @param containerInvocation The container invocation
    * @param targetBeanContext The target bean context
    * @return Returns the result of the invocation on the <code>target</code> object
    * @throws Exception If any exception occurs during intercepting of the invocation on the 
    *               <code>target</code> object
    */
   Object intercept(ContainerInvocationContext containerInvocation, BeanContext targetBeanContext) throws Exception;
   
}
