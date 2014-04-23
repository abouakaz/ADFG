package adfg.diagram.expressions;

import java.util.Collections;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.options.ParsingOptions;

import adfg.diagram.part.AdfgDiagramEditorPlugin;

/**
 * @generated
 */
public class AdfgOCLFactory {

	/**
	 * @generated
	 */
	private final AdfgAbstractExpression[] expressions;

	/**
	 * @generated
	 */
	private final String[] expressionBodies;

	/**
	 * @generated
	 */
	protected AdfgOCLFactory() {
		this.expressions = new AdfgAbstractExpression[12];
		this.expressionBodies = new String[] {
				"self <> oppositeEnd \nand\nself.owner = oppositeEnd.owner\nand\nself.owner.affineRelations->forAll(r| (r.source=self implies r.target <> oppositeEnd) and (r.target=self implies r.source<>oppositeEnd))", //$NON-NLS-1$
				"self.source.sequence", //$NON-NLS-1$
				"self.target.sequence", //$NON-NLS-1$
				"self.connection.oclIsUndefined() and self.owner.oclIsKindOf(PeriodicActor)", //$NON-NLS-1$
				"self.connection.oclIsUndefined()\nand\nself.owner <> oppositeEnd.owner \nand \nself.owner.owner = oppositeEnd.owner.owner\nand \nself.owner.oclIsKindOf(PeriodicActor) \nand\n(self.owner.oclIsKindOf(PeriodicActor) or oppositeEnd.owner.oclIsKindOf(PeriodicActor))", //$NON-NLS-1$
				"self.source.sequence", //$NON-NLS-1$
				"self.target.sequence", //$NON-NLS-1$
				"self.connection.oclIsUndefined()", //$NON-NLS-1$
				"self.connection.oclIsUndefined()\nand\nself.owner <> oppositeEnd.owner \nand \nself.owner.owner = oppositeEnd.owner.owner", //$NON-NLS-1$
				"not self.name.oclIsUndefined() \nand \nself.name <> \'\' \nand \nself.owner.graphs->forAll(g| g<>self implies g.name<>self.name)", //$NON-NLS-1$
				"not self.name.oclIsUndefined() \nand \nself.name <> \'\' and \nself.owner.nodes->forAll(a| (a.oclIsKindOf(Actor) and a<>self) implies a.oclAsType(Actor).name<>self.name)", //$NON-NLS-1$
				"self.owner.oclIsKindOf(Actor) implies \n(not self.name.oclIsUndefined() \nand \nself.name <> \'\' \nand \nself.owner.ports->forAll(p| p<>self implies p.name<>self.name))", //$NON-NLS-1$
		};
	}

	/**
	 * @generated
	 */
	private static AdfgOCLFactory getInstance() {
		AdfgOCLFactory instance = AdfgDiagramEditorPlugin.getInstance()
				.getAdfgOCLFactory();
		if (instance == null) {
			AdfgDiagramEditorPlugin.getInstance().setAdfgOCLFactory(
					instance = new AdfgOCLFactory());
		}
		return instance;
	}

	/**
	 * @generated
	 */
	public static String getExpressionBody(int index) {
		return getInstance().expressionBodies[index];
	}

	/**
	 * @generated
	 */
	public static AdfgAbstractExpression getExpression(int index,
			EClassifier context, Map<String, EClassifier> environment) {
		AdfgOCLFactory cached = getInstance();
		if (index < 0 || index >= cached.expressions.length) {
			throw new IllegalArgumentException();
		}
		if (cached.expressions[index] == null) {
			cached.expressions[index] = getExpression(
					cached.expressionBodies[index],
					context,
					environment == null ? Collections
							.<String, EClassifier> emptyMap() : environment);
		}
		return cached.expressions[index];
	}

	/**
	 * This is factory method, callers are responsible to keep reference to the return value if they want to reuse parsed expression
	 * @generated
	 */
	public static AdfgAbstractExpression getExpression(String body,
			EClassifier context, Map<String, EClassifier> environment) {
		return new Expression(body, context, environment);
	}

	/**
	 * This method will become private in the next release
	 * @generated
	 */
	public static AdfgAbstractExpression getExpression(String body,
			EClassifier context) {
		return getExpression(body, context,
				Collections.<String, EClassifier> emptyMap());
	}

	/**
	 * @generated
	 */
	private static class Expression extends AdfgAbstractExpression {

		/**
		 * @generated
		 */
		private final org.eclipse.ocl.ecore.OCL oclInstance;

		/**
		 * @generated
		 */
		private OCLExpression oclExpression;

		/**
		 * @generated
		 */
		public Expression(String body, EClassifier context,
				Map<String, EClassifier> environment) {
			super(body, context);
			oclInstance = org.eclipse.ocl.ecore.OCL.newInstance();
			initCustomEnv(oclInstance.getEnvironment(), environment);
			Helper oclHelper = oclInstance.createOCLHelper();
			oclHelper.setContext(context());
			try {
				oclExpression = oclHelper.createQuery(body());
				setStatus(IStatus.OK, null, null);
			} catch (ParserException e) {
				setStatus(IStatus.ERROR, e.getMessage(), e);
			}
		}

		/**
		 * @generated
		 */
		@SuppressWarnings("rawtypes")
		protected Object doEvaluate(Object context, Map env) {
			if (oclExpression == null) {
				return null;
			}
			// on the first call, both evalEnvironment and extentMap are clear, for later we have finally, below.
			EvaluationEnvironment<?, ?, ?, ?, ?> evalEnv = oclInstance
					.getEvaluationEnvironment();
			// initialize environment
			for (Object nextKey : env.keySet()) {
				evalEnv.replace((String) nextKey, env.get(nextKey));
			}
			try {
				Object result = oclInstance.evaluate(context, oclExpression);
				return oclInstance.isInvalid(result) ? null : result;
			} finally {
				evalEnv.clear();
				oclInstance.setExtentMap(null); // clear allInstances cache, and get the oclInstance ready for the next call
			}
		}

		/**
		 * @generated
		 */
		private static void initCustomEnv(
				Environment<?, EClassifier, ?, ?, ?, EParameter, ?, ?, ?, ?, ?, ?> ecoreEnv,
				Map<String, EClassifier> environment) {
			// Use EObject as implicit root class for any object, to allow eContainer() and other EObject operations from OCL expressions
			ParsingOptions.setOption(ecoreEnv,
					ParsingOptions.implicitRootClass(ecoreEnv),
					EcorePackage.eINSTANCE.getEObject());
			for (String varName : environment.keySet()) {
				EClassifier varType = environment.get(varName);
				ecoreEnv.addElement(varName,
						createVar(ecoreEnv, varName, varType), false);
			}
		}

		/**
		 * @generated
		 */
		private static Variable createVar(
				Environment<?, EClassifier, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> ecoreEnv,
				String name, EClassifier type) {
			Variable var = EcoreFactory.eINSTANCE.createVariable();
			var.setName(name);
			var.setType(ecoreEnv.getUMLReflection().getOCLType(type));
			return var;
		}
	}
}
