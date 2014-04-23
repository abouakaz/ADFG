package adfg.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

import adfg.AdfgPackage;
import adfg.diagram.edit.parts.AffineRelationNEditPart;
import adfg.diagram.edit.parts.AperiodicActorNameEditPart;
import adfg.diagram.edit.parts.ChannelIdEditPart;
import adfg.diagram.edit.parts.ChannelInitialSizeEditPart;
import adfg.diagram.edit.parts.GraphNameEditPart;
import adfg.diagram.edit.parts.InputPortName2EditPart;
import adfg.diagram.edit.parts.InputPortNameEditPart;
import adfg.diagram.edit.parts.LabelEditPart;
import adfg.diagram.edit.parts.LossyChannelSizeEditPart;
import adfg.diagram.edit.parts.OutputPortName2EditPart;
import adfg.diagram.edit.parts.OutputPortNameEditPart;
import adfg.diagram.edit.parts.PeriodicActorNameEditPart;
import adfg.diagram.edit.parts.WrappingLabel2EditPart;
import adfg.diagram.edit.parts.WrappingLabelEditPart;
import adfg.diagram.parsers.ChannelLabelExpressionLabelParser;
import adfg.diagram.parsers.ChannelLabelExpressionLabelParser1;
import adfg.diagram.parsers.ChannelLabelExpressionLabelParser2;
import adfg.diagram.parsers.LossyChannelLabelExpressionLabelParser;
import adfg.diagram.parsers.LossyChannelLabelExpressionLabelParser1;
import adfg.diagram.parsers.LossyChannelLabelExpressionLabelParser2;
import adfg.diagram.parsers.MessageFormatParser;
import adfg.diagram.part.AdfgVisualIDRegistry;

/**
 * @generated
 */
