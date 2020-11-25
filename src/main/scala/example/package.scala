import chisel3._

package object example {
  implicit class ToMixedVecConv[T <: Data](seq: Seq[T]) {
    def toVec: Vec[T] = VecInit(seq)
  }
}
