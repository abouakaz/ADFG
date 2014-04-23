package scj.adfg;

import static javax.safetycritical.annotate.Phase.INITIALIZATION;
import static javax.safetycritical.annotate.Scope.CALLER;
import static javax.safetycritical.annotate.Scope.IMMORTAL;
import static javax.safetycritical.annotate.Scope.UNKNOWN;

import javax.realtime.MemoryArea;
import javax.safetycritical.ManagedMemory;
import javax.safetycritical.annotate.DefineScope;
import javax.safetycritical.annotate.RunsIn;
import javax.safetycritical.annotate.SCJAllowed;
import javax.safetycritical.annotate.SCJRestricted;
import javax.safetycritical.annotate.Scope;

/**
 * Lossy channels are created only at the initialization phase of the mission. They are instantiated in the mission memory.
 */

@Scope("MISSION")
@SCJAllowed(members=true)
public final class LossyChannel implements Connection{
	
	/**
	 * Temporary solution for the problem of reflection in SCJ/fiVM.
	 */
	private Capsule factory;
	
	/**
	 * The index of the entry that will be written in the next set().
	 */
	private int produceIndex=0;
	
	/**
	 * The number of items in the channel.
	 */
	private int nbItem=0;
	
	/**
	 * The last token consumed from this lossy channel.
	 */
	private Capsule lastValue;
	
	/**
	 * The size of this channel.
	 */
	private int capacity;
		
	
	/**
	 * The content of the lossy channel.
	 */
	@Scope("MISSION")
	private Capsule[] elementData;
	
	/**
     * The memoryArea of this lossy channel.
     */
	@Scope(IMMORTAL)
	@DefineScope(name="MISSION",parent="IMMORTAL")
    private final ManagedMemory thisArea =(ManagedMemory) MemoryArea.getMemoryArea(this);
	
	/**
	 * Create a lossy that contains null references.
	 * @param capacity: the size of the channel. It must be greater than zero. 
	 */
    @SCJRestricted(INITIALIZATION)
	public LossyChannel(final Capsule factory,final int capacity) {
		this.factory=factory;
	    thisArea.executeInArea(new Runnable(){
	    	@RunsIn("MISSION")
			public void run(){
	    		elementData=(Capsule[])factory.newArray(capacity);
	    		lastValue=factory.defaultValue();
	    	}
	    });
	}
    
    /**
	 * @return the size of the lossy channel.
	 */
    @RunsIn(CALLER)
	public final int size(){
		return capacity;
	}

    /**
     * Capsules are reused.
     */
	@Override
	public void set(@Scope(UNKNOWN) final Capsule value) {
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
		/* The produced element is not yet visible for the consumer */
		synchronized(this){
			produceIndex=(produceIndex+1)%capacity;
			if (nbItem<capacity) nbItem++;
		}
	}

	@Override
	public void set(Capsule[] values) {
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
	    	synchronized(this){
				produceIndex=(produceIndex+1)%capacity;
				if (nbItem<capacity) nbItem++;
			}
	    }
	}

	@Override
	@Scope(CALLER)
	@RunsIn(CALLER)
	public Capsule get() {
		if(nbItem==0) return lastValue.deepClone(); /* copy lastValue into the private memory of the caller */
		else{
			Capsule token=null;
			synchronized(this){ 
				int consumeIndex=(produceIndex-nbItem+capacity)%capacity;
				token=elementData[consumeIndex];
				nbItem--;
			}
			lastValue=token;	
			return token.deepClone();
		}
	}

	@Override
	@Scope(CALLER)
	@RunsIn(CALLER)
	public Capsule[] get(int number) {
		Capsule[] tokens=null;
		if(number!=0){
			tokens=factory.newArray(number);
			for(int i=0; i<number; i++){
				tokens[i]=get();
			}
		}
		return tokens;
	} 
	
}
