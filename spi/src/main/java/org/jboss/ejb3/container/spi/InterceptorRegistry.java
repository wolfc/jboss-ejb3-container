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

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;

/**
 * InterceptorRegistry
 *
 * <p>
 * An {@link InterceptorRegistry} for a {@link EJBContainer} is responsible 
 * for applying any applicable interceptors to a target EJB instance during a 
 * {@link ContainerInvocation}. It's upto the implementations of the {@link InterceptorRegistry}
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
    * Run the <code>targetBeanContext</code> against any applicable interceptor methods for
    * {@link PostConstruct}.
    * <p>
    *   This method is even responsible for invoking any {@link PostConstruct} method on the 
    *   target bean instance. Furthermore, this method is responsible for creating any
    *   interceptor instances corresponding to the target bean instance.
    * </p> 
    * @param targetBeanContext The {@link BeanContext} which is being processed for the {@link PostConstruct}
    *                           lifecycle
    * @throws Exception If any exception was encountered during processing the {@link PostConstruct}
    *                   for the <code>targetBeanContext</code>.
    */
   void invokePostConstruct(BeanContext targetBeanContext) throws Exception;

   /**
    * Run the <code>targetBeanContext</code> against any applicable interceptor methods for
    * {@link PreDestroy}.
    * <p>
    *   This method is even responsible for invoking any {@link PreDestroy} method on the 
    *   target bean instance. Furthermore, this method is responsible for destroying any
    *   interceptor instances corresponding to the target bean instance.
    * </p> 
    * @param targetBeanContext The {@link BeanContext} which is being processed for the {@link PreDestroy}
    *                           lifecycle
    * @throws Exception If any exception was encountered during processing the {@link PreDestroy}
    *                   for the <code>targetBeanContext</code>.
    */
   void invokePreDestroy(BeanContext targetBeanContext) throws Exception;
   
   /**
    * Run the <code>targetBeanContext</code> against any applicable interceptor methods for
    * {@link PrePassivate}.
    * <p>
    *   This method is even responsible for invoking any {@link PrePassivate} method on the 
    *   target bean instance. 
    * </p> 
    * @param targetBeanContext The {@link BeanContext} which is being processed for the {@link PrePassivate}
    *                           lifecycle
    * @throws Exception If any exception was encountered during processing the {@link PrePassivate}
    *                   for the <code>targetBeanContext</code>.
    */
   void invokePrePassivate(BeanContext targetBeanContext) throws Exception;
   
   /**
    * Run the <code>targetBeanContext</code> against any applicable interceptor methods for
    * {@link PostActivate}.
    * <p>
    *   This method is even responsible for invoking any {@link PostActivate} method on the 
    *   target bean instance. 
    * </p> 
    * @param targetBeanContext The {@link BeanContext} which is being processed for the {@link PostActivate}
    *                           lifecycle
    * @throws Exception If any exception was encountered during processing the {@link PostActivate}
    *                   for the <code>targetBeanContext</code>.
    */
   void invokePostActivate(BeanContext targetBeanContext) throws Exception;
   
   /**
    * Intercepts a {@link ContainerInvocation}.
    * <p>
    *   This method is responsible to applying any interceptors applicable for the 
    *   <code>targetBeanContext</code> object. The <code>targetBeanContext</code> holds the EJB instance
    *   on which the {@link ContainerInvocation} is being done.    
    * </p>
    * @param containerInvocation The container invocation
    * @param targetBeanContext The target bean context
    * @return Returns the result of the invocation on the <code>target</code> object
    * @throws Exception If any exception occurs during intercepting of the invocation on the 
    *               <code>target</code> object
    */
   Object intercept(ContainerInvocation containerInvocation, BeanContext targetBeanContext) throws Exception;
   
}
