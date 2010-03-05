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

/**
 * An {@link EnterpriseDeployment} contains one or more {@link EJB3Deployment}s.
 * 
 * <p>
 *  As an example, a .ear deployment with multiple EJB .jar deployments can be represented
 *  as a {@link EnterpriseDeployment} consisting of multiple {@link EJB3Deployment} 
 * </p>
 *
 * @author Jaikiran Pai
 * @version $Revision: $
 */
public interface EnterpriseDeployment
{

   /**
    * Returns the name of the {@link EnterpriseDeployment} 
    * @return
    */
   String getName();
   
   /**
    * Returns all the {@link EJB3Deployment}s which are deployed as part of 
    * this {@link EnterpriseDeployment}. Returns an empty collection if there
    * are no such {@link EJB3Deployment}s
    * @return
    */
   Collection<EJB3Deployment> getEJB3Deployments();
   
   /**
    * Adds the passed <code>ejb3Deployment</code> to this {@link EnterpriseDeployment}
    * 
    * <p>
    *   An {@link EnterpriseDeployment} cannot have more than one {@link EJB3Deployment} with
    *   the same deployment name (which is returned by {@link EJB3Deployment#getName()}). If
    *   an {@link EJB3Deployment} already exists with the same name, in this {@link EnterpriseDeployment},
    *   then an {@link IllegalArgumentException} is thrown.
    * </p>
    * @param ejb3Deployment The {@link EJB3Deployment} to be added to this {@link EnterpriseDeployment}
    * @throws IllegalArgumentException If an {@link EJB3Deployment} with the same name as the passed 
    *                       {@link EJB3Deployment#getName()} already exists in this {@link EnterpriseDeployment}
    */
   void addEJB3Deployment(EJB3Deployment ejb3Deployment) throws IllegalArgumentException;
   
   /**
    * Removes an already existing {@link EJB3Deployment} from this {@link EnterpriseDeployment}
    * 
    * @param ejb3Deployment The {@link EJB3Deployment} to be removed from this {@link EnterpriseDeployment}
    * @throws IllegalArgumentException If the passed <code>ejb3Deployment</code> is not 
    *                               part of this {@link EnterpriseDeployment}
    */
   void removeEJB3Deployment(EJB3Deployment ejb3Deployment) throws IllegalArgumentException;
   
}
