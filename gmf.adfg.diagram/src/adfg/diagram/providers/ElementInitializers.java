package adfg.diagram.providers;

import org.eclipse.emf.ecore.EcorePackage;

import adfg.AperiodicActor;
import adfg.Channel;
import adfg.Graph;
import adfg.InputPort;
import adfg.LossyChannel;
import adfg.OutputPort;
import adfg.PeriodicActor;
import adfg.diagram.expressions.AdfgAbstractExpression;
import adfg.diagram.part.AdfgDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public void init_Graph_2001(Graph instance) {
		try {
			Object value_0 = name_Graph_2001(instance);
			instance.setName((String) value_0);
			Object value_1 = id_Graph_2001(instance);

			value_1 = AdfgAbstractExpression.performCast(value_1,
					EcorePackage.eINSTANCE.getEInt());
			instance.setId(((Integer) value_1).intValue());
		} catch (RuntimeException e) {
			AdfgDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_PeriodicActor_3011(PeriodicActor instance) {
		try {
			Object value_0 = name_PeriodicActor_3011(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			AdfgDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InputPort_3012(InputPort instance) {
		try {
			Object value_0 = name_InputPort_3012(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			AdfgDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_OutputPort_3013(OutputPort instance) {
		try {
			Object value_0 = name_OutputPort_3013(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			AdfgDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_AperiodicActor_3014(AperiodicActor instance) {
		try {
			Object value_0 = name_AperiodicActor_3014(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			AdfgDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InputPort_3015(InputPort instance) {
		try {
			Object value_0 = name_InputPort_3015(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			AdfgDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_OutputPort_3016(OutputPort instance) {
		try {
			Object value_0 = name_OutputPort_3016(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			AdfgDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Channel_4005(Channel instance) {
		try {
			Object value_0 = id_Channel_4005(instance);

			value_0 = AdfgAbstractExpression.performCast(value_0,
					EcorePackage.eINSTANCE.getEInt());
			instance.setId(((Integer) value_0).intValue());
		} catch (RuntimeException e) {
			AdfgDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_LossyChannel_4007(LossyChannel instance) {
		try {
			Object value_0 = id_LossyChannel_4007(instance);

			value_0 = AdfgAbstractExpression.performCast(value_0,
					EcorePackage.eINSTANCE.getEInt());
			instance.setId(((Integer) value_0).intValue());
		} catch (RuntimeException e) {
			AdfgDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated NOT
	 */
	private String name_Graph_2001(Graph self) {
		int nb = self.getOwner().getNbGraphs();
		String res = "mission" + nb;
		self.getOwner().setNbGraphs(nb + 1);
		return res;
	}

	/**
	 * @generated NOT
	 */
	private Integer id_Graph_2001(Graph self) {
		return self.getOwner().getNbGraphs() - 1;
	}

	/**
	 * @generated NOT
	 */
	private String name_PeriodicActor_3011(PeriodicActor self) {
		int nb = self.getOwner().getNbActors();
		String res = "p_actor" + nb;
		self.getOwner().setNbActors(nb + 1);
		return res;
	}

	/**
	 * @generated NOT
	 */
	private String name_InputPort_3012(InputPort self) {
		int nb = self.getOwner().getNbPorts();
		self.getOwner().setNbPorts(nb + 1);
		return "in" + nb;
	}

	/**
	 * @generated NOT
	 */
	private String name_OutputPort_3013(OutputPort self) {
		int nb = self.getOwner().getNbPorts();
		self.getOwner().setNbPorts(nb + 1);
		return "out" + nb;
	}

	/**
	 * @generated NOT
	 */
	private String name_AperiodicActor_3014(AperiodicActor self) {
		int nb = self.getOwner().getNbActors();
		String res = "ap_actor" + nb;
		self.getOwner().setNbActors(nb + 1);
		return res;
	}

	/**
	 * @generated NOT
	 */
	private String name_InputPort_3015(InputPort self) {
		int nb = self.getOwner().getNbPorts();
		self.getOwner().setNbPorts(nb + 1);
		return "in" + nb;
	}

	/**
	 * @generated NOT
	 */
	private String name_OutputPort_3016(OutputPort self) {
		int nb = self.getOwner().getNbPorts();
		self.getOwner().setNbPorts(nb + 1);
		return "out" + nb;
	}

	/**
	 * @generated NOT
	 */
	private Integer id_Channel_4005(Channel self) {
		int nb = self.getSource().getOwner().getOwner().getNbBuffers();
		self.getSource().getOwner().getOwner().setNbBuffers(nb + 1);
		return nb;
	}

	/**
	 * @generated NOT
	 */
	private Integer id_LossyChannel_4007(LossyChannel self) {
		int nb = self.getSource().getOwner().getOwner().getNbBuffers();
		self.getSource().getOwner().getOwner().setNbBuffers(nb + 1);
		return nb;
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = AdfgDiagramEditorPlugin.getInstance()
				.getElementInitializers();
		if (cached == null) {
			AdfgDiagramEditorPlugin.getInstance().setElementInitializers(
					cached = new ElementInitializers());
		}
		return cached;
	}

}
