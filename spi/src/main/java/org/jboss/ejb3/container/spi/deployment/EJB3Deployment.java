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
package org.jboss.ejb3.container.spi.deployment;

import java.util.Collection;

import org.jboss.ejb3.container.spi.EJBContainer;

/**
 * An {@link EJB3Deployment} corresponds to a deployment unit with EJB3(.x)
 * artifacts.
 * 
 * <p>
 *  An {@link EJB3Deployment} typically consists of multiple {@link EJBContainer}s,
 *  with each container representing a bean within the deployment.
 * </p>
 *
 * @author Jaikiran Pai
 * @version $Revision: $
 */
public interface EJB3Deployment
{

   /**
    * Returns the name of the {@link EJB3Deployment}
    * <p>
    *   Typically this is the "module-name" of this deployment
    * </p>
    * @return 
    */
   String getName();
   
   /**
    * @return Returns all the {@link EJBContainer}s within the scope of this {@link EJB3Deployment}.
    * Returns an empty {@link Collection} if there are no {@link EJBContainer} in this
    * deployment
    */
   Collection<EJBContainer> getEJBContainers();
   
   /**
    * Returns the {@link EJBContainer} corresponding to the EJB name.
    * <p>
    *   Returns null if there's no {@link EJBContainer} for the passed <code>ejbName</code>.
    * </p>
    * <p>
    *   A {@link EJB3Deployment} will not have more than one EJB with the same name, so this
    *   method will not resolve the <code>ejbName</code> to more than one {@link EJBContainer} 
    * </p>
    * @param ejbName The unique EJB name within the deployment
    * @return
    */
   EJBContainer getEJBContainer(String ejbName);
   
   /**
    * Adds a {@link EJBContainer} to this {@link EJB3Deployment}.
    * <p>
    *  No more than one {@link EJBContainer} can exist within a {@link EJB3Deployment}
    *  for the same EJB name. This method throws a {@link IllegalArgumentException} if
    *  this {@link EJB3Deployment} already has a {@link EJBContainer} for the EJB name
    *  returned by {@link EJBContainer#getEJBName()}  
    * </p>
    * @param ejbContainer A {@link EJBContainer} to be added to the {@link EJB3Deployment}
    * @throws IllegalArgumentException If there's already a {@link EJBContainer} in this
    *                   {@link EJB3Deployment} for the EJB name returned by {@link EJBContainer#getEJBName()}
    */
   void addContainer(EJBContainer ejbContainer) throws IllegalArgumentException;
   
   /**
    * Removes an existing {@link EJBContainer} from this {@link EJB3Deployment}
    * 
    * @param ejbContainer The {@link EJBContainer} to be removed from the {@link EJB3Deployment}
    * @throws IllegalArgumentException If the passed <code>ejbContainer</code> was not part of
    *                           this {@link EJB3Deployment}
    */
   void removeEJBContainer(EJBContainer ejbContainer) throws IllegalArgumentException;
   
}
