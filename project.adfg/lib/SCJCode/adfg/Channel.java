package scj.adfg;

import static javax.safetycritical.annotate.Phase.INITIALIZATION;
import static javax.safetycritical.annotate.Scope.IMMORTAL;
import static javax.safetycritical.annotate.Scope.CALLER;
import static javax.safetycritical.annotate.Scope.UNKNOWN;

import javax.realtime.MemoryArea;
import javax.safetycritical.ManagedMemory;
import javax.safetycritical.annotate.DefineScope;
import javax.safetycritical.annotate.RunsIn;
import javax.safetycritical.annotate.SCJAllowed;
import javax.safetycritical.annotate.SCJRestricted;
import javax.safetycritical.annotate.Scope;

/**
 * Channels are created only at the initialization phase of the mission. They are instantiated in the mission memory.
 */

@Scope("MISSION")
@SCJAllowed(members=true)
public final class Channel implements Connection {
	
	/**
	 * Temporary solution for the problem of reflection in SCJ/fiVM.
	 */
	private Capsule factory; 

	/**
	 * The index of the entry that will be written in the next set().
	 */
	private int produceIndex=0;
	
	/**
	 * The index of the element that will be consumed in the next get().
	 */
	private int consumeIndex=0;
	
	/**
	 * The content of the channel.
	 */
	@Scope("MISSION")
	private Capsule[] elementData;
	
	/**
     * The memoryArea of this channel.
     */
	@Scope(IMMORTAL)
	@DefineScope(name="MISSION",parent="IMMORTAL")
    private final ManagedMemory thisArea =(ManagedMemory) MemoryArea.getMemoryArea(this);
	
	/**
	 * Create a channel that contains null references.
	 * @param capacity: the size of the channel. It must be greater than zero. 
	 */
    @SCJRestricted(INITIALIZATION)
	public Channel(final Capsule factory,final int capacity) {
		this.factory=factory;
	    thisArea.executeInArea(new Runnable(){
	    	@RunsIn("MISSION")
			public void run(){
	    		elementData=(Capsule[])factory.newArray(capacity);
	    	}
	    });
	}
    
    /**
	 * @return the size of the channel.
	 */
    @RunsIn(CALLER)
	public final int size(){
		return elementData.length;
	}

	@Override
	@Scope(CALLER)
	@RunsIn(CALLER)
	public final Capsule get() {
		Capsule token=elementData[consumeIndex].deepClone();
		consumeIndex=(consumeIndex+1)%elementData.length;
		return token;
	}

	@Override
	@Scope(CALLER)
	@RunsIn(CALLER)
	public final Capsule[] get(int number) {
		Capsule[] tokens=null;
		if(number!=0){
			tokens=factory.newArray(number);
			for(int i=0; i<number; i++){
				tokens[i]=elementData[consumeIndex].deepClone();
				consumeIndex=(consumeIndex+1)%elementData.length;
			}
		}
		return tokens;
	}

	@Override
	public final void set(@Scope(UNKNOWN) final Capsule value) {
		if(elementData[produceIndex]==null){
			thisArea.executeInArea(new Runnable(){
				@Override
				@RunsIn("MISSION")
				public void run() {
					elementData[produceIndex]=(Capsule)factory.newInstance();
				}
			});
		}
		elementData[produceIndex].deepClone(value);
		produceIndex=(produceIndex+1)%elementData.length;
		
	}
	
	@Override
	public final void set(@Scope(UNKNOWN) final Capsule[] values) {
		class RunnableSCJ implements Runnable{
			@RunsIn("MISSION") public void run() {
				elementData[produceIndex]=(Capsule)factory.newInstance();
			}
		}
		final RunnableSCJ r=new RunnableSCJ();
		
	    for(int i=0; i<values.length; i++){
	    	if(elementData[produceIndex]==null){
	    		thisArea.executeInArea(r);
	    	}
	    	elementData[produceIndex].deepClone(values[i]);
			produceIndex=(produceIndex+1)%elementData.length;
	    }
	}
	
	@Scope(CALLER)
	public String toString(){
		String str="Channel size: "+elementData.length+"; produceIndex: "+produceIndex+"; consumeIndex: "+consumeIndex+"; [ ";
		for (int i=0; i<elementData.length; i++) str+=(elementData[i]==null)?"( )":"("+elementData[i].toString()+") ";
		str+="]";
		return str;
	}
	
}
