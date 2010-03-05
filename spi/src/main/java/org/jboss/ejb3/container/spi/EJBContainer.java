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

import java.util.List;

import javax.naming.Context;

import org.jboss.ejb3.container.spi.injection.EJBContainerENCInjector;
import org.jboss.ejb3.container.spi.injection.InstanceInjector;
import org.jboss.metadata.ejb.jboss.JBossEnterpriseBeanMetaData;

/**
 * 
 * Responsible for providing the necessary runtime infrastructure
 * for EJB3 enterprise beans. TODO: Needs more javadoc 
 *
 * @author Jaikiran Pai
 * @version $Revision: $
 */
public interface EJBContainer
{
   /**
    * @return Name of the EJB to which this container corresponds to
    */
   String getEJBName();
   
   /**
    * @return Fully qualified name of the bean implementation class
    */
   String getEJBClass();
   
   /**
    * @return Returns the metadata associated with the EJB container
    */
   // TODO: Probably in later alpha versions of container-spi, we should move
   // to a metadata-spi. Or else, its going to be difficult to support
   // jboss-metadata-ejb which is already a bit of a mess
   JBossEnterpriseBeanMetaData getMetaData();
   
   /**
    * @return Returns the {@link EJBInstanceManager} responsible for creating/destroying
    * bean instances
    */
   EJBInstanceManager getBeanInstanceManager();
   
   /**
    * @return Returns the information related to the EJB deployment from which 
    *       this container was formed. Individual implementation of {@link EJBContainer} may decide 
    *       to return null if they do not have this information  
    */
   // TODO: Needs more thinking on this one
   EJBDeploymentInfo getDeploymentInfo();
   
   /**
    * Uses the information in the passed {@link ContainerInvocation} to 
    * invoke on the target object.
    * 
    * @param containerInvocation The container invocation
    * @return Returns the result of the invocation
    * @throws Exception If something fails during the invocation 
    */
   Object invoke(ContainerInvocation containerInvocation) throws Exception;
   
   /**
    * @return Returns the {@link InterceptorRegistry} corresponding to this container.
    */
   InterceptorRegistry getInterceptorRegistry();
   
   /**
    * Returns the ENC context associated with this container
    * @return
    */
   Context getENC();
   
   /**
    * Returns the classloader associated with this container
    * @return
    */
   ClassLoader getClassLoader();
   
   void setENCInjectors(List<EJBContainerENCInjector> encInjectors);
   
   List<EJBContainerENCInjector> getENCInjectors();
   
   void setEJBInjectors(List<InstanceInjector> injectors);
   
   List<InstanceInjector> getEJBInjectors();
   
  
   
}
