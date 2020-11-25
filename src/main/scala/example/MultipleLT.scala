package example

import chisel3._
import chisel3.util._

class MultipleLT(vecLength: Int, dataWidth: Int) extends Module {
  def width(n: Int): Int = {
    val m = math.log(n + 1) / math.log(2)
    math.ceil(m).toInt
  }

  val io = IO(new Bundle {
    val in = Input(Vec(vecLength, UInt(dataWidth.W)))
    val out = Output(new Bundle {
      val e = UInt(dataWidth.W)
      val i = UInt(width(vecLength).W)
    })
  })

  val result = io.in.zipWithIndex
    .map{ case (elem, idx) => MixedVecInit(elem, idx.U(width(vecLength).W)) }
    .toVec
    .reduceTree((tuple0, tuple1) => Mux(tuple0(0) < tuple1(0), tuple0, tuple1))

  io.out.e := result(0)
  io.out.i := result(1)
}