public class AdfgParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser graphName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getGraphName_5004Parser() {
		if (graphName_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { AdfgPackage.eINSTANCE
					.getGraph_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			graphName_5004Parser = parser;
		}
		return graphName_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser periodicActorName_5011Parser;

	/**
	 * @generated
	 */
	private IParser getPeriodicActorName_5011Parser() {
		if (periodicActorName_5011Parser == null) {
			EAttribute[] features = new EAttribute[] { AdfgPackage.eINSTANCE
					.getActor_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			periodicActorName_5011Parser = parser;
		}
		return periodicActorName_5011Parser;
	}

	/**
	 * @generated
	 */
	private IParser inputPortName_5009Parser;

	/**
	 * @generated
	 */
	private IParser getInputPortName_5009Parser() {
		if (inputPortName_5009Parser == null) {
			EAttribute[] features = new EAttribute[] { AdfgPackage.eINSTANCE
					.getPort_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			inputPortName_5009Parser = parser;
		}
		return inputPortName_5009Parser;
	}

	/**
	 * @generated
	 */
	private IParser outputPortName_5010Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPortName_5010Parser() {
		if (outputPortName_5010Parser == null) {
			EAttribute[] features = new EAttribute[] { AdfgPackage.eINSTANCE
					.getPort_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			outputPortName_5010Parser = parser;
		}
		return outputPortName_5010Parser;
	}

	/**
	 * @generated
	 */
	private IParser aperiodicActorName_5014Parser;

	/**
	 * @generated
	 */
	private IParser getAperiodicActorName_5014Parser() {
		if (aperiodicActorName_5014Parser == null) {
			EAttribute[] features = new EAttribute[] { AdfgPackage.eINSTANCE
					.getActor_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			aperiodicActorName_5014Parser = parser;
		}
		return aperiodicActorName_5014Parser;
	}

	/**
	 * @generated
	 */
	private IParser inputPortName_5012Parser;

	/**
	 * @generated
	 */
	private IParser getInputPortName_5012Parser() {
		if (inputPortName_5012Parser == null) {
			EAttribute[] features = new EAttribute[] { AdfgPackage.eINSTANCE
					.getPort_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			inputPortName_5012Parser = parser;
		}
		return inputPortName_5012Parser;
	}

	/**
	 * @generated
	 */
	private IParser outputPortName_5013Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPortName_5013Parser() {
		if (outputPortName_5013Parser == null) {
			EAttribute[] features = new EAttribute[] { AdfgPackage.eINSTANCE
					.getPort_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			outputPortName_5013Parser = parser;
		}
		return outputPortName_5013Parser;
	}

	/**
	 * @generated
	 */
	private IParser affineRelationNPhiD_6001Parser;

	/**
	 * @generated NOT
	 */
	private IParser getAffineRelationNPhiD_6001Parser() {
		if (affineRelationNPhiD_6001Parser == null) {
			EAttribute[] features = new EAttribute[] {
					AdfgPackage.eINSTANCE.getAffineRelation_N(),
					AdfgPackage.eINSTANCE.getAffineRelation_Phi(),
					AdfgPackage.eINSTANCE.getAffineRelation_D() };
			MessageFormatParser parser = new MessageFormatParser(features) {
				@Override
				protected Object[] getValues(EObject element) {
					Object[] values = new Object[features.length];
					for (int i = 0; i < features.length; i++) {
						values[i] = getValue(element, features[i]);
						if (features[i].equals(AdfgPackage.eINSTANCE
								.getAffineRelation_Phi())) {
							Integer v = (Integer) values[i];
							if (v == Integer.MIN_VALUE)
								values[i] = "*";
						}
					}
					return values;
				}
			};
			parser.setViewPattern("({0},{1},{2})"); //$NON-NLS-1$
			parser.setEditorPattern("({0},{1},{2})"); //$NON-NLS-1$
			parser.setEditPattern("({0},{1},{2})"); //$NON-NLS-1$
			affineRelationNPhiD_6001Parser = parser;
		}
		return affineRelationNPhiD_6001Parser;
	}

	/**
	 * @generated
	 */
	private IParser channelInitialSize_6003Parser;

	/**
	 * @generated NOT
	 */
	private IParser getChannelInitialSize_6003Parser() {
		if (channelInitialSize_6003Parser == null) {
			EAttribute[] features = new EAttribute[] {
					AdfgPackage.eINSTANCE.getChannel_Initial(),
					AdfgPackage.eINSTANCE.getConnection_Size() };
			MessageFormatParser parser = new MessageFormatParser(features) {
				@Override
				protected Object[] getValues(EObject element) {
					Object[] values = new Object[features.length];
					for (int i = 0; i < features.length; i++) {
						values[i] = getValue(element, features[i]);
						Integer v = (Integer) values[i];
						if (v < 0)
							values[i] = "*";
					}
					return values;
				}
			};
			parser.setViewPattern("({0},{1})"); //$NON-NLS-1$
			parser.setEditorPattern("({0},{1})"); //$NON-NLS-1$
			parser.setEditPattern("({0},{1})"); //$NON-NLS-1$
			channelInitialSize_6003Parser = parser;
		}
		return channelInitialSize_6003Parser;
	}

	/**
	 * @generated
	 */
	private IParser getChannelLabel_6006Parser() {
		return new ChannelLabelExpressionLabelParser1();
	}

	/**
	 * @generated
	 */
	private IParser getChannelLabel_6007Parser() {
		return new ChannelLabelExpressionLabelParser2();
	}

	/**
	 * @generated
	 */
	private IParser lossyChannelSize_6005Parser;

	/**
	 * @generated NOT
	 */
	private IParser getLossyChannelSize_6005Parser() {
		if (lossyChannelSize_6005Parser == null) {
			EAttribute[] features = new EAttribute[] { AdfgPackage.eINSTANCE
					.getConnection_Size() };
			MessageFormatParser parser = new MessageFormatParser(features) {
				@Override
				protected Object[] getValues(EObject element) {
					Object[] values = new Object[features.length];
					for (int i = 0; i < features.length; i++) {
						values[i] = getValue(element, features[i]);
						if (features[i].equals(AdfgPackage.eINSTANCE
								.getConnection_Size())) {
							Integer v = (Integer) values[i];
							if (v < 0)
								values[i] = "*";
						}
					}
					return values;
				}
			};
			;
			lossyChannelSize_6005Parser = parser;
		}
		return lossyChannelSize_6005Parser;
	}

	/**
	 * @generated
	 */
	private IParser getLossyChannelLabel_6008Parser() {
		return new LossyChannelLabelExpressionLabelParser1();
	}

	/**
	 * @generated
	 */
	private IParser getLossyChannelLabel_6009Parser() {
		return new LossyChannelLabelExpressionLabelParser2();
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case GraphNameEditPart.VISUAL_ID:
			return getGraphName_5004Parser();
		case PeriodicActorNameEditPart.VISUAL_ID:
			return getPeriodicActorName_5011Parser();
		case InputPortNameEditPart.VISUAL_ID:
			return getInputPortName_5009Parser();
		case OutputPortNameEditPart.VISUAL_ID:
			return getOutputPortName_5010Parser();
		case AperiodicActorNameEditPart.VISUAL_ID:
			return getAperiodicActorName_5014Parser();
		case InputPortName2EditPart.VISUAL_ID:
			return getInputPortName_5012Parser();
		case OutputPortName2EditPart.VISUAL_ID:
			return getOutputPortName_5013Parser();
		case AffineRelationNEditPart.VISUAL_ID:
			return getAffineRelationNPhiD_6001Parser();
		case ChannelInitialSizeEditPart.VISUAL_ID:
			return getChannelInitialSize_6003Parser();
		case ChannelIdEditPart.VISUAL_ID:
			return getChannelLabel_6006Parser();
		case LabelEditPart.VISUAL_ID:
			return getChannelLabel_6007Parser();
		case LossyChannelSizeEditPart.VISUAL_ID:
			return getLossyChannelSize_6005Parser();
		case WrappingLabelEditPart.VISUAL_ID:
			return getLossyChannelLabel_6008Parser();
		case WrappingLabel2EditPart.VISUAL_ID:
			return getLossyChannelLabel_6009Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object,
			String parserHint) {
		return ParserService.getInstance().getParser(
				new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(AdfgVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(AdfgVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (AdfgElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
