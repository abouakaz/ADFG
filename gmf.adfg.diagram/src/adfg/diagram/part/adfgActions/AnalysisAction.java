package adfg.diagram.part.adfgActions;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

import adfg.Graph;
import adfg.diagram.edit.parts.ApplicationEditPart;
import adfg.diagram.edit.parts.GraphEditPart;
import adfg.diagram.part.AdfgDiagramEditor;
import adfg.diagram.part.ValidateAction;
import adfg.impl.ApplicationImpl;
import adfg.impl.GraphImpl;

public class AnalysisAction extends SelectionAction{
	
	public static final String ANALYSIS = "Analysis";
	
	public AnalysisAction(IWorkbenchPart part) {
        super(part);
        setId(ANALYSIS);
        setText("Analysis");
    }

	@Override
	protected boolean calculateEnabled() {
		if(getSelectedObjects().isEmpty()) {
            return false;
        }
        for(Object selectedObject : getSelectedObjects()) {
            if(!(selectedObject instanceof GraphEditPart || selectedObject instanceof ApplicationEditPart)) {
                return false;
            }
        }
        return true;
	}
	
	@Override
	public void run() {
		AdfgDiagramEditor editor=(AdfgDiagramEditor)getWorkbenchPart();
		editor.doSave(new NullProgressMonitor());
		for(Object selectedObject : getSelectedObjects()) {
			if(selectedObject instanceof ApplicationEditPart){
				ApplicationImpl application = (ApplicationImpl) ((ApplicationEditPart)selectedObject).resolveSemanticElement();
				List<Graph> graphs=application.getGraphs();
				Iterator<Graph> itg=graphs.iterator();
				while(itg.hasNext()){
					Graph graph=itg.next();
					graph.getDataflow().analyze();
					BasicDiagnostic diagnostic=graph.getDataflow().getGraphDiagnostic();
					if (diagnostic != null)
						ValidateAction.runValidation(((ApplicationEditPart)selectedObject).getDiagramView(), diagnostic);
				}
			 }
			 else if(selectedObject instanceof GraphEditPart) {
				 GraphImpl graph = (GraphImpl) ((GraphEditPart)selectedObject).resolveSemanticElement();
				 graph.getDataflow().analyze();
				 BasicDiagnostic diagnostic=graph.getDataflow().getGraphDiagnostic();
					if (diagnostic != null){
						GraphEditPart gep=(GraphEditPart)selectedObject;
						ValidateAction.runValidation(((ApplicationEditPart)gep.getParent()).getDiagramView(), diagnostic);
					}
	         }
	     }
    }

}
