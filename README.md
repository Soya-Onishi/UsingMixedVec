# Using MixedVec as Tuple example

This is an example of using MixedVec as Tuple.  
Chisel does not have Tuple type explicitly, but there is MixedVec.  
MixedVec can contain any type for each elements unlike other general sequences like `Seq[T]` and/or `Vec[T]`.  
For example, Wire(MixedVec(UInt(4.W), UInt(8.W))) means that first element is 4bit width UInt and second element is 8bit width UInt.
