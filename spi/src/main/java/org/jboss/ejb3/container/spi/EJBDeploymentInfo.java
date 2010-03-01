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

import java.net.URL;

/**
 *
 * Provides various deployment related information of a EJB deployment  
 *
 * TODO: This one needs more thinking
 * @author Jaikiran Pai
 * @version $Revision: $
 */
public interface EJBDeploymentInfo
{

   /**
    * @return Returns the classloader associated with this EJB deployment
    */
   ClassLoader getClassLoader();
   
   /**
    * @return Returns the name of the EJB deployment
    */
   String getDeploymentName();
   
   // TODO: Is this enough/do we need this?
   /**
    * @return Returns the {@link URL} corresponding to this EJB deployment.
    *       This method may return null, if for example, the EJB deployment
    *       was constructed purely out of metadata and not a physical deployment. 
    */
   URL getDeployment();
}
