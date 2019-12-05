package org.mockito
package scalaz

import _root_.scalaz.{ Applicative, MonadError }
import org.mockito.internal.ValueClassWrapper
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.OngoingStubbing

import scala.reflect.ClassTag

case class ScalazStubbing[F[_], T](delegate: OngoingStubbing[F[T]]) {
  def thenReturn(value: T)(implicit a: Applicative[F]): ScalazStubbing[F, T] = delegate thenReturn a.pure(value)
  def andThen(value: T)(implicit a: Applicative[F]): ScalazStubbing[F, T]    = thenReturn(value)
  def andThen(value: F[T]): ScalazStubbing[F, T]                             = delegate thenReturn value

  def thenAnswer(f: => T)(implicit F: Applicative[F]): ScalazStubbing[F, T] =
    delegate thenAnswer invocationToAnswer(_ => f).andThen(F.pure(_))
  def thenAnswer[P0: ValueClassWrapper](f: P0 => T)(implicit classTag: ClassTag[P0] = defaultClassTag[P0], F: Applicative[F]): ScalazStubbing[F, T] =
    clazz[P0] match {
      case c if c == classOf[InvocationOnMock] => delegate thenAnswer invocationToAnswer(i => f(i.asInstanceOf[P0])).andThen(F.pure(_))
      case _                                   => delegate thenAnswer functionToAnswer(f).andThen(F.pure(_))
    }
  def thenAnswer[P0: ValueClassWrapper, P1: ValueClassWrapper](f: (P0, P1) => T)(implicit F: Applicative[F]): ScalazStubbing[F, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.pure(_))

  def thenAnswer[P0: ValueClassWrapper, P1: ValueClassWrapper, P2: ValueClassWrapper](f: (P0, P1, P2) => T)(implicit F: Applicative[F]): ScalazStubbing[F, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.pure(_))

  def thenAnswer[P0: ValueClassWrapper, P1: ValueClassWrapper, P2: ValueClassWrapper, P3: ValueClassWrapper](
      f: (P0, P1, P2, P3) => T
  )(implicit F: Applicative[F]): ScalazStubbing[F, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.pure(_))

  def thenAnswer[P0: ValueClassWrapper, P1: ValueClassWrapper, P2: ValueClassWrapper, P3: ValueClassWrapper, P4: ValueClassWrapper](
      f: (P0, P1, P2, P3, P4) => T
  )(implicit F: Applicative[F]): ScalazStubbing[F, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.pure(_))

  def thenAnswer[P0: ValueClassWrapper, P1: ValueClassWrapper, P2: ValueClassWrapper, P3: ValueClassWrapper, P4: ValueClassWrapper, P5: ValueClassWrapper](
      f: (P0, P1, P2, P3, P4, P5) => T
  )(implicit F: Applicative[F]): ScalazStubbing[F, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.pure(_))

  def thenAnswer[P0: ValueClassWrapper, P1: ValueClassWrapper, P2: ValueClassWrapper, P3: ValueClassWrapper, P4: ValueClassWrapper, P5: ValueClassWrapper, P6: ValueClassWrapper](
      f: (P0, P1, P2, P3, P4, P5, P6) => T
  )(implicit F: Applicative[F]): ScalazStubbing[F, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7) => T)(implicit F: Applicative[F]): ScalazStubbing[F, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8) => T)(implicit F: Applicative[F]): ScalazStubbing[F, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9) => T)(implicit F: Applicative[F]): ScalazStubbing[F, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper,
      P10: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10) => T)(implicit F: Applicative[F]): ScalazStubbing[F, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper,
      P10: ValueClassWrapper,
      P11: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11) => T)(implicit F: Applicative[F]): ScalazStubbing[F, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper,
      P10: ValueClassWrapper,
      P11: ValueClassWrapper,
      P12: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12) => T)(implicit F: Applicative[F]): ScalazStubbing[F, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper,
      P10: ValueClassWrapper,
      P11: ValueClassWrapper,
      P12: ValueClassWrapper,
      P13: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13) => T)(implicit F: Applicative[F]): ScalazStubbing[F, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper,
      P10: ValueClassWrapper,
      P11: ValueClassWrapper,
      P12: ValueClassWrapper,
      P13: ValueClassWrapper,
      P14: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14) => T)(implicit F: Applicative[F]): ScalazStubbing[F, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper,
      P10: ValueClassWrapper,
      P11: ValueClassWrapper,
      P12: ValueClassWrapper,
      P13: ValueClassWrapper,
      P14: ValueClassWrapper,
      P15: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15) => T)(implicit F: Applicative[F]): ScalazStubbing[F, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper,
      P10: ValueClassWrapper,
      P11: ValueClassWrapper,
      P12: ValueClassWrapper,
      P13: ValueClassWrapper,
      P14: ValueClassWrapper,
      P15: ValueClassWrapper,
      P16: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16) => T)(implicit F: Applicative[F]): ScalazStubbing[F, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper,
      P10: ValueClassWrapper,
      P11: ValueClassWrapper,
      P12: ValueClassWrapper,
      P13: ValueClassWrapper,
      P14: ValueClassWrapper,
      P15: ValueClassWrapper,
      P16: ValueClassWrapper,
      P17: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17) => T)(implicit F: Applicative[F]): ScalazStubbing[F, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper,
      P10: ValueClassWrapper,
      P11: ValueClassWrapper,
      P12: ValueClassWrapper,
      P13: ValueClassWrapper,
      P14: ValueClassWrapper,
      P15: ValueClassWrapper,
      P16: ValueClassWrapper,
      P17: ValueClassWrapper,
      P18: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18) => T)(implicit F: Applicative[F]): ScalazStubbing[F, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper,
      P10: ValueClassWrapper,
      P11: ValueClassWrapper,
      P12: ValueClassWrapper,
      P13: ValueClassWrapper,
      P14: ValueClassWrapper,
      P15: ValueClassWrapper,
      P16: ValueClassWrapper,
      P17: ValueClassWrapper,
      P18: ValueClassWrapper,
      P19: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19) => T)(implicit F: Applicative[F]): ScalazStubbing[F, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper,
      P10: ValueClassWrapper,
      P11: ValueClassWrapper,
      P12: ValueClassWrapper,
      P13: ValueClassWrapper,
      P14: ValueClassWrapper,
      P15: ValueClassWrapper,
      P16: ValueClassWrapper,
      P17: ValueClassWrapper,
      P18: ValueClassWrapper,
      P19: ValueClassWrapper,
      P20: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20) => T)(implicit F: Applicative[F]): ScalazStubbing[F, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper,
      P10: ValueClassWrapper,
      P11: ValueClassWrapper,
      P12: ValueClassWrapper,
      P13: ValueClassWrapper,
      P14: ValueClassWrapper,
      P15: ValueClassWrapper,
      P16: ValueClassWrapper,
      P17: ValueClassWrapper,
      P18: ValueClassWrapper,
      P19: ValueClassWrapper,
      P20: ValueClassWrapper,
      P21: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21) => T)(implicit F: Applicative[F]): ScalazStubbing[F, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.pure(_))

