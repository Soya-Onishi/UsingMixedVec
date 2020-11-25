import chisel3._

package object example {
  implicit class ToMixedVecConv[T <: Data : ToVec](seq: Seq[T]) {
    def toVec: Vec[T] = VecInit(seq)
  }
}
