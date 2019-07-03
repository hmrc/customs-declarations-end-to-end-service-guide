import play.core.PlayVersion
import play.sbt.PlayImport._
import sbt._

object AppDependencies {
  val bootStrapPlayVersion = "4.12.0"

  val compile = Seq(
    ws,
    "uk.gov.hmrc" %% "bootstrap-play-25" % bootStrapPlayVersion)

  val test = Seq(
    "org.pegdown" % "pegdown" % "1.6.0" % "test",
    "org.scalatest" %% "scalatest" % "3.0.5" % "test")
}