//  (2 to 22).foreach { fn =>
//    val args = 0 until fn
//    print(s"""
//             |def thenAnswer[${args.map(a => s"P$a: ValueClassWrapper").mkString(",")}](f: (${args.map(a => s"P$a").mkString(",")}) => T)(implicit F: Applicative[F]): ScalazStubbing[F, T] =
//             |    delegate thenAnswer functionToAnswer(f).andThen(F.pure(_))
//             |""".stripMargin)
//  }

  def thenFailWith[E](error: E)(implicit ae: MonadError[F, _ >: E]): ScalazStubbing[F, T] =
    delegate thenReturn ae.raiseError[T](error)

  def getMock[M]: M = delegate.getMock[M]
}

object ScalazStubbing {
  implicit def toScalazStubbing[F[_], T](v: OngoingStubbing[F[T]]): ScalazStubbing[F, T] = ScalazStubbing(v)

  implicit def toMock[F[_], T, M](s: ScalazStubbing[F, T]): M = s.getMock[M]
}

case class ScalazStubbing2[F[_], G[_], T](delegate: OngoingStubbing[F[G[T]]]) {
  def thenReturn(value: T)(implicit af: Applicative[F], ag: Applicative[G]): ScalazStubbing2[F, G, T] =
    delegate thenReturn af.compose[G].pure(value)
  def andThen(value: T)(implicit af: Applicative[F], ag: Applicative[G]): ScalazStubbing2[F, G, T] = thenReturn(value)
  def andThen(value: G[T])(implicit af: Applicative[F]): ScalazStubbing2[F, G, T]                  = delegate thenReturn af.pure(value)
  def andThen(value: F[G[T]]): ScalazStubbing2[F, G, T]                                            = delegate thenReturn value

  def thenAnswer(f: => T)(implicit F: Applicative[F], G: Applicative[G]): ScalazStubbing2[F, G, T] =
    delegate thenAnswer invocationToAnswer(_ => f).andThen(F.compose[G].pure(_))
  def thenAnswer[P0: ValueClassWrapper](f: P0 => T)(implicit classTag: ClassTag[P0] = defaultClassTag[P0], F: Applicative[F], G: Applicative[G]): ScalazStubbing2[F, G, T] =
    clazz[P0] match {
      case c if c == classOf[InvocationOnMock] =>
        delegate thenAnswer invocationToAnswer(i => f(i.asInstanceOf[P0])).andThen(F.compose[G].pure(_))
      case _ =>
        delegate thenAnswer functionToAnswer(f).andThen(F.compose[G].pure(_))
    }
  def thenAnswer[P0: ValueClassWrapper, P1: ValueClassWrapper](f: (P0, P1) => T)(implicit F: Applicative[F], G: Applicative[G]): ScalazStubbing2[F, G, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.compose[G].pure(_))

  def thenAnswer[P0: ValueClassWrapper, P1: ValueClassWrapper, P2: ValueClassWrapper](
      f: (P0, P1, P2) => T
  )(implicit F: Applicative[F], G: Applicative[G]): ScalazStubbing2[F, G, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.compose[G].pure(_))

  def thenAnswer[P0: ValueClassWrapper, P1: ValueClassWrapper, P2: ValueClassWrapper, P3: ValueClassWrapper](
      f: (P0, P1, P2, P3) => T
  )(implicit F: Applicative[F], G: Applicative[G]): ScalazStubbing2[F, G, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.compose[G].pure(_))

  def thenAnswer[P0: ValueClassWrapper, P1: ValueClassWrapper, P2: ValueClassWrapper, P3: ValueClassWrapper, P4: ValueClassWrapper](
      f: (P0, P1, P2, P3, P4) => T
  )(implicit F: Applicative[F], G: Applicative[G]): ScalazStubbing2[F, G, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.compose[G].pure(_))

  def thenAnswer[P0: ValueClassWrapper, P1: ValueClassWrapper, P2: ValueClassWrapper, P3: ValueClassWrapper, P4: ValueClassWrapper, P5: ValueClassWrapper](
      f: (P0, P1, P2, P3, P4, P5) => T
  )(implicit F: Applicative[F], G: Applicative[G]): ScalazStubbing2[F, G, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.compose[G].pure(_))

  def thenAnswer[P0: ValueClassWrapper, P1: ValueClassWrapper, P2: ValueClassWrapper, P3: ValueClassWrapper, P4: ValueClassWrapper, P5: ValueClassWrapper, P6: ValueClassWrapper](
      f: (P0, P1, P2, P3, P4, P5, P6) => T
  )(implicit F: Applicative[F], G: Applicative[G]): ScalazStubbing2[F, G, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.compose[G].pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7) => T)(implicit F: Applicative[F], G: Applicative[G]): ScalazStubbing2[F, G, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.compose[G].pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8) => T)(implicit F: Applicative[F], G: Applicative[G]): ScalazStubbing2[F, G, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.compose[G].pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9) => T)(implicit F: Applicative[F], G: Applicative[G]): ScalazStubbing2[F, G, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.compose[G].pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper,
      P10: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10) => T)(implicit F: Applicative[F], G: Applicative[G]): ScalazStubbing2[F, G, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.compose[G].pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper,
      P10: ValueClassWrapper,
      P11: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11) => T)(implicit F: Applicative[F], G: Applicative[G]): ScalazStubbing2[F, G, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.compose[G].pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper,
      P10: ValueClassWrapper,
      P11: ValueClassWrapper,
      P12: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12) => T)(implicit F: Applicative[F], G: Applicative[G]): ScalazStubbing2[F, G, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.compose[G].pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper,
      P10: ValueClassWrapper,
      P11: ValueClassWrapper,
      P12: ValueClassWrapper,
      P13: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13) => T)(implicit F: Applicative[F], G: Applicative[G]): ScalazStubbing2[F, G, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.compose[G].pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper,
      P10: ValueClassWrapper,
      P11: ValueClassWrapper,
      P12: ValueClassWrapper,
      P13: ValueClassWrapper,
      P14: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14) => T)(implicit F: Applicative[F], G: Applicative[G]): ScalazStubbing2[F, G, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.compose[G].pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper,
      P10: ValueClassWrapper,
      P11: ValueClassWrapper,
      P12: ValueClassWrapper,
      P13: ValueClassWrapper,
      P14: ValueClassWrapper,
      P15: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15) => T)(implicit F: Applicative[F], G: Applicative[G]): ScalazStubbing2[F, G, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.compose[G].pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper,
      P10: ValueClassWrapper,
      P11: ValueClassWrapper,
      P12: ValueClassWrapper,
      P13: ValueClassWrapper,
      P14: ValueClassWrapper,
      P15: ValueClassWrapper,
      P16: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16) => T)(implicit F: Applicative[F], G: Applicative[G]): ScalazStubbing2[F, G, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.compose[G].pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper,
      P10: ValueClassWrapper,
      P11: ValueClassWrapper,
      P12: ValueClassWrapper,
      P13: ValueClassWrapper,
      P14: ValueClassWrapper,
      P15: ValueClassWrapper,
      P16: ValueClassWrapper,
      P17: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17) => T)(implicit F: Applicative[F], G: Applicative[G]): ScalazStubbing2[F, G, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.compose[G].pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper,
      P10: ValueClassWrapper,
      P11: ValueClassWrapper,
      P12: ValueClassWrapper,
      P13: ValueClassWrapper,
      P14: ValueClassWrapper,
      P15: ValueClassWrapper,
      P16: ValueClassWrapper,
      P17: ValueClassWrapper,
      P18: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18) => T)(implicit F: Applicative[F], G: Applicative[G]): ScalazStubbing2[F, G, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.compose[G].pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper,
      P10: ValueClassWrapper,
      P11: ValueClassWrapper,
      P12: ValueClassWrapper,
      P13: ValueClassWrapper,
      P14: ValueClassWrapper,
      P15: ValueClassWrapper,
      P16: ValueClassWrapper,
      P17: ValueClassWrapper,
      P18: ValueClassWrapper,
      P19: ValueClassWrapper
  ](f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19) => T)(implicit F: Applicative[F], G: Applicative[G]): ScalazStubbing2[F, G, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.compose[G].pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper,
      P10: ValueClassWrapper,
      P11: ValueClassWrapper,
      P12: ValueClassWrapper,
      P13: ValueClassWrapper,
      P14: ValueClassWrapper,
      P15: ValueClassWrapper,
      P16: ValueClassWrapper,
      P17: ValueClassWrapper,
      P18: ValueClassWrapper,
      P19: ValueClassWrapper,
      P20: ValueClassWrapper
  ](
      f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20) => T
  )(implicit F: Applicative[F], G: Applicative[G]): ScalazStubbing2[F, G, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.compose[G].pure(_))

  def thenAnswer[
      P0: ValueClassWrapper,
      P1: ValueClassWrapper,
      P2: ValueClassWrapper,
      P3: ValueClassWrapper,
      P4: ValueClassWrapper,
      P5: ValueClassWrapper,
      P6: ValueClassWrapper,
      P7: ValueClassWrapper,
      P8: ValueClassWrapper,
      P9: ValueClassWrapper,
      P10: ValueClassWrapper,
      P11: ValueClassWrapper,
      P12: ValueClassWrapper,
      P13: ValueClassWrapper,
      P14: ValueClassWrapper,
      P15: ValueClassWrapper,
      P16: ValueClassWrapper,
      P17: ValueClassWrapper,
      P18: ValueClassWrapper,
      P19: ValueClassWrapper,
      P20: ValueClassWrapper,
      P21: ValueClassWrapper
  ](
      f: (P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21) => T
  )(implicit F: Applicative[F], G: Applicative[G]): ScalazStubbing2[F, G, T] =
    delegate thenAnswer functionToAnswer(f).andThen(F.compose[G].pure(_))

//  (2 to 22).foreach { fn =>
//    val args = 0 until fn
//    print(s"""
//             |def thenAnswer[${args.map(a => s"P$a: ValueClassWrapper").mkString(",")}](f: (${args.map(a => s"P$a").mkString(",")}) => T)(implicit F: Applicative[F], G: Applicative[G]): ScalazStubbing2[F, G, T] =
//             |    delegate thenAnswer functionToAnswer(f).andThen(F.compose[G].pure(_))
//             |""".stripMargin)
//  }

  def thenFailWith[E](error: E)(implicit ae: Applicative[F], ag: MonadError[G, _ >: E]): ScalazStubbing2[F, G, T] =
    delegate thenReturn ae.pure(ag.raiseError[T](error))

  def getMock[M]: M = delegate.getMock[M]
}

object ScalazStubbing2 {
  implicit def toScalazStubbing[F[_], G[_], T](v: OngoingStubbing[F[G[T]]]): ScalazStubbing2[F, G, T] = ScalazStubbing2(v)

  implicit def toMock[F[_], G[_], T, M](s: ScalazStubbing2[F, G, T]): M = s.getMock[M]
}
