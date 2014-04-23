/**
 */
package adfg.impl;

import adfg.Actor;
import adfg.AdfgPackage;
import adfg.Port;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;



/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link adfg.impl.PortImpl#getSequence <em>Sequence</em>}</li>
 *   <li>{@link adfg.impl.PortImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link adfg.impl.PortImpl#getName <em>Name</em>}</li>
 *   <li>{@link adfg.impl.PortImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PortImpl extends EObjectImpl implements Port {
	/**
	 * The default value of the '{@link #getSequence() <em>Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequence()
	 * @generated
	 * @ordered
	 */
	protected static final String SEQUENCE_EDEFAULT = "(1)";

	/**
	 * The cached value of the '{@link #getSequence() <em>Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequence()
	 * @generated
	 * @ordered
	 */
	protected String sequence = SEQUENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Class type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AdfgPackage.Literals.PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSequence() {
		return sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequence(String newSequence) {
		String oldSequence = sequence;
		sequence = newSequence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.PORT__SEQUENCE, oldSequence, sequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor getOwner() {
		if (eContainerFeatureID() != AdfgPackage.PORT__OWNER) return null;
		return (Actor)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Actor newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, AdfgPackage.PORT__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Actor newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != AdfgPackage.PORT__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, AdfgPackage.ACTOR__PORTS, Actor.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.PORT__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.PORT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Class getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Class newType) {
		Class oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.PORT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AdfgPackage.PORT__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((Actor)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AdfgPackage.PORT__OWNER:
				return basicSetOwner(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case AdfgPackage.PORT__OWNER:
				return eInternalContainer().eInverseRemove(this, AdfgPackage.ACTOR__PORTS, Actor.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AdfgPackage.PORT__SEQUENCE:
				return getSequence();
			case AdfgPackage.PORT__OWNER:
				return getOwner();
			case AdfgPackage.PORT__NAME:
				return getName();
			case AdfgPackage.PORT__TYPE:
				return getType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AdfgPackage.PORT__SEQUENCE:
				setSequence((String)newValue);
				return;
			case AdfgPackage.PORT__OWNER:
				setOwner((Actor)newValue);
				return;
			case AdfgPackage.PORT__NAME:
				setName((String)newValue);
				return;
			case AdfgPackage.PORT__TYPE:
				setType((Class)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AdfgPackage.PORT__SEQUENCE:
				setSequence(SEQUENCE_EDEFAULT);
				return;
			case AdfgPackage.PORT__OWNER:
				setOwner((Actor)null);
				return;
			case AdfgPackage.PORT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AdfgPackage.PORT__TYPE:
				setType((Class)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AdfgPackage.PORT__SEQUENCE:
				return SEQUENCE_EDEFAULT == null ? sequence != null : !SEQUENCE_EDEFAULT.equals(sequence);
			case AdfgPackage.PORT__OWNER:
				return getOwner() != null;
			case AdfgPackage.PORT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AdfgPackage.PORT__TYPE:
				return type != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (sequence: ");
		result.append(sequence);
		result.append(", name: ");
		result.append(name);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * @generated NOT
	 * @param oldSequence is the old sequence associated to a port.
	 * @param value is a string.
	 * @return a new Sequence if value represents a sequence, otherwise return oldSequence.
	 */
    public static String stringtoSequence(String oldSequence, String value){
    	String newSequence=oldSequence;
    	if(value.matches("[0-9 ]*\\([0-9 ]+\\) *")){ 
    		String[] Str=value.split("\\("); Str[1]=Str[1].replaceAll("\\)", " ");  
    		//Str[0] is the prefix
    		String u=Str[0].trim();
    		if(u.length()>0){
    			String[] uu=u.split(" +"); 
    		    int[] prefix= new int[uu.length];
    		    for(int i=0;i<uu.length;i++) prefix[i]=Integer.parseInt(uu[i]);
    		    u="";
    		    for(int i=0; i<prefix.length-1; i++) u+=prefix[i]+" "; 
		    	u+=prefix[prefix.length-1];
    		}
    	    //Str[1] is the period
		    String v=Str[1].trim();
		    if(v.length()>0){
		    	String[] vv=v.split(" +");
			    int[] period= new int[vv.length];
			    int sum=0;
			    for(int i=0;i<vv.length;i++){ period[i]=Integer.parseInt(vv[i]); sum+=period[i]; }
			    v="(";
			    if(sum!=0){
			    	for(int i=0; i<period.length-1; i++) v+=period[i]+" ";
			    	v+=period[period.length-1]+")";
			    }
		    }
    		if(v.length()>1) newSequence=u+v;
		    
    	}
    	return newSequence;
    }
    
    /**
	 * @generated NOT
	 */
	public void setTypeDefaultValue(Class defaultValue){
		TransactionalEditingDomain domain=TransactionUtil.getEditingDomain(this);
    	SetRequest setRequest = new SetRequest(domain, this, AdfgPackage.eINSTANCE.getPort_Type(), defaultValue);
    	setRequest.setParameter("oldValue", type);
    	SetValueCommand operation = new SetValueCommand(setRequest){     		    
 		   @Override
 		   protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
 			  ((PortImpl)((SetRequest)this.getRequest()).getElementToEdit()).eSet(AdfgPackage.PORT__TYPE,((SetRequest)this.getRequest()).getValue());
 			  return CommandResult.newOKCommandResult();
 		   } 
        };
    	ICommandProxy comm = new ICommandProxy(operation);
    	comm.execute();
	}

} //PortImpl
