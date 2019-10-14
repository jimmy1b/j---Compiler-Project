
package jminusminus;

import static jminusminus.CLConstants.*;

/**
 * The AST node for a for statement.
 */

class JForStatement extends JStatement {

	private JVariableDeclaration init;
	
	private JExpression test;
	
	private JStatement inc;
	
	private JStatement body;

    /**
     * Construct an AST node for a for statement
     * 
     * @param line
     *            line in which the if-statement occurs in the source file.
     * @param init
     *            initilization
     * @param test
     *            test expression.
     * @param inc
     *            increment expression
     * @param body
     *            statement within the loop
     */

    public JForStatement(int line, JVariableDeclaration init, JExpression test, JStatement inc, JStatement body) {
        super(line);
        this.init = init;
        this.test = test;
        this.inc = inc;
        this.body = body;
    }

    /**
     * Analyzing the for statement means analyzing its components and checking
     * that the test is boolean.
     * 
     * @param context
     *            context in which names are resolved.
     * @return the analyzed (and possibly rewritten) AST subtree.
     */

    public JStatement analyze(Context context) {
    	init = (JVariableDeclaration) init.analyze(context);
    	test = (JExpression) test.analyze(context);
    	test.type().mustMatchExpected(line(), Type.BOOLEAN);
    	
    	inc = (JStatement) inc.analyze(context);
    	body = (JStatement) body.analyze(context);
    	
        return this;
    }

    /**
     * Code generation for a for statement
     * 
     * @param output
     *            the code emitter (basically an abstraction for producing the
     *            .class file).
     */

    public void codegen(CLEmitter output) {
        init.codegen(output);
    	String testCon = output.createLabel();
    	String end = output.createLabel();
    	output.addLabel(testCon);
        test.codegen(output, end, false);
        body.codegen(output);
        inc.codegen(output);
        output.addBranchInstruction(GOTO, testCon);
        output.addLabel(end);
        
    }

    /**
     * @inheritDoc
     */

    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JForStatement line=\"%d\">\n", line());
        p.indentRight();
        p.printf("<Initialization>\n");
        p.indentRight();
        init.writeToStdOut(p);
        p.indentLeft();
        p.printf("</Initialization>\n");
        p.printf("<Test>\n");
        p.indentRight();
        test.writeToStdOut(p);
        p.indentLeft();
        p.printf("</Test>\n");
        p.printf("<Increment>\n");
        p.indentRight();
        inc.writeToStdOut(p);
        p.indentLeft();
        p.printf("</Increment>\n");
        p.printf("<Body>\n");
        p.indentRight();
        body.writeToStdOut(p);
        p.indentLeft();
        p.printf("</Body>\n");
        p.indentLeft();
        p.printf("</JForStatement>\n");
    }

}
