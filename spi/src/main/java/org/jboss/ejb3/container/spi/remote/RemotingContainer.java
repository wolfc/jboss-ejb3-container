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
package org.jboss.ejb3.container.spi.remote;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.rmi.RemoteException;

/**
 * A EJB3 container which will be used outside of the JVM where the real
 * container resides. This RemotingContainer is responsible for passing on the
 * control to the remote real container
 * <p>
 *  Note that the {@link RemotingContainer} is expected to run on the client side
 *  and hence should not expect any server side components to be available during
 *  its execution
 * </p>
 *
 * TODO: Should this interface extend from java.rmi.Remote or should the
 * individual impls decide whether to extend from java.rmi.Remote?
 * 
 * @author Jaikiran Pai
 * @version $Revision: $
 */
public interface RemotingContainer extends java.rmi.Remote
{

   /**
    * Invoke on a remote container. 
    * <p>
    * Before invoking on the real container, implementations of the RemotingContainer
    * are free to pass the method invocation through a set of client side interceptors.
    * </p>
    * 
    */
   public Object invoke(Serializable sessionId, Method method, Object[] args, Class<?> businessIntf)
         throws RemoteException;
}
