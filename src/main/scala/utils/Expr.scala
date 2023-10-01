package utils

abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

object CheckExpr {
  def head(expr: Expr): String = expr match {
    case BinOp(op, left, right) => s"$op"
    case UnOp(op, arg) => s"$op"
    case _ => s"$expr"
  }

  def listMatch[T](li: List[T]) = li match {
    case List(0, _*) => "is Zero Start"
    case _ => "is not Zero start"
  }
  def isStringArray(arr: Any) = arr match {
    case a: Array[String] => true
    case _ => false
  }
}
