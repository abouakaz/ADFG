package scj.adfg;

import static javax.safetycritical.annotate.Scope.CALLER;
import static javax.safetycritical.annotate.Scope.UNKNOWN;

import javax.safetycritical.annotate.RunsIn;
import javax.safetycritical.annotate.SCJAllowed;
import javax.safetycritical.annotate.Scope;

/**
 *
 * Capsules are containers athat are reused to stock tokens. 
 * Method deepClone() is used to copy a capsule from a mission memory to a private memory. 
 * Method deepClone(value) is used to copy value from the private memory into an already existed capsule.
 * Both methods are synchronized (a capsule cannot be copied and modified at the same time).
 */

@SCJAllowed(members=true)
@Scope(CALLER)
public class Capsule {
	
	/**
	 * Create an array of (capacity) null references.
	 */
	@Scope(CALLER)
	@RunsIn(CALLER)
	public Capsule[] newArray(int capacity){
		return new Capsule[capacity];
	}
	
	/**
	 * Create a new instance.
	 */
	@Scope(CALLER)
	@RunsIn(CALLER)
	public Capsule newInstance(){
		return new Capsule();
	}
	
	/**
	 * Deep copy of  value to this.
	 */
	@RunsIn(CALLER)
    synchronized public void deepClone(@Scope(UNKNOWN) Capsule value){
		
	}
	
    /**
     * Deep copy of this to a new instance.
     */
    @Scope(CALLER)
    @RunsIn(CALLER)
	synchronized public Capsule deepClone(){
    	return new Capsule();
    }
    
    /**
     * Return the default value. This method is used in lossy channels: if a consumer attempts to read from an empty lossy channel and any token has already been produced, it gets the default value.
     */
    @Scope(CALLER)
    @RunsIn(CALLER)
    public Capsule defaultValue(){
    	return new Capsule();
    }

}
