package example

import chisel3.stage.{ChiselGeneratorAnnotation, ChiselStage}

object Main extends App {
  val annon = ChiselGeneratorAnnotation(() => new MultipleLT(4, 8))
  (new ChiselStage).execute(Array.empty, Seq(annon))
}
