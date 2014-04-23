package scj.adfg;


import static javax.safetycritical.annotate.Scope.CALLER;
import static javax.safetycritical.annotate.Scope.UNKNOWN;

import javax.safetycritical.annotate.RunsIn;
import javax.safetycritical.annotate.SCJAllowed;
import javax.safetycritical.annotate.Scope;

@SCJAllowed(members=true)
@Scope("MISSION")
public interface OutputPort {

	/**
	 * Insert the value in the channel.
	 * @param value the non-null value to be pushed in the channel.
	 */
	@RunsIn(CALLER)
	public void set(@Scope(UNKNOWN) final Capsule value);
	
	/**
	 * Insert many values in the channel.
	 * @param values the non-null values to be pushed in the channel.
	 */
	@RunsIn(CALLER)
	public void set(@Scope(UNKNOWN) final Capsule[] values);
	
}
