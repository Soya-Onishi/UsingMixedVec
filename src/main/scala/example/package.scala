import chisel3._

package object example {
  trait ToVec[T <: Data] {
    def convertToVec(seq: Seq[T]): Vec[T]
  }

  implicit def fromSeqToVec[T <: Data]: ToVec[T] = new ToVec[T] {
    override def convertToVec(seq: Seq[T]): Vec[T] = VecInit(seq)
  }

  implicit class ToMixedVecConv[T <: Data : ToVec](seq: Seq[T]) {
    def toVec: Vec[T] = implicitly[ToVec[T]].convertToVec(seq)
  }
}
