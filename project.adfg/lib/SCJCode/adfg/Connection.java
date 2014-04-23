package scj.adfg;

import javax.safetycritical.annotate.SCJAllowed;
import javax.safetycritical.annotate.Scope;

@SCJAllowed(members=true)
@Scope("MISSION")
public interface Connection extends InputPort, OutputPort {

}
