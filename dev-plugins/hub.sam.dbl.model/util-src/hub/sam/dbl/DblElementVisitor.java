package hub.sam.dbl;


public interface DblElementVisitor {
	void visit(DblEObject object);
	void visitIdExpr(IdExpr idExpr);
}
