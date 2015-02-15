## Linear Algebra Playground

For the course [UT.5.02x LAFF: Linear Algebra - Foundations to Frontiers](https://courses.edx.org/courses/UTAustinX/UT.5.02x/1T2015/info)

### How to set up
It is best to clone and build breeze locally:

```scala
j@kessel in ~/wa/libs
λ git clone https://github.com/scalanlp/breeze.git
Cloning into 'breeze'...
Receiving objects: 100% (30871/30871), 24.29 MiB | 
Resolving deltas: 100% (14893/14893), done.
j@kessel in ~/wa/libs
λ cd breeze/
j@kessel in ~/wa/libs/breeze on master
λ sbt
Getting org.scala-sbt sbt 0.13...
> publishLocal
> :
> [info] 	published ivy to /Users/j/.ivy2/local/org.scalanlp/breeze-viz_2.11/0.11-SNAPSHOT/ivys/ivy.xml
> [success] Total time: 300 s, completed Feb 13, 2015 12:03:07 PM

```
The Breeze dependencies are in the local ivy cache now.
Next clone this project:

###How to run
Interactively:

```scala
λ sbt
[info] Loading global plugins from /Users/j/.sbt/0.13/plugins
> console
> [info] Starting scala interpreter...
scala> var s = DenseMatrix.rand[Double](4,4)
s: breeze.linalg.DenseMatrix[Double] =
0.28715409656397006  0.9070586159241232  0.755824806286038   0.7882020282114048
0.5228544684104055   0.320267712648032   0.0874214384542793  0.9520981554789167
0.8027140046784114   0.6331384407001712  0.6643842605696457  0.43314636840125686
0.43506611690779895  0.9280116492873614  0.681643910241972   0.5663113522410652

scala>
  
```

###Docs
Breeze [docs](https://github.com/scalanlp/breeze/wiki/Quickstart) 

A useful snippet:

All Tensors support a set of operators, similar to those used in Matlab or Numpy. See [[Linear Algebra Cheat-Sheet]] for a list of most of the operators and various operations. Some of the basic ones are reproduced here, to give you an idea.

| Operation | Breeze | Matlab | Numpy |
|---|---|---|---|
| Elementwise addition | ``a + b`` | ``a + b`` | ``a + b`` |
| Elementwise multiplication | ``a :* b`` | ``a .* b`` | ``a * b`` |
| Elementwise comparison | ``a :< b`` | ``a < b`` (gives matrix of 1/0 instead of true/false)| ``a < b`` |
| Inplace addition | ``a :+= 1.0`` | ``a += 1`` | ``a += 1`` |
| Inplace elementwise multiplication | ``a :*= 2.0`` | ``a *= 2`` | ``a *= 2`` |
| Vector dot product | ``a dot b``,``a.t * b``<sup>†</sup> | ``dot(a,b)`` | ``dot(a,b)`` |
| Elementwise sum | ``sum(a)``| ``sum(sum(a))`` | ``a.sum()`` |
| Elementwise max | ``a.max``| ``max(a)`` | ``a.max()`` |
| Elementwise argmax | ``argmax(a)``| ``argmax(a)`` | ``a.argmax()`` |
| Ceiling | ``ceil(a)``| ``ceil(a)`` | ``ceil(a)`` |
| Floor | ``floor(a)``| ``floor(a)`` | ``floor(a)`` |

### Broadcasting

Sometimes we want to apply an operation to every row or column of a matrix, as a unit. For instance, you might want to compute the mean of each row, or add a vector to every column. Adapting a matrix so that operations can be applied column-wise or row-wise is called **broadcasting**. Languages like R and numpy automatically and implicitly do broadcasting, meaning they won't stop you if you accidentally add a matrix and a vector. In Breeze, you have to signal your intent using the broadcasting operator `*`. The `*` is meant to evoke "foreach" visually. Here are some examples:

```scala
scala> import breeze.stats.mean

scala> val dm = DenseMatrix((1.0,2.0,3.0),
                            (4.0,5.0,6.0))

scala> val res = dm(::, *) + DenseVector(3.0, 4.0)
res: breeze.linalg.DenseMatrix[Double] =
4.0  5.0  6.0
8.0  9.0  10.0

scala> res(::, *) := DenseVector(3.0, 4.0)

scala> res
breeze.linalg.DenseMatrix[Double] =
3.0  3.0  3.0
4.0  4.0  4.0

scala> mean(dm(*, ::))
breeze.linalg.DenseVector[Double] = DenseVector(2.0, 5.0)
```



### References
* Linear algebra library: [Breeze](https://github.com/scalanlp/breeze)
* 3D plots from [JZY3D](http://www.jzy3d.org)
* Example from [https://github.com/retronym/jzy3d-demo](https://github.com/retronym/jzy3d-demo)