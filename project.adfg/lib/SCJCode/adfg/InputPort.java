package scj.adfg;


import static javax.safetycritical.annotate.Scope.CALLER;

import javax.safetycritical.annotate.RunsIn;
import javax.safetycritical.annotate.SCJAllowed;
import javax.safetycritical.annotate.Scope;

@SCJAllowed(members=true)
@Scope("MISSION")
public interface InputPort {
	
	/**
	 * Read one value from the channel.
	 * @return a deep copy of the consumed value.
	 */
	@Scope(CALLER)
	@RunsIn(CALLER)
	public Capsule get();
	
	/**
	 * Read many values form the channel.
	 * @param number the number of consumed values. It must be greater than zero.
	 * @return deep copies of consumed tokens.
	 */
	@Scope(CALLER)
	@RunsIn(CALLER)
	public Capsule[] get(int number);

}
