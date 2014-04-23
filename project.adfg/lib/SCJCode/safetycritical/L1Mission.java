package javax.safetycritical;

import static javax.safetycritical.annotate.Level.SUPPORT;

import javax.safetycritical.annotate.SCJAllowed;

@SCJAllowed
public abstract class L1Mission extends Mission {

	@SCJAllowed(SUPPORT)
    public PriorityScheduler getSchedule(){
		return PriorityScheduler.instance();
	}

}
