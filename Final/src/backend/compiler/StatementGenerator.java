package backend.compiler;

import java.util.*;

import antlr4.CKParser;

import intermediate.symtab.*;
import intermediate.type.*;
import intermediate.type.Typespec.Form;

import static intermediate.type.Typespec.Form.*;
import static backend.compiler.Instruction.*;

/**
 * <h1>StatementGenerator</h1>
 *
 * <p>Emit code for executable statements.</p>
 *
 * <p>Copyright (c) 2020 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class StatementGenerator extends CodeGenerator
{
    /**
     * Constructor.
     * @param parent the parent generator.
     * @param compiler the compiler to use.
     */
    public StatementGenerator(CodeGenerator parent, Compiler compiler)
    {
        super(parent, compiler);
    }

    /**
     * Emit code for an assignment statement.
     * @param ctx the AssignmentStatementContext.
     */
    public void emitAssignment(CKParser.AssignmentStatementContext ctx)
    {
        CKParser.VariableContext   varCtx  = ctx.lhs().variable();
        CKParser.ExpressionContext exprCtx = ctx.rhs().expression();
        SymtabEntry varId = varCtx.entry;
        Typespec varType  = varCtx.type;
        Typespec exprType = exprCtx.type;

        // Emit code to evaluate the expression.
        compiler.visit(exprCtx);
        
        // float variable := integer constant
        if (   (varType == Predefined.realType)
            && (exprType.baseType() == Predefined.integerType)) emit(I2F);
        
        // Emit code to store the expression value into the target variable.
        emitStoreValue(varId, varId.getType());
    }

    /**
     * Emit code for an IF statement.
     * @param ctx the IfStatementContext.
     */
    public void emitIf(CKParser.IfStatementContext ctx)
    {
        Label met = new Label();
        Label end = new Label();
        compiler.visit(ctx.expression());
        emit(IFNE, met);
        if(ctx.falseStatement() != null)
        {
            compiler.visit(ctx.falseStatement());
        }
        emit(GOTO, end);
        emitLabel(met);
        compiler.visit(ctx.trueStatement());
        emitLabel(end);
    }
    
    /**
     * Emit code for a WHILE statement.
     * @param ctx the WhileStatementContext.
     */
    public void emitWhile(CKParser.WhileStatementContext ctx)
    {
        Label loopTopLabel  = new Label();
        Label loopExitLabel = new Label();

        emitLabel(loopTopLabel);

        compiler.visit(ctx.expression());
        emit(IFEQ, loopExitLabel); // if equal continue if not exit loop

        compiler.visit(ctx.statement());
        emit(GOTO, loopTopLabel);
        emitLabel(loopExitLabel);
    }
    
    /**
     * Emit code for a function call statement.
     * @param ctx the FunctionCallContext.
     */
    public void emitFunctionCall(CKParser.FunctionCallContext ctx)
    {
        emitCall(ctx.functionName().entry, ctx.argumentList());
    }
    
    /**
     * Emit a call to a procedure or a function.
     * @param routineId the routine name's symbol table entry.
     * @param argListCtx the ArgumentListContext.
     */
    private void emitCall(SymtabEntry routineId,
                          CKParser.ArgumentListContext argListCtx)
    {
        if (argListCtx != null)			//visit argument expressions
        {
        	for(int i = 0; i < argListCtx.argument().size(); i++) 
        	{
        		CKParser.ExpressionContext expression = argListCtx.argument(i).expression();
        		
        		compiler.visit(expression);
        		
        		if (expression.type == Predefined.integerType && routineId.getRoutineParameters().get(i).getType() == Predefined.realType)
        		{
        			expression.type = Predefined.realType;
        			emit(I2F);
        		} else if (expression.type == Predefined.realType && routineId.getRoutineParameters().get(i).getType() == Predefined.integerType)
        		{
        			expression.type = Predefined.integerType;
        			emit(F2I);
        		}
        	}
        }
        
        String invokeCall = routineId.getSymtab().getOwner().getName() + "/" + routineId.getName() + "(";
        
        if (routineId.getRoutineParameters() != null)			//parameters
        {
        	for (int i = 0; i < routineId.getRoutineParameters().size(); i++)
        	{
        		invokeCall = invokeCall + typeDescriptor(routineId.getRoutineParameters().get(i));
        	}
        }
        
        invokeCall = invokeCall + ")" + typeDescriptor(routineId);		
        
        emit(INVOKESTATIC, invokeCall);		// invokestatic programName/<functionName or procedureName>(paramTypes)returnType
        
        localStack.increase(INVOKESTATIC.stackUse);
    }

    /**
     * Emit code for a print statement.
     * @param ctx the PrintStatementContext.
     */
    public void emitPrint(CKParser.PrintStatementContext ctx)
    {
        emitPrint(ctx, false);
    }

    /**
     * Emit code for a call to WRITE or WRITELN.
     * @param argsCtx the WriteArgumentsContext.
     * @param needLF true if need a line feed.
     */
    private void emitPrint(CKParser.PrintStatementContext argsCtx,
                           boolean needLF)
    {
        emit(GETSTATIC, "java/lang/System/out", "Ljava/io/PrintStream;");

        // WRITELN with no arguments.
        if (argsCtx == null) 
        {
            emit(INVOKEVIRTUAL, "java/io/PrintStream.println()V");
            localStack.decrease(1);
        }
            
        // Generate code for the arguments.
        else
        {
            StringBuffer format = new StringBuffer();
            int exprCount = createWriteFormat(argsCtx, format, needLF);
            
            // Load the format string.
            emit(LDC, format.toString());
     
            emit(INVOKEVIRTUAL,
                   "java/io/PrintStream/print(Ljava/lang/String;)V");
            localStack.decrease(2);
        }
    }
    
    /**
     * Create the printf format string.
     * @param argsCtx the WriteArgumentsContext.
     * @param format the format string to create.
     * @return the count of expression arguments.
     */
    private int createWriteFormat(CKParser.PrintStatementContext printCtx,
                                  StringBuffer format, boolean needLF)
    {
        int exprCount = 0;
        format.append("\"");
        

        Typespec type = printCtx.expression().type;
        String printText = printCtx.expression().getText();
            
        // Append any literal strings.
        if (printText.charAt(0) == '\'') 
        {
            format.append(convertString(printText));
        }
                
        format.append(needLF ? "\\n\"" : "\"");
 
        return exprCount;
    }
    
    
}
