package fr.sorbonne_u.datacenter.hardware.processors.ports;

//Copyright Jacques Malenfant, Sorbonne Universite.
//
//Jacques.Malenfant@lip6.fr
//
//This software is a computer program whose purpose is to provide a
//basic component programming model to program with components
//distributed applications in the Java programming language.
//
//This software is governed by the CeCILL-C license under French law and
//abiding by the rules of distribution of free software.  You can use,
//modify and/ or redistribute the software under the terms of the
//CeCILL-C license as circulated by CEA, CNRS and INRIA at the following
//URL "http://www.cecill.info".
//
//As a counterpart to the access to the source code and  rights to copy,
//modify and redistribute granted by the license, users are provided only
//with a limited warranty  and the software's author,  the holder of the
//economic rights,  and the successive licensors  have only  limited
//liability. 
//
//In this respect, the user's attention is drawn to the risks associated
//with loading,  using,  modifying and/or developing or reproducing the
//software by the user in light of its specific status of free software,
//that may mean  that it is complicated to manipulate,  and  that  also
//therefore means  that it is reserved for developers  and  experienced
//professionals having in-depth computer knowledge. Users are therefore
//encouraged to load and test the software's suitability as regards their
//requirements in conditions enabling the security of their systems and/or 
//data to be ensured and,  more generally, to use and operate it in the 
//same conditions as regards security. 
//
//The fact that you are presently reading this means that you have had
//knowledge of the CeCILL-C license and that you accept its terms.

import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;
import fr.sorbonne_u.datacenter.hardware.processors.interfaces.ProcessorServicesI;
import fr.sorbonne_u.datacenter.software.applicationvm.interfaces.TaskI;

/**
 * The class <code>ProcessorServicesOutboundPort</code> defines an outbound port
 * associated with the interface <code>ProcessorServicesI</code>.
 *
 * <p><strong>Description</strong></p>
 * 
 * <p><strong>Invariant</strong></p>
 * 
 * <pre>
 * invariant	true
 * </pre>
 * 
 * <p>Created on : January 19, 2015</p>
 * 
 * @author	<a href="mailto:Jacques.Malenfant@lip6.fr">Jacques Malenfant</a>
 * @version	$Name$ -- $Revision$ -- $Date$
 */
public class				ProcessorServicesOutboundPort
extends		AbstractOutboundPort
implements	ProcessorServicesI
{
	private static final long serialVersionUID = 1L;

	// ------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------

	public				ProcessorServicesOutboundPort(
		ComponentI owner
		) throws Exception
	{
		super(ProcessorServicesI.class, owner) ;

		assert	uri != null ;
	}

	public				ProcessorServicesOutboundPort(
		String uri,
		ComponentI owner
		) throws Exception
	{
		super(uri, ProcessorServicesI.class, owner) ;

		assert	uri != null ;
	}

	// ------------------------------------------------------------------------
	// Methods
	// ------------------------------------------------------------------------

	/**
	 * @see fr.sorbonne_u.datacenter.hardware.processors.interfaces.ProcessorServicesI#executeTaskOnCore(fr.sorbonne_u.datacenter.software.applicationvm.interfaces.TaskI, int)
	 */
	@Override
	public void			executeTaskOnCore(final TaskI t, final int coreNo)
	throws Exception
	{
		assert	t != null && coreNo >= 0 ;

		((ProcessorServicesI)this.connector).executeTaskOnCore(t, coreNo) ;
	}

	/**
	 * @see fr.sorbonne_u.datacenter.hardware.processors.interfaces.ProcessorServicesI#executeTaskOnCoreAndNotify(fr.sorbonne_u.datacenter.software.applicationvm.interfaces.TaskI, int, java.lang.String)
	 */
	@Override
	public void executeTaskOnCoreAndNotify(
		final TaskI t,
		final int coreNo,
		final String notificationPortURI
		) throws Exception
	{
		((ProcessorServicesI)this.connector).
				executeTaskOnCoreAndNotify(t, coreNo, notificationPortURI) ;
	}
}
