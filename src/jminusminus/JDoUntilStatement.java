
package jminusminus;

import static jminusminus.CLConstants.*;

/**
 * The AST node for a do until-statement.
 */

class JDoUntilStatement extends JStatement {


    /** The body. */
    private JStatement body;

    /** Test expression. */
    private JExpression condition;
    
    /**
     * Construct an AST node for a do until-statement given its line number, the
     * test expression, and the body.
     * 
     * @param line
     *            line in which the while-statement occurs in the source file.
     * @param condition
     *            test expression.
     * @param body
     *            the body.
     */

    public JDoUntilStatement(int line, JExpression condition, JStatement body) {
        super(line);
        this.condition = condition;
        this.body = body;
    }

    /**
     * Analysis involves analyzing the test, checking its type and analyzing the
     * body statement.
     * 
     * @param context
     *            context in which names are resolved.
     * @return the analyzed (and possibly rewritten) AST subtree.
     */

    public JDoUntilStatement analyze(Context context) {
        condition = condition.analyze(context);
        condition.type().mustMatchExpected(line(), Type.BOOLEAN);
        body = (JStatement) body.analyze(context);
        return this;
    }

    /**
     * Generate code for the while loop.
     * 
     * @param output
     *            the code emitter (basically an abstraction for producing the
     *            .class file).
     */

    public void codegen(CLEmitter output) {
    	// Need two labels
        String start = output.createLabel();
        String out = output.createLabel();
        
        //label for start of loop
        //goes through at least once
        output.addLabel(start);

        // Codegen body
        body.codegen(output);

        //leaves loop if true
        condition.codegen(output, out, true);
        
        // Unconditional jump back up to start
        output.addBranchInstruction(GOTO, start);

        // The label below and outside the loop
        output.addLabel(out);
    }

    /**
     * @inheritDoc
     */

    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JDoUntilStatement line=\"%d\">\n", line());
        p.indentRight();
        p.printf("<TestExpression>\n");
        p.indentRight();
        condition.writeToStdOut(p);
        p.indentLeft();
        p.printf("</TestExpression>\n");
        p.printf("<Body>\n");
        p.indentRight();
        body.writeToStdOut(p);
        p.indentLeft();
        p.printf("</Body>\n");
        p.indentLeft();
        p.printf("</JDoUntilStatement>\n");
    }

}